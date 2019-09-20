package com.example.divar;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.divar.model.Advertise;
import com.example.divar.model.AdvertiseRepository;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListAllFragment extends Fragment {
    RecyclerView recyclerView;
    ListAllAdapter adapter;
    AdvertiseRepository advertiseRepository;
    public static final String TAG = "ListAllFragment";

    public static ListAllFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ListAllFragment fragment = new ListAllFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ListAllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_all, container, false);
        recyclerView = view.findViewById(R.id.recycler_all);
        advertiseRepository = AdvertiseRepository.getInstance(getActivity());
        if (adapter == null)
            adapter = new ListAllAdapter(getActivity(),advertiseRepository.getAdvertiseList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void updateUi(){
        adapter.setAdvertiseList(advertiseRepository.getAdvertiseList());
        adapter.notifyDataSetChanged();
    }

    class ListAllAdapter extends RecyclerView.Adapter<ListAllAdapter.ListAllViewHolder>{
        private Context context;
        private List<Advertise> advertiseList;

        public void setAdvertiseList(List<Advertise> advertiseList) {
            this.advertiseList = advertiseList;
        }

        public ListAllAdapter(Context context, List<Advertise> advertiseList) {
            this.context = context;
            this.advertiseList = advertiseList;
        }

        @NonNull
        @Override
        public ListAllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ListAllViewHolder(LayoutInflater.from(context).inflate(R.layout.advertise_item,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ListAllViewHolder holder, int position) {
            holder.bind(advertiseList.get(position));
        }

        @Override
        public int getItemCount() {
            return advertiseList.size();
        }

        class ListAllViewHolder extends RecyclerView.ViewHolder{
            TextView textView_title;
            TextView textView_description;
            public ListAllViewHolder(@NonNull View itemView) {
                super(itemView);
                textView_title = itemView.findViewById(R.id.title);
                textView_description = itemView.findViewById(R.id.description);
            }

            public void bind(Advertise advertise){
                textView_title.setText(advertise.getTitle());
                textView_description.setText(advertise.getDescription());
            }
        }
    }
}

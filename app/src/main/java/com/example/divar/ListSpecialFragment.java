package com.example.divar;


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
public class ListSpecialFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdvertiseRepository repository;
    private SpecialAdvertiseAdapter adapter;
    public static ListSpecialFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ListSpecialFragment fragment = new ListSpecialFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ListSpecialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_special, container, false);
        recyclerView = view.findViewById(R.id.recycler_special);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        repository = AdvertiseRepository.getInstance(getActivity());

        if (adapter == null)
            adapter = new SpecialAdvertiseAdapter(repository.getAdvertiseSpecialList());
        recyclerView.setAdapter(adapter);
        return view;
    }

    class SpecialAdvertiseAdapter extends RecyclerView.Adapter<SpecialAdvertiseAdapter.SpecialAdvertiseViewHolder>{

        private List<Advertise> advertiseList;

        public SpecialAdvertiseAdapter(List<Advertise> advertiseList) {
            this.advertiseList = advertiseList;
        }

        @NonNull
        @Override
        public SpecialAdvertiseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SpecialAdvertiseViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.advertise_item,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull SpecialAdvertiseViewHolder holder, int position) {
            holder.bind(advertiseList.get(position));
        }

        @Override
        public int getItemCount() {
            return advertiseList.size();
        }

        class SpecialAdvertiseViewHolder extends RecyclerView.ViewHolder{
            TextView textView_title;
            TextView textView_description;
            public SpecialAdvertiseViewHolder(@NonNull View itemView) {
                super(itemView);
                textView_title = itemView.findViewById(R.id.title);
                textView_description = itemView.findViewById(R.id.description);
            }

            public void bind(Advertise advertise) {
                textView_title.setText(advertise.getTitle());
                textView_description.setText(advertise.getDescription());
            }
        }
    }

}

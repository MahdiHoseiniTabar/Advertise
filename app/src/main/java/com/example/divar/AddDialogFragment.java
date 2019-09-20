package com.example.divar;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.divar.model.Advertise;
import com.example.divar.model.AdvertiseRepository;

import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddDialogFragment extends DialogFragment {

    EditText editText_title;
    EditText editText_description;
    CheckBox checkBox;

    public static AddDialogFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AddDialogFragment fragment = new AddDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public AddDialogFragment() {
        // Required empty public constructor
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_add_dialog, null);
        editText_title = view.findViewById(R.id.edit_text_title);
        editText_description = view.findViewById(R.id.edit_text_description);
        checkBox = view.findViewById(R.id.checkbox_vip);
        return new AlertDialog.Builder(getActivity())
                .setPositiveButton("add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AdvertiseRepository repository = AdvertiseRepository.getInstance(getActivity());
                        Advertise advertise = new Advertise(UUID.randomUUID(),
                                editText_title.getText().toString(),
                                editText_description.getText().toString(),
                                "",
                                "",
                                checkBox.isChecked());
                        repository.insertAdvertise(advertise);


                    }
                })
                .setView(view)
                .show();
    }
}

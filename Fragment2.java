package com.example.fragmentcommunication;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    private static final String ARG_TEXT = "arg_text";

    public static Fragment2 newInstance(String text) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment2() {
        // Constructor vacío obligatorio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        TextView textView = view.findViewById(R.id.textViewData);
        if (getArguments() != null) {
            String text = getArguments().getString(ARG_TEXT);
            textView.setText(text);
        }

        return view;
    }
}

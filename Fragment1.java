package com.example.fragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends Fragment {

    private OnFragmentInteractionListener mListener;

    public interface OnFragmentInteractionListener {
        void onSendData(String text);
    }

    public Fragment1() {
        // Constructor vacío obligatorio
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        EditText editText = view.findViewById(R.id.editText);
        Button button = view.findViewById(R.id.buttonSend);

        button.setOnClickListener(v -> {
            String text = editText.getText().toString();
            if (mListener != null) {
                mListener.onSendData(text); // Enviar datos a la Activity
            }
        });

        return view;
    }
}

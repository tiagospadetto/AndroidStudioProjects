package br.com.smartirrigation.smartirrigation.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.smartirrigation.smartirrigation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfFragment extends Fragment {


    public PerfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perf, container, false);
    }

}

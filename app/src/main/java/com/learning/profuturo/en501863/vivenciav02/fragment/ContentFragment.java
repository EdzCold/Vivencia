package com.learning.profuturo.en501863.vivenciav02.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learning.profuturo.en501863.vivenciav02.R;

/**
 * Created by EN501863 on 08/01/2018.
 */

public class ContentFragment extends Fragment {

    public ContentFragment() {

    }

    public static Fragment newInstance() {
        return new ContentFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.welcome_fragment, container, false);
    }
}

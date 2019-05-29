package com.devhwang1312.cdk360.ui.character;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.devhwang1312.cdk360.R;
import com.devhwang1312.cdk360.ui.BaseFragment;

public class FragmentCharacter extends BaseFragment {

    public static FragmentCharacter newInstance() {
        FragmentCharacter fragment = new FragmentCharacter();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_character,container,false);
    }
}

package br.com.fernando.arteaos4ventos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import br.com.fernando.arteaos4ventos.R;
import br.com.fernando.arteaos4ventos.databinding.HelpFragoneBinding;

public class HelpFragOne extends Fragment {

    private HelpFragoneBinding binding;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = HelpFragoneBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}




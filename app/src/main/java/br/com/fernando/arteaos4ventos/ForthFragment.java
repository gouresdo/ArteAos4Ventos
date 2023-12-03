package br.com.fernando.arteaos4ventos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import br.com.fernando.arteaos4ventos.R;
import br.com.fernando.arteaos4ventos.databinding.FragmetForthBinding;

public class ForthFragment extends Fragment {

    private FragmetForthBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmetForthBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RadioButton cantosN;
        RadioButton cantosS;
        cantosN = (RadioButton) view.findViewById(R.id.radioButtonN);
        cantosS = (RadioButton) view.findViewById(R.id.radioButtonS);
        binding.buttonForth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(cantosN.isChecked()){
                   MainActivity.storeData4("0");
               }
                if(cantosS.isChecked()){
                    MainActivity.storeData4("1");
                }
                NavHostFragment.findNavController(ForthFragment.this)
                        .navigate(R.id.action_ForthFragment_to_FifthFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
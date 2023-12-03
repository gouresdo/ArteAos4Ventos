package br.com.fernando.arteaos4ventos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import br.com.fernando.arteaos4ventos.databinding.FragmentOptionsBinding;

public class FormsFragment extends Fragment {

    private FragmentOptionsBinding binding;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentOptionsBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       /* binding.layoutStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                NavHostFragment.findNavController(OptionsFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

            }
        });*/
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}


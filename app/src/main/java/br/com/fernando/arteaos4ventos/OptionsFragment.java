package br.com.fernando.arteaos4ventos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import br.com.fernando.arteaos4ventos.R;
import br.com.fernando.arteaos4ventos.databinding.FragmentOptionsBinding;

public class OptionsFragment extends Fragment {

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

        binding.buttonYou.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                NavHostFragment.findNavController(OptionsFragment.this)
                        .navigate(R.id.action_OptionsFragment_to_YoutubeFragment);
            }
        });
        binding.buttonApp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                NavHostFragment.findNavController(OptionsFragment.this)
                        .navigate(R.id.action_OptionsFragment_to_AskFragment);

            }
        });
        binding.button10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                NavHostFragment.findNavController(OptionsFragment.this)
                        .navigate(R.id.action_OptionsFragment_to_CountFragment);

            }
        });
        binding.buttonUde.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://www.udemy.com/course/curso-de-croche/");
            }
        });
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        startActivity(intent);

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}


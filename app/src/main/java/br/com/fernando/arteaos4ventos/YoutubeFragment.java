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
import br.com.fernando.arteaos4ventos.databinding.FragmentYoutubeBinding;

public class YoutubeFragment extends Fragment {

    private FragmentYoutubeBinding binding;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentYoutubeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://www.youtube.com/watch?v=qrJYcSCp0AE&list=PLL3IkvkW-g__FJfcdYeJ4lvGiw6_gv5dV");
            }
        });
        binding.button41.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://www.youtube.com/watch?v=efxrybvoWrs&list=PLL3IkvkW-g__0dFbBNBWhqBcKGwFPKZeG");
            }
        });
        binding.button42.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://youtube.com/playlist?list=PLL3IkvkW-g__KH51jnHMp0jxpSihPWeOI&si=o0D06PVyzm0-J84P");
            }
        });
        binding.button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://www.youtube.com/watch?v=yuWTdkjSho0&list=PLL3IkvkW-g__IwnqkwfcSqRg-iHxHg30-");
            }
        });
        binding.button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://www.youtube.com/watch?v=bsA8sFOx_qQ&list=PLL3IkvkW-g_-g1cBUre9r1bLlyoXcKyLV");
            }
        });
        binding.button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://www.youtube.com/watch?v=I1j6DBNCVyI&list=PLL3IkvkW-g_9Ed5wKSZNKWfehQC-DBV_V");
            }
        });
        binding.button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://www.youtube.com/watch?v=syTfm1aPL-4&list=PLL3IkvkW-g_9htIVaMu5mvtApXp4kthre");
            }
        });
        binding.button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://www.youtube.com/watch?v=VLCdsMOOqr0&list=PLL3IkvkW-g_9v97DxHamBFVrTChIF9ebj");
            }
        });
        binding.button10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://www.youtube.com/watch?v=h4_lb6qA5Tg&list=PLL3IkvkW-g_978AIZt7XSLaozNkHXOU_G");
            }
        });
        binding.button11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://www.youtube.com/watch?v=jSuYioCQctY&list=PLL3IkvkW-g_8ICJt3mSQJJmQe_en72m5z");
            }
        });
        binding.button12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://youtube.com/playlist?list=PLL3IkvkW-g__zZF-5ha71nNumSqrGCWkA");
            }
        });
        binding.button13.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://youtube.com/playlist?list=PLL3IkvkW-g_-SnQ8MevYxeb6X0ftPvtL2&si=dK68ZdbN1zkSILwg");
            }
        });

        binding.button14.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://www.youtube.com/playlist?list=PLL3IkvkW-g_-4q8e3KMagjdMgR5cUxsii");
            }
        });

        binding.button15.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://youtube.com/playlist?list=PLL3IkvkW-g__ZBL80sfN5AmeNFW2egTqB&si=7rgHx60uwO7v7RPE");
            }
        });
        binding.button16.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage("https://youtube.com/playlist?list=PLL3IkvkW-g_9tFEoS8lYU4P84hIrgDlLD&si=JXogG04fjQx-l2wK");
            }
        });



        binding.buttonBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                NavHostFragment.findNavController(YoutubeFragment.this)
                        .navigate(R.id.action_YoutubeFragment_to_OptionsFragment);

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


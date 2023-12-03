package br.com.fernando.arteaos4ventos;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import br.com.fernando.arteaos4ventos.R;
import br.com.fernando.arteaos4ventos.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {

    private FragmentStartBinding binding;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentStartBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String boldText = "ARTE AOS 4 VENTOS NA PALMA DA SUA MÃO";
        String normalText = "";
        SpannableString str = new SpannableString(normalText + boldText);
        str.setSpan(new StyleSpan(Typeface.BOLD), 0, boldText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.textViewHeader.setText(str);
        boldText = " Tia Graça";
        normalText = "Crochetando com a";
        SpannableString str2 = new SpannableString(normalText + boldText);
        str2.setSpan(new StyleSpan(Typeface.BOLD), 17, str2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.textViewIntro.setText(str2);
        binding.layoutStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                NavHostFragment.findNavController(StartFragment.this)
                        .navigate(R.id.action_StartFragment_to_OptionsFragment);

            }
        });
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}


package br.com.fernando.arteaos4ventos;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import br.com.fernando.arteaos4ventos.R;
import br.com.fernando.arteaos4ventos.databinding.FragmentFifthBinding;

public class FifthFragment extends Fragment {

    private FragmentFifthBinding binding;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFifthBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int multiplo = 1;
        int mais = 0;
        int cantos = 0;
        try {
            multiplo = Integer.parseInt(MainActivity.getData2());
        }catch (java.lang.NumberFormatException e){
        }
        try {
            mais = Integer.parseInt(MainActivity.getData3());
        }catch (java.lang.NumberFormatException e){
        }
        try {
            cantos = Integer.parseInt(MainActivity.getData4());
        }catch (java.lang.NumberFormatException e){
        }
        int motivos = 30/multiplo;
        TextView result1;
        result1 = (TextView) view.findViewById(R.id.textview_5_1);
        if(cantos == 0 || multiplo%2==0) {
            result1.setText(String.valueOf(mais + multiplo + multiplo * motivos));
        }else{
            result1.setText(String.valueOf(1 + mais + multiplo + multiplo * motivos));
        }
        result1.setText(result1.getText());
        result1.setBackground(getResources().getDrawable(R.drawable.testemargin));
        result1.setTextColor(getResources().getColor(R.color.gray));
        TextView[] Txtviews = {result1, new TextView(getContext()), new TextView(getContext()), new TextView(getContext()), new TextView(getContext()), new TextView(getContext()),new TextView(getContext())};
        for (int i=1;i<Txtviews.length;i++) {
            int multiploSup = multiplo*i;
            if(mais + multiploSup + multiplo + multiplo * motivos < 75) {
                if(cantos == 0 || multiplo%2==0) {
                    Txtviews[i].setText(String.valueOf(mais + multiploSup + multiplo + multiplo * motivos));
                }else{
                    Txtviews[i].setText(String.valueOf(1 + mais + multiploSup + multiplo + multiplo * motivos));
                }
                Txtviews[i].setTextSize(COMPLEX_UNIT_DIP,40);
                Txtviews[i].setGravity(17);
                Txtviews[i].setClickable(true);
                Txtviews[i].setBackground(getResources().getDrawable(R.drawable.testemargin));
                Txtviews[i].setTextColor(getResources().getColor(R.color.gray));
                //Txtviews[i].setBackgroundColor(getResources().getColor(R.color.yellow_x));
                binding.layoutTxt.addView(Txtviews[i]);
                int finalI = i;
                Txtviews[i].setOnClickListener(view1 -> {
                    String send = "";
                    send = send.concat(String.valueOf(Txtviews[finalI].getText().charAt(0)));
                    send = send.concat(String.valueOf(Txtviews[finalI].getText().charAt(1)));
                    Log.d("print", "data: "+send);
                    MainActivity.storeData5(send);
                    NavHostFragment.findNavController(FifthFragment.this)
                            .navigate(R.id.action_FifthFragment_to_FifthFragment2);
                });
            }
        }
        LinearLayout layout1;
        layout1 = (LinearLayout) view.findViewById(R.id.layoutview_5_1_hidden);
        binding.layoutTxt.setGravity(17);
        binding.textview51.setOnClickListener(view1 -> {
            String send = "";
            send = send.concat(String.valueOf(binding.textview51.getText().charAt(0)));
            send = send.concat(String.valueOf(binding.textview51.getText().charAt(1)));
            Log.d("print", "data: "+send);
            MainActivity.storeData5(send);
            NavHostFragment.findNavController(FifthFragment.this)
                    .navigate(R.id.action_FifthFragment_to_FifthFragment2);
        });

        if(cantos == 0){
                /*result1.setText(String.valueOf(mais + multiplo + multiplo * motivos));*/
        }
        if(cantos == 1){


        }


        /*binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                NavHostFragment.findNavController(FifthFragment.this)
                        .navigate(R.id.action_FifthFragment_to_FifthFragment2);

            }
        });*/
    }


    int findPicture(int pictureNeeded){
        if (pictureNeeded == 1) {
            return R.drawable.bloco1;
        }
        if (pictureNeeded == 2) {
            return R.drawable.bloco2;
        }
        if (pictureNeeded == 3) {
            return R.drawable.bloco3;
        }
        if (pictureNeeded == 4) {
            return R.drawable.bloco4;
        }
        if (pictureNeeded == 5) {
            return R.drawable.bloco5;
        }
        if (pictureNeeded == 6) {
            return R.drawable.bloco6;
        }
        if (pictureNeeded == 7) {
            return R.drawable.bloco7;
        }
        if (pictureNeeded == 8) {
            return R.drawable.bloco8;
        }
        if (pictureNeeded == 9) {
            return R.drawable.bloco9;
        }
        if (pictureNeeded == 10) {
            return R.drawable.bloco10;
        }
        return 0;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void addImage(String drawable){

    }
}



//        String user_greeting = "QUANTOS CASEADOS VOCÊ TEM?";
//        final TextView helloTextView = (TextView) view;
//        helloTextView.setText(user_greeting);

//SM.sendData(caseados.getText().toString().trim());
// Log.d("TAG", "onClick: "+caseados.getText());
    /*SendMessage SM;

    interface SendMessage {
        void sendData(String message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SM = (SendMessage) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }*/
package br.com.fernando.arteaos4ventos;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import br.com.fernando.arteaos4ventos.databinding.FragmentCount12Binding;

public class Count12Fragment extends Fragment {

    private FragmentCount12Binding binding;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentCount12Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        String base = MainActivity.getDataPlusEx();
        String plus = "";
        Log.d("debug 2", MainActivity.getDataPlusEx());
        super.onViewCreated(view, savedInstanceState);
        /*if (MainActivity.getDataPlusEx().charAt(0) != '1'){
            base = String.valueOf(MainActivity.getDataPlusEx().charAt(0));
        }else{
            base = String.valueOf(MainActivity.getDataPlusEx().charAt(0) + MainActivity.getDataPlusEx().charAt(1));
        }*/
        String make = "0";

        fillPluses(base, 0, binding.layoutNum1);
        fillPluses(base, 7, binding.layoutNum2);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getContext().getDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        ViewGroup.LayoutParams params = binding.layoutNum1.getLayoutParams();
        ViewGroup.LayoutParams paramsH = binding.layoutNum2.getLayoutParams();
        ViewGroup.LayoutParams paramsS = binding.layoutview51Hidden.getLayoutParams();
        params.width = (width/2) - 60;
        paramsH.width = (width/2) - 60;
        paramsS.height = (height/2) - 100;


        /*int value = Integer.valueOf(base) + Integer.valueOf(plus);
        Log.d("print", "data: "+value);
        do{
            value += Integer.valueOf(base);
        }while (value<30);

        for(int i=0;i<14;i++){
            if(value<75){
                value += Integer.valueOf(base);
                if(i<8){
                    TextView v = new TextView(getContext());
                    v.setText(String.valueOf(value));
                    v.setTextSize(30);
                    v.setGravity(17);
                    v.setTextColor(getResources().getColor(R.color.gray));
                    binding.layoutNum1.addView(v);
                }else {
                    TextView v = new TextView(getContext());
                    v.setText(String.valueOf(value));
                    v.setTextSize(30);
                    v.setGravity(17);
                    v.setTextColor(getResources().getColor(R.color.gray));
                    binding.layoutNum2.addView(v);
                }
            }
        }*/





        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                NavHostFragment.findNavController(Count12Fragment.this)
                        .navigate(R.id.action_Count12Fragment_to_CountFragment);

            }
        });
    }


    void fillPluses (String base, int initial, LinearLayout lay){
        Log.d("valor da base", base);
        int x = Integer.parseInt(base);
        Log.d("valor da base", String.valueOf(x));
        for (int i=initial;i<=initial + 6;i++) {
            if(i<x) {
                TextView v = new TextView(getContext());
                v.setText(base + " + " + String.valueOf(i));

                v.setTextSize(30);
                v.setGravity(17);
                v.setBackground(getResources().getDrawable(R.drawable.testemargin));
                v.setTextColor(getResources().getColor(R.color.gray));
                lay.addView(v);
                v.setOnClickListener(view1 -> {
                    String send = "";
                    for (int y = 0; y < v.length(); y++) {
                        send = send.concat(String.valueOf(v.getText().charAt(y)));
                    }
                    MainActivity.storeDataPlus(send);
                    NavHostFragment.findNavController(Count12Fragment.this)
                            .navigate(R.id.action_Count12Fragment_to_Count2Fragment);
                });
            }
        }
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
        if (pictureNeeded == 11) {
            return R.drawable.bloco11;
        }
        if (pictureNeeded == 12) {
            return R.drawable.bloco12;
        }
        if (pictureNeeded == 13) {
            return R.drawable.bloco13;
        }
        if (pictureNeeded == 14) {
            return R.drawable.bloco14;
        }
        if (pictureNeeded == 15) {
            return R.drawable.bloco15;
        }
        if (pictureNeeded == 16) {
            return R.drawable.bloco16;
        }
        if (pictureNeeded == 17) {
            return R.drawable.bloco17;
        }
        if (pictureNeeded == 18) {
            return R.drawable.bloco18;
        }
        if (pictureNeeded == 19) {
            return R.drawable.bloco19;
        }
        if (pictureNeeded == 20) {
            return R.drawable.bloco20;
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
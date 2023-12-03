package br.com.fernando.arteaos4ventos;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import br.com.fernando.arteaos4ventos.R;
import br.com.fernando.arteaos4ventos.databinding.FragmentCountBinding;

public class CountFragment extends Fragment {

    private FragmentCountBinding binding;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentCountBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout layout1;
        layout1 = (LinearLayout) view.findViewById(R.id.layoutNum1);
        binding.layoutNum.setGravity(17);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getContext().getDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        //layoutNum -> Numeros de escolha
        //layoutMais -> Numeros "+" para tabuada
        //layoutview51Hidden -> parent dos outros
        ViewGroup.LayoutParams params = binding.layoutNum.getLayoutParams();
        ViewGroup.LayoutParams paramsH = binding.layoutMais.getLayoutParams();
        ViewGroup.LayoutParams paramsS = binding.layoutview51Hidden.getLayoutParams();

        paramsS.height = (height/2) + 100;
        params.width = (width/2) - 60 ;
        paramsH.width = (width/2) - 60;


        TextView result1;
        result1 = (TextView) view.findViewById(R.id.textview_5_1);
        result1.setText("3");
        result1.setTextSize(30);
        result1.setBackground(getResources().getDrawable(R.drawable.purpmargin));
        result1.setTextColor(getResources().getColor(R.color.black));
        TextView[] Txtviews = {result1, new TextView(getContext()), new TextView(getContext()), new TextView(getContext()), new TextView(getContext()), new TextView(getContext()),new TextView(getContext())};
        for (int i=1;i<Txtviews.length;i++) {

            Txtviews[i].setText(String.valueOf(i+3));

            Txtviews[i].setTextSize(30);
            Txtviews[i].setGravity(17);
            Txtviews[i].setClickable(true);
            if(i==1){
                Txtviews[i].setBackground(getResources().getDrawable(R.drawable.redmargin));
            }
            if(i==2){
                Txtviews[i].setBackground(getResources().getDrawable(R.drawable.radmargin));
            }
            if(i==3){
                Txtviews[i].setBackground(getResources().getDrawable(R.drawable.ylwmargin));
            }
            if(i==4){
                Txtviews[i].setBackground(getResources().getDrawable(R.drawable.greenmargin));
            }
            if(i==5){
                Txtviews[i].setBackground(getResources().getDrawable(R.drawable.l8luemargin));
            }
            if(i==6){
                Txtviews[i].setBackground(getResources().getDrawable(R.drawable.d8luemargin));
            }
            Txtviews[i].setTextColor(getResources().getColor(R.color.black));
            //Txtviews[i].setBackgroundColor(getResources().getColor(R.color.yellow_x));
            binding.layoutNum.addView(Txtviews[i]);

            int finalI = i;
            Txtviews[i].setOnClickListener(view1 -> {

                binding.layoutMais.removeAllViews();
                binding.layoutMais.removeAllViews();

                String make = String.valueOf(Txtviews[finalI].getText().charAt(0));
                fillPluses(make, binding.layoutMais);
            });
        }

        binding.layoutTxt.setGravity(17);
        binding.textview51.setOnClickListener(view1 -> {
            binding.layoutMais.removeAllViews();
            binding.layoutMais.removeAllViews();
            fillPluses("3", binding.layoutMais);
        });


    }

    void fillPluses (String base,  LinearLayout lay){
        int x = Integer.parseInt(base);

        for (int i=0;i<=x-1;i++) {
            TextView v = new TextView(getContext());
            v.setText(base + " + " + String.valueOf(i));
            v.setTextSize(30);
            v.setGravity(17);
            v.setBackground(getResources().getDrawable(R.drawable.testemargin));
            v.setTextColor(getResources().getColor(R.color.gray));
            lay.addView(v);
            v.setOnClickListener(view1 -> {
                String send = "";
                for (int y=0;y<v.length();y++){
                    send = send.concat(String.valueOf(v.getText().charAt(y)));
                }
                MainActivity.storeDataPlus(send);
                NavHostFragment.findNavController(CountFragment.this)
                        .navigate(R.id.action_CountFragment_to_Count2Fragment);
            });
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
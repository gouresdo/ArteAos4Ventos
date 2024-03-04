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
        TextView result2;
        result1 = (TextView) view.findViewById(R.id.textview_5_1);
        result2 = (TextView) view.findViewById(R.id.textview_5_2);
        result1.setText("3");
        result1.setTextSize(30);
        result1.setBackground(getResources().getDrawable(R.drawable.pinkdmargin));
        result1.setTextColor(getResources().getColor(R.color.black));
        result2.setText("9");
        result2.setTextSize(30);
        result2.setBackground(getResources().getDrawable(R.drawable.pinkdmargin));
        result2.setTextColor(getResources().getColor(R.color.black));


        result1.setOnClickListener(view1 -> {
            String senda = "";
            for (int y = 0; y < result1.getText().length(); y++) {
                senda = senda.concat(String.valueOf(result1.getText().charAt(y)));
            }
            MainActivity.storeDataPlusEx(senda);
            NavHostFragment.findNavController(CountFragment.this)
                    .navigate(R.id.action_CountFragment_to_Count12Fragment);
        });
        result2.setOnClickListener(view1 -> {
            String senda = "";
            for (int y = 0; y < result2.getText().length(); y++) {
                senda = senda.concat(String.valueOf(result2.getText().charAt(y)));
            }
            MainActivity.storeDataPlusEx(senda);
            NavHostFragment.findNavController(CountFragment.this)
                    .navigate(R.id.action_CountFragment_to_Count12Fragment);
        });

        TextView[] Txtviews = {result1, new TextView(getContext()), new TextView(getContext()), new TextView(getContext()), new TextView(getContext()), new TextView(getContext())};
        TextView[] Txtviews2 = {result2, new TextView(getContext()), new TextView(getContext()), new TextView(getContext()), new TextView(getContext()), new TextView(getContext())};
        for (int i=1;i<Txtviews.length;i++) {
            Txtviews[i].setText(String.valueOf(i+3));
            Txtviews[i].setTextSize(30);
            Txtviews[i].setGravity(17);
            Txtviews[i].setClickable(true);
            if(i%2==1) {
                Txtviews[i].setBackground(getResources().getDrawable(R.drawable.pinklmargin));
            }else{
                Txtviews[i].setBackground(getResources().getDrawable(R.drawable.pinkdmargin));
            }
            Txtviews[i].setTextColor(getResources().getColor(R.color.black));

            binding.layoutNum.addView(Txtviews[i]);

            int finalI = i;
            Txtviews[i].setOnClickListener(view1 -> {
                String send = "";
                TextView v = new TextView(getContext());
                Log.d("debug 1 = ", v.getText().toString());

                for (int y = 0; y < Txtviews[finalI].getText().length(); y++) {
                    send = send.concat(String.valueOf(Txtviews[finalI].getText().charAt(y)));
                }
                MainActivity.storeDataPlusEx(send);
                NavHostFragment.findNavController(CountFragment.this)
                        .navigate(R.id.action_CountFragment_to_Count12Fragment);

            });
        }
        for (int i=1;i<Txtviews2.length;i++) {
            Txtviews2[i].setText(String.valueOf(i+9));
            Txtviews2[i].setTextSize(30);
            Txtviews2[i].setGravity(17);
            Txtviews2[i].setClickable(true);

            if(i%2==1) {
                Txtviews2[i].setBackground(getResources().getDrawable(R.drawable.pinklmargin));
            }else{
                Txtviews2[i].setBackground(getResources().getDrawable(R.drawable.pinkdmargin));
            }


            Txtviews2[i].setTextColor(getResources().getColor(R.color.black));

            binding.layoutMais.addView(Txtviews2[i]);

            int finalI = i;
            Txtviews2[i].setOnClickListener(view1 -> {

                String send = "";
                for (int y = 0; y < Txtviews2[finalI].getText().length(); y++) {
                    send = send.concat(String.valueOf(Txtviews2[finalI].getText().charAt(y)));
                }
                MainActivity.storeDataPlusEx(send);
                NavHostFragment.findNavController(CountFragment.this)
                        .navigate(R.id.action_CountFragment_to_Count12Fragment);


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
package br.com.fernando.arteaos4ventos;

import static android.widget.ImageView.ScaleType.FIT_XY;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import br.com.fernando.arteaos4ventos.R;
import br.com.fernando.arteaos4ventos.databinding.FragmentFifth2Binding;

public class FifthFragment2 extends Fragment {

    private FragmentFifth2Binding binding;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFifth2Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int multiplo = Integer.parseInt(MainActivity.getData2());
        int mais = Integer.parseInt(MainActivity.getData3());
        int cantos = Integer.parseInt(MainActivity.getData4());
        int motivos = Integer.parseInt(MainActivity.getData5())/multiplo;

        LinearLayout layout1;
        layout1 = (LinearLayout) view.findViewById(R.id.layout_image);
        binding.layoutImage.setGravity(17);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getContext().getDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;



        if(cantos == 0){
            setMultiplos(motivos, multiplo, layout1, width, 0, mais, Integer.parseInt(MainActivity.getData5()));
            //binding.textView15.setText(setDivisao(44));
        }
        if(cantos == 1){
            if (multiplo % 2 == 0) {
                setMultiplos(motivos, multiplo, layout1, width, multiplo/2, mais, Integer.parseInt(MainActivity.getData5()));
               // binding.textView15.setText(setDivisao(44));
            }
            if (multiplo % 2 == 1) {
                setMultiplos(motivos, multiplo, layout1, width, (multiplo/2)+1, mais, Integer.parseInt(MainActivity.getData5()));
              //  binding.textView15.setText(setDivisao(44));
            }

        }


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                NavHostFragment.findNavController(FifthFragment2.this)
                        .navigate(R.id.action_FifthFragment2_to_SixthFragment);

            }
        });
    }


    void setMultiplos (int motivos, int multiplo, LinearLayout layout1, int width, int canto, int mais, int total){


        ViewGroup.LayoutParams params = binding.imageView6.getLayoutParams();
        ViewGroup.LayoutParams paramsH = binding.imageView8.getLayoutParams();
        ViewGroup.LayoutParams paramsC = binding.imageViewCanto1.getLayoutParams();
        params.height = 150;
        params.width = (width - ((width/total) * mais))/(motivos);
        paramsC.height = 150;
        paramsC.width = ((width - ((width/total) * mais))/(motivos)/2);
        if (canto > 0) {
            ImageView imagem1 = new ImageView(getContext());
            if(multiplo%2==0) {
                imagem1.setImageResource(findPicture(multiplo/2));
            }
            if(multiplo%2==1) {
                imagem1.setImageResource(findPicture((multiplo/2)+1));
            }
            imagem1.setScaleType(FIT_XY);
            imagem1.setVisibility(View.VISIBLE);
            imagem1.setLayoutParams(paramsC);
            layout1.addView(imagem1);
        }
        for (int i = 0; i < motivos-1; i++){
            ImageView imagem1 = new ImageView(getContext());
            imagem1.setImageResource(findPicture(multiplo));
            imagem1.setScaleType(FIT_XY);
            imagem1.setVisibility(View.VISIBLE);
            imagem1.setLayoutParams(params);
            layout1.addView(imagem1);
        }

        if (canto > 0){
            paramsH.height = 150;
            paramsH.width = (width/total) * mais;
            ImageView imagem2 = new ImageView(getContext());
            imagem2.setImageResource(findPicture(mais));
            imagem2.setScaleType(FIT_XY);
            imagem2.setVisibility(View.VISIBLE);
            imagem2.setLayoutParams(paramsH);
            layout1.addView(imagem2);
            ImageView imagem1 = new ImageView(getContext());
            if(multiplo%2==0) {
                imagem1.setImageResource(findPicture(multiplo/2));
            }
            if(multiplo%2==1) {
                imagem1.setImageResource(findPicture((multiplo/2)+1));
            }
            imagem1.setScaleType(FIT_XY);
            imagem1.setVisibility(View.VISIBLE);
            imagem1.setLayoutParams(paramsC);
            layout1.addView(imagem1);
        }else{
            binding.imageView6.setImageResource(findPicture(multiplo));
            binding.imageView6.setAdjustViewBounds(true);
            binding.imageView6.setScaleType(FIT_XY);
            binding.imageView6.setLayoutParams(params);
            binding.imageView6.setVisibility(View.VISIBLE);
            paramsH.height = 150;
            paramsH.width = (width/total) * mais;
            ImageView imagem2 = new ImageView(getContext());
            imagem2.setImageResource(findPicture(mais));
            imagem2.setScaleType(FIT_XY);
            imagem2.setVisibility(View.VISIBLE);
            imagem2.setLayoutParams(paramsH);
            layout1.addView(imagem2);
        }

    }

    public String setDivisao (int total){
        if(total%2 == 0){
            int x1 = total/2;
            if (x1%2 == 0){
                int x2 = x1/2;
                if (x2%2 == 0){
                    int x3 = x2/2;
                    String result = "";
                    for(int i=0;i<8;i++){
                        result += String.valueOf(x3) + "  ";
                    }
                    return result;
                }else{
                    int x3 = (x2/2) + 1;
                    int x3_2 = x2/2;
                    String result = "";
                    result += String.valueOf(x3_2) + ",5  " + String.valueOf(x3_2) + ",5  "
                            + String.valueOf(x3_2) + ",5  "+ String.valueOf(x3_2) + ",5  "
                            + String.valueOf(x3_2) + ",5  " + String.valueOf(x3_2) + ",5  "
                            + String.valueOf(x3_2) + ",5  "+ String.valueOf(x3_2) + ",5";
                    return result;
                }
            }else{
                int x2 = (x1/2) + 1;
                int x2_2 = (x1/2);

            }
        }else{
            int x1 = (total/2) + 1;
            int x1_2 = total/2;

        }
        return "";
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
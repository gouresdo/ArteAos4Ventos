package br.com.fernando.arteaos4ventos;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import br.com.fernando.arteaos4ventos.R;
import br.com.fernando.arteaos4ventos.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    static String data1;
    static String data2;
    static String data3;
    static String data4;
    static String data5;
    static String dataPlus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public static void storeData(String data){
        data1 = data;
    }

    public static void printData(){
        Log.d("print", "data: "+data1);
    }

    public static void storeData2(String data){
        data2 = data;
    }

    public static void printData2(){
        Log.d("print", "data: "+data2);
    }

    public static void storeData3(String data){
        data3 = data;
    }

    public static void printData3(){
        Log.d("print", "data: "+data3);
    }

    public static void storeData4(String data){
        data4 = data;
    }

    public static void printData4(){
        Log.d("print", "data: "+data4);
    }

    public static void storeData5(String data){
        data5 = data;
    }

    public static void printData5(){
        Log.d("print", "data: "+data5);
    }

    public static void storeDataPlus(String data){
        dataPlus = data;
    }

    public static void printDataPlus(){
        Log.d("print", "data: "+dataPlus);
    }

    public static String getData1(){
        return data1;
    }
    public static String getData2(){
        return data2;
    }
    public static String getData3(){
        return data3;
    }
    public static String getData4(){
        return data4;
    }
    public static String getData5(){
        return data5;
    }
    public static String getDataPlus(){
        return dataPlus;
    }



    /*@Override
    public void sendData(String message) {
        FragmentManager fm = this.getSupportFragmentManager();

        List<Fragment> list = fm.getFragments();
        for (int i=0;i<list.size();i++){
            Log.d("Frag", list.get(i).toString());
        }
        Log.d("Check", fm.toString());
        SecondFragment f = (SecondFragment) fm.findFragmentById(R.id.SecondFragment);

        //f.displayReceivedData(message);

    }*/


}

//        SecondFragment f = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.SecondFragment);
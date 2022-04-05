package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
// les variable global4
    private int valeur1=0;
    private int valeur2=0;
    private String operation="";
    private boolean isope1=true;
    private TextView ch_saisi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ch_saisi=findViewById(R.id.textView);
    }
    private void afficher(){
        if(!isope1){
            ch_saisi.setText(String.valueOf(valeur1)+""+operation+""+String.valueOf(valeur2));
        }
        else{
            ch_saisi.setText(String.valueOf(valeur1));
        }
    }
    public void ajouterNbr(View view) {
        int val=Integer.parseInt(((Button)view).getText().toString());
        if(isope1){
            valeur1=valeur1*10+val;
            afficher();
        }else{
            valeur2=valeur2*10+val;
            afficher();
        }
    }

    public void setOperator(View view) {
        switch (view.getId()){
            case R.id.bu_plus:operation="+";break;
            case R.id.bu_moins:operation="-";break;
            case R.id.bu_mul:operation="*";break;
            case R.id.bu_div:operation="/";break;
            default:
                return;// nothing to do
        }
        isope1=false;
        afficher();
    }

    public void clean(View view) {
        valeur1=0;valeur2=0;isope1=true;
        operation="";
        afficher();
    }

    public void calculer(View view) {
        if(!isope1){
            switch (operation){
                case "+": valeur1=valeur1+valeur2;break;
                case "-": valeur1=valeur1-valeur2;break;
                case "*": valeur1=valeur1*valeur2;break;
                case "/": valeur1=valeur1/valeur2;break;
                default:return;// nothing to do
            }
            valeur2=0;
            isope1=true;
            afficher();
        }
    }
}
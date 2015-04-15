package com.jfeteira.myfirstapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;


public class MainActivity extends ActionBarActivity {

    private Context xContext;
    private TextView xCounter;
    private final static String LOG_TAG = "LOG_TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*... serve para escrever no logcat para assim podermos ver o que se esta a passar com a
        * ... activity */
        Log.d(LOG_TAG, "onCreate");
        super.onCreate(savedInstanceState);

        xContext = this;

        //*... serve para associar esta layou a activity que desenhamos
        setContentView(R.layout.activity_main);

        //final TextView xCounter = (TextView)findViewById(R.id.lbText);
        xCounter = (TextView)findViewById(R.id.lbText);
        xCounter.setText("0");

        //*... definição do Botão bem como do evento OnClick
        Button btIncr = (Button)findViewById(R.id.btnIncr);
        btIncr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int xCurent = Integer.parseInt(xCounter.getText().toString());
                xCounter.setText(xCurent+1 + "");
            }
        });

        //*... definição do Botão bem como do evento OnClick
        Button btMsg = (Button)findViewById(R.id.btnMsg);
        btMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(xContext, "Valor do contador e: " + xCounter.getText().toString() , Toast.LENGTH_LONG).show();
            }
        });

        //*... definição do Botão bem como do evento OnClick
        Button btDecr = (Button)findViewById(R.id.btnDecr);
        btDecr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int xCurent = Integer.parseInt(xCounter.getText().toString());
                if (xCurent > 0){
                    xCounter.setText(xCurent-1 + "");
                }
                else
                {
                    Toast.makeText(xContext, "Valor é inferior a ZERO", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onSaveInstanceState (Bundle outState){
        Log.d(LOG_TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);

        outState.putString("COUNTER_VALUE", xCounter.getText().toString());

    }
    @Override
    public void onRestoreInstanceState (Bundle savedInstanceState){
        Log.d(LOG_TAG, "onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);

        xCounter.setText(savedInstanceState.getString("COUNTER_VALUE"));

    }

    @Override
    protected void onStart() {
        Log.d(LOG_TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(LOG_TAG, "onResume");
        super.onResume();
        System.out.println();
    }

    @Override
    protected void onPause() {
        Log.d(LOG_TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.d(LOG_TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(LOG_TAG, "onDestroy");
        super.onDestroy();
    }
}

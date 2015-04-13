package com.jfeteira.myfirstapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //*... serve para associar esta layou a activity que desenhamos
        setContentView(R.layout.activity_main);

        final TextView xCounter = (TextView)findViewById(R.id.lbText);
        xCounter.setText("0");

        Button btIncr = (Button)findViewById(R.id.btnIncr);
        btIncr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int xCurent=Integer.parseInt(xCounter.getText().toString());
                xCounter.setText(xCurent+1 + "");
            }
        });

        Button btDecr = (Button)findViewById(R.id.btnDecr);
        btDecr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int xCurent=Integer.parseInt(xCounter.getText().toString());
                xCounter.setText(xCurent-1 + "");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}

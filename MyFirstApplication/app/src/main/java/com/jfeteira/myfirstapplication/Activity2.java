package com.jfeteira.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Activity2 extends ActionBarActivity {

    public static final String X_CONTADOR_VALUE_KEY = "COUNTER_VALUE_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        final String lbCounter = getIntent().getStringExtra(X_CONTADOR_VALUE_KEY);
        ((TextView)findViewById(R.id.lbResultCount)).setText(lbCounter);

        //*... vou criar um novo layout
        LinearLayout rootLayout1 = (LinearLayout) findViewById(R.id.xLayoutMultiplica);
        rootLayout1.setMinimumHeight(50);

        LinearLayout rootLayout2 = (LinearLayout) findViewById(R.id.xLayoutMultiplica);

        final EditText etValMultiplica = new EditText(this);
        etValMultiplica.setTextSize(32);
        etValMultiplica.setEms(15); // serve para limitar o tamanho do campo
        etValMultiplica.setFocusable(true);
        etValMultiplica.setInputType(InputType.TYPE_CLASS_NUMBER);
        rootLayout2.addView(etValMultiplica);


        Button btMultiplica = new Button(this);
        btMultiplica.setText("Multiplica " + lbCounter + " por ...");
        rootLayout2.addView(btMultiplica);
        btMultiplica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer value1 = Integer.parseInt(lbCounter);
                Integer value2 = Integer.parseInt(etValMultiplica.getText().toString());
                ((TextView)findViewById(R.id.lbResultCount)).setText(lbCounter +  " * " + value2 + " = " + (value1 * value2) + "" );
            }
        });

        Button btOk = new Button(this);
        btOk.setText("Ok - passa valores");
        rootLayout2.addView(btOk);
        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer value1 = Integer.parseInt(lbCounter);
                Integer value2 = Integer.parseInt(etValMultiplica.getText().toString());
                Intent intentResult = new Intent();
                //poderia usar o método getIntent() para ir buscar o que já tinha criado anteriormente
                /*
                * Intent intentResult = getIntent();
                * */
                intentResult.putExtra("COUNTER_VALUE", (value1 * value2) + "");
                setResult(RESULT_OK, intentResult);
                finish();
            }
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }




}

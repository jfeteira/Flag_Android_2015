package com.jfeteira.teste01;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText editText;
    private Button btButton;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        editText = (EditText)findViewById(R.id.editText);
        btButton = (Button)findViewById(R.id.button);

        btButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = String.format("Hello %s", editText.getText().toString());
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
                btButton.setText("- - " + editText.getText().toString() + " - -");

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
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

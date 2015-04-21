package android.flag.pt.challenge_it.asynctaskdemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter;


/**
 * Demonstration of the AsyncTask for make I/O, slow operations that not
 * blocks the UI.
 *
 * @author Challenge.IT
 */
public class MainActivity extends Activity {
    private static final String LOG_TAG = "LOG_TAG";
    private TextView tbCidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_activity);

        Button btnGet = (Button) findViewById(R.id.btnGet);
        final TextView txtTemperature = (TextView) findViewById(R.id.txtTemperature);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(LOG_TAG, "Chamada ....");
                tbCidade = (TextView) findViewById(R.id.editCidade);

                new getWheather().execute(tbCidade.getText().toString());
                Log.d(LOG_TAG, "Fim Chamada ....");


            }
        });
    }

    private class getWheather extends AsyncTask<String, Integer, DadosTempo> {

        @Override
        protected DadosTempo doInBackground(String... xCidade) {

            Log.d(LOG_TAG, "Cidade: " + xCidade[0].toString());


            try {
                URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + xCidade[0] + "&mode=json&units=metric");

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                String res = "";
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = "";
                while ((line = rd.readLine()) != null)
                    res += line;

                JSONObject response = new JSONObject(res);

                DadosTempo xTempo = new DadosTempo();
                xTempo.setNomeCidade(xCidade[0].toString());

                xTempo.setNomePais(response.getJSONObject("sys").getString("country"));
                xTempo.setTempAct(response.getJSONObject("main").getDouble("temp"));
                xTempo.setTempMax(response.getJSONObject("main").getDouble("temp_max"));
                xTempo.setTempMin(response.getJSONObject("main").getDouble("temp_min"));

                return xTempo;


            } catch (Exception e) {
                Log.d(LOG_TAG, e.toString());
                return null;
            }


        }

        @Override
        protected void onPostExecute(DadosTempo xTemp) {
            super.onPostExecute(xTemp);

            NumberFormat frmTemp = new DecimalFormat("#0.0 ºC");
            TextView txtCidade = (TextView) findViewById(R.id.txtCidade);
            TextView txtPais = (TextView) findViewById(R.id.txtPais);
            TextView txtTemp = (TextView) findViewById(R.id.txtTemperature);
            TextView txtMaxMin = (TextView) findViewById(R.id.txtMaxMin);

            try {

                NumberFormat frmTemperatura = new DecimalFormat("#0.0 ºC");
                txtCidade.setText(xTemp.getNomeCidade());
                txtPais.setText(xTemp.getNomePais());
                txtTemp.setText(frmTemperatura.format(xTemp.getTempAct()).toString());
                txtMaxMin.setText("Min: " + frmTemperatura.format(xTemp.getTempMin()).toString() + " / Max: " + frmTemperatura.format(xTemp.getTempMax()).toString());

            } catch (NullPointerException e) {
                txtCidade.setText(R.string.strCidadeNull);
                txtPais.setText("");
                txtTemp.setText("");
                txtMaxMin.setText("");
            }





        }
    }

}


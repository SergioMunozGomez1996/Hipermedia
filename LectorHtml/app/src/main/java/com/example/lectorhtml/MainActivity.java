package com.example.lectorhtml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText URLeditText;
    private Button cargarURLbutton;
    private TextView contenidoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URLeditText = findViewById(R.id.URLeditText);
        cargarURLbutton = findViewById(R.id.cargarButton);
        contenidoTextView = findViewById(R.id.cargadoTextView);

        cargarURLbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //contenidoTextView.setText(descargarContendio(URLeditText.getText().toString()));
                new DownloadTask().execute(URLeditText.getText().toString());
            }
        });
    }

    public String descargarContendio( String strUrl ) {
        HttpURLConnection http = null;
        String content = null;
        try {
            URL url = new URL( strUrl );
            http = (HttpURLConnection)url.openConnection();
            if( http.getResponseCode() == HttpURLConnection.HTTP_OK ) {
                StringBuilder sb = new StringBuilder();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader( http.getInputStream() ));
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                content = sb.toString();
                reader.close();
            }
        }
        catch(Exception e) { e.printStackTrace(); }
        finally {
            if( http != null ) http.disconnect();
        }
        return content;
    }

    private class DownloadTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String... urls)
        {
            // Llamada al método de descarga de contenido
            return descargarContendio( urls[0] );
        }
        @Override
        protected void onPreExecute() {
            cargarURLbutton.setEnabled(false);
        }
        @Override
        protected void onCancelled() {
            cargarURLbutton.setEnabled(true);
        }
        @Override
        protected void onPostExecute(String contenido)
        {
            contenidoTextView.setText( contenido );
            cargarURLbutton.setEnabled(true);
        }
    }
}

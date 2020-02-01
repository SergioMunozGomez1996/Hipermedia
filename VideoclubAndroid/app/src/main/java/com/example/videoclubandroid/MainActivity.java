package com.example.videoclubandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private MovieAdapter myAdapter;
    private List<Movie> listMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.movieListView);
        listMovie = new ArrayList<>();

        new DownloadTask().execute("http://gbrain.dlsi.ua.es/videoclub/api/v1/catalog");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = listMovie.get(position);
                Movie p = new Movie(movie.getTitle(),movie.getYear(),movie.getDirector(),movie.getPoster(),movie.isRented(),movie.getSynopsis());
                Intent i=new Intent(getApplicationContext(),DetalleActivity.class);
                /*i.putExtra("title", p.getTitle());
                i.putExtra("year", p.getYear());
                i.putExtra("director", p.getDirector());
                i.putExtra("poster", p.getPoster());
                i.putExtra("rented", p.isRented());
                i.putExtra("synopsis", p.getSynopsis());*/
                i.putExtra("pelicula",p);
                startActivity(i);
            }
        });
    }


    public String peticionGET( String strUrl )
    {
        HttpURLConnection http = null;
        String content = null;
        try {
            URL url = new URL( strUrl );
            http = (HttpURLConnection)url.openConnection();
            http.setRequestProperty("Content-Type", "application/json");
            http.setRequestProperty("Accept", "application/json");

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
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if( http != null ) http.disconnect();
        }
        return content;
    }

    private class DownloadTask extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... strings) {
            return peticionGET(strings[0]);
        }

        @Override
        protected void onPostExecute(String contenido) {
            JSONArray mensajes = null;
            if(contenido!=null){
                try {
                    mensajes = new JSONArray(contenido);
                    for(int i=0;i<mensajes.length();i++) {
                        JSONObject mensaje = mensajes.getJSONObject(i);
                        String title = mensaje.getString("title");
                        String year = mensaje.getString("year");
                        String director = mensaje.getString("director");
                        String poster = mensaje.getString("poster");
                        boolean rented;
                        if(mensaje.getInt("rented") == 0){
                            rented = false;
                        }else
                            rented = true;
                        String synopsis = mensaje.getString("synopsis");
                        Movie pelicula = new Movie(title,year, director,poster, rented, synopsis);
                        listMovie.add(pelicula);

                    }

                    myAdapter = new MovieAdapter(getApplicationContext(), listMovie);
                    listView.setAdapter(myAdapter);
                    listView.setOnScrollListener(myAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Error al cargar los datos", Toast.LENGTH_SHORT);

                toast1.show();
            }
        }
    }
}

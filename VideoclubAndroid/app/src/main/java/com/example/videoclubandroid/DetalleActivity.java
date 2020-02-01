package com.example.videoclubandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {
    private ImageView posterView;
    private TextView titleTextView;
    private TextView yearTextView;
    private TextView directorTextView;
    private TextView rentedTextView;
    private TextView synopsisTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        posterView = findViewById(R.id.posterImageView);
        titleTextView = findViewById(R.id.titleTextView);
        yearTextView = findViewById(R.id.yearTextView);
        directorTextView = findViewById(R.id.directorTextView);
        rentedTextView = findViewById(R.id.rentedTextView);
        synopsisTextView = findViewById(R.id.synopsisTextView);

        /*Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String year = intent.getStringExtra("year");
        String poster = intent.getStringExtra("poster");
        String synopsis = intent.getStringExtra("synopsis");
        Boolean rent = intent.getBooleanExtra("rented", false);*/
        Movie pelicula = (Movie) getIntent().getSerializableExtra("pelicula");


        new MovieLoader().execute( pelicula, posterView );

        if(pelicula!=null){
            titleTextView.setText(pelicula.getTitle());
            yearTextView.setText(pelicula.getYear());
            directorTextView.setText(pelicula.getDirector());
            if(pelicula.isRented())
                rentedTextView.setText("Alquilada");
            else
                rentedTextView.setText("Disponible");
            synopsisTextView.setText(pelicula.getSynopsis());
        }
    }
}

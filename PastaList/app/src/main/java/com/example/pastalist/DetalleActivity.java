package com.example.pastalist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        imageView = findViewById(R.id.pastaImageView);
        textView = findViewById(R.id.pastaTextView);

        Intent intent = getIntent();
        int posicion = intent.getIntExtra("posicion", -1);
        Pasta p = PastaList.getPasta().get(posicion);

        new PastaLoader().execute( p, imageView );


        imageView.setImageURI(Uri.parse(p.getUrl()));
        textView.setText(p.getName());

    }
}

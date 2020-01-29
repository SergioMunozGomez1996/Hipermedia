package com.example.pastalist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PastaAdapter myAdapter;
    private ListView listView;
    private List<Pasta> listPasta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        listPasta = PastaList.getPasta();

        myAdapter = new PastaAdapter(getApplicationContext(), listPasta);
        listView.setAdapter(myAdapter);
        listView.setOnScrollListener(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getApplicationContext(),DetalleActivity.class);
                i.putExtra("posicion", position);
                startActivity(i);
            }
        });
    }
}

package com.example.menuopciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvTexto = (TextView) findViewById(R.id.tvTexto);
        registerForContextMenu(tvTexto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Toast.makeText(MainActivity.this, "presiono about", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ActivityAbout.class);
                break;
            case R.id.mOtro:
                Toast.makeText(MainActivity.this, "presiono otro", Toast.LENGTH_LONG).show();

                break;
            case R.id.mSetings:
                Toast.makeText(MainActivity.this, "presiono settings", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this, ActivitySetings.class);
            break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //MenuInflater inflater = MenuInflater(MainActivity.this);
        getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mDelete:
                Toast.makeText(MainActivity.this, "presiono delete", Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(MainActivity.this, ActivityAbout.class);
                break;

            case R.id.mEdit:
                Toast.makeText(MainActivity.this, "presiono editar", Toast.LENGTH_LONG).show();
                //ntent i = new Intent(MainActivity.this, ActivitySetings.class);
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void levantaPopUp(View v){
        ImageView imagen = (ImageView) findViewById(R.id.imgFer);
        PopupMenu popUpMenu = new PopupMenu(this, imagen);
        popUpMenu.getMenuInflater().inflate(R.menu.menu_popup, popUpMenu.getMenu());

        popUpMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mAlerta:
                        Toast.makeText(MainActivity.this, "presiono alerts", Toast.LENGTH_LONG).show();
                        //Intent intent = new Intent(MainActivity.this, ActivityAbout.class);
                        break;

                    case R.id.mCalma:
                        Toast.makeText(MainActivity.this, "presiono calma", Toast.LENGTH_LONG).show();
                        //ntent i = new Intent(MainActivity.this, ActivitySetings.class);
                        break;
                }
                return true;
            }
        });
        popUpMenu.show();

    }
}
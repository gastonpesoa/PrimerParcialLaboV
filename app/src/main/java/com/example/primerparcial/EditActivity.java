package com.example.primerparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Bundle extras = super.getIntent().getExtras();
        UsuarioModel usuario= (UsuarioModel) extras.getSerializable("usuario");
        Integer position = Integer.valueOf(extras.getInt("position"));
        Log.d("EditActivity", usuario.toString());
        Log.d("EditActivity", position.toString());

        UsuarioController usuarioController = new UsuarioController(this,usuario);
        UsuarioView usuarioView = new UsuarioView(this,usuario,usuarioController, position);
        usuarioController.setView(usuarioView);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Editar usuario");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
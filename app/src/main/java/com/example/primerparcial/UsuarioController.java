package com.example.primerparcial;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class UsuarioController implements View.OnClickListener {

    private Activity activity;
    private UsuarioModel model;
    private UsuarioView view;

    public UsuarioController(Activity activity, UsuarioModel model) {
        this.activity = activity;
        this.model = model;
    }

    public void setView(UsuarioView view) {
        this.view = view;
        this.view.mostrarModelo();

    }

    @Override
    public void onClick(View v) {
        if(this.view.modificarModelo()){
            Intent returnIntent = new Intent();
            returnIntent.putExtra("usuarioModificado", this.view.getModel());
            returnIntent.putExtra("positionModificado", this.view.getPosition().intValue());
            this.activity.setResult(Activity.RESULT_OK, returnIntent);
            this.activity.finish();
        }
    }
}

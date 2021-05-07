package com.example.primerparcial;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UsuarioView {

    private Button btnEditar;
    private EditText eTNombre;
    private EditText eTContrasenia;
    private EditText eTContraseniaRep;
    private RadioGroup rgTipo;
    private Activity activity;
    private UsuarioModel model;
    private UsuarioController controller;
    private Integer position;

    public UsuarioView(Activity activity, UsuarioModel model, UsuarioController controller, Integer position) {
        this.activity = activity;
        this.model = model;
        this.position = position;
        this.controller = controller;
        this.eTNombre = this.activity.findViewById(R.id.etNombre);
        this.eTContrasenia = this.activity.findViewById(R.id.etContrasenia);
        this.eTContraseniaRep = this.activity.findViewById(R.id.etContraseniaRep);
        this.rgTipo = this.activity.findViewById(R.id.rgTipo);
        this.btnEditar = this.activity.findViewById(R.id.btnSave);
        this.btnEditar.setOnClickListener(controller);
    }

    public UsuarioModel getModel() {
        return model;
    }

    public Integer getPosition() {
        return position;
    }

    public boolean modificarModelo(){
        boolean result = false;
        String nombre = this.eTNombre.getText().toString();
        String contrasenia = this.eTContrasenia.getText().toString();
        String contraseniaRep = this.eTContraseniaRep.getText().toString();
        if (!nombre.isEmpty() && !contrasenia.isEmpty() && !contraseniaRep.isEmpty()){
            if (contrasenia.equals(contraseniaRep) && nombre.length() > 2){
                int radioId = this.rgTipo.getCheckedRadioButtonId();
                RadioButton rbTipo = this.activity.findViewById(radioId);
                this.model.setNombre(nombre);
                this.model.setContrasenia(contrasenia);
                this.model.setTipoUsuario(rbTipo.getText().toString());
                result = true;
            }else {
                Toast.makeText(this.activity.getApplicationContext(),"Las contraseñas no son iguales o el nombre tiene menos de 3 caracteres", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this.activity.getApplicationContext(),"No pueden ser vacios los campos", Toast.LENGTH_LONG).show();
        }
        return result;
    }

    public void mostrarModelo(){
        this.eTNombre.setText(this.model.getNombre());
        this.eTContrasenia.setText(this.model.getContrasenia());
        RadioButton b;
        if(TipoUsuario.USUARIO.toString().equals(this.model.getTipoUsuario().toString())){
            b = (RadioButton) this.activity.findViewById(R.id.radioUser);
        } else {
            b = (RadioButton) this.activity.findViewById(R.id.radioAdmin);
        }
        b.setChecked(true);
    }
}

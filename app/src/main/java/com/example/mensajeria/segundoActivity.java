package com.example.mensajeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class segundoActivity extends AppCompatActivity {

    public static final String EXTRA_RESPUESTA2 = "cualquiera2";
    private TextView txtRecibido2 = null;
    private EditText edt_mensaje2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        txtRecibido2 = (TextView) findViewById(R.id.txtRecibido2);
        edt_mensaje2 = (EditText) findViewById(R.id.edtEnviado2);
        //-----------------------------------------------------
        Intent intent = getIntent();
        if(intent != null)
        {
            String texto = intent.getStringExtra(MainActivity.EXTRA_TEXTO1);
            txtRecibido2.setText(texto);
        }
    }

    public void responder(View View){
        String texto = String.valueOf(edt_mensaje2.getText());
        Intent intent = new Intent();
        intent.putExtra(EXTRA_RESPUESTA2, texto);
        setResult(RESULT_OK, intent);
        finish();

    }
}
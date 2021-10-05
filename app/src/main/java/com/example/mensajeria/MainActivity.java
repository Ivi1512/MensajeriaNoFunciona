package com.example.mensajeria;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXTO1 = "cualquiera1";

    private static final int PETICION1 = 1;
    private EditText edt_enviado1 = null;
    private TextView txtRecibido1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_enviado1 = (EditText) findViewById(R.id.edtEnviado1);
        txtRecibido1 = (TextView) findViewById(R.id.txtRecibido1);
    }

    public void enviar(View view) {
        String texto = String.valueOf(edt_enviado1.getText());
        Intent intent = new Intent(this, segundoActivity.class);
        intent.putExtra(EXTRA_TEXTO1, texto);
        //startActivity(intent); Esta es la forma de enviar cosas sin esperar respuesta
        //Ahora quiero iniciar un Activity y esperar una respuesta
        startActivityForResult(intent, PETICION1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PETICION1)
        {
            if(resultCode == RESULT_OK)
            {
                String texto = data.getStringExtra(segundoActivity.EXTRA_RESPUESTA2);
                txtRecibido1.setText(texto);
                edt_enviado1.setText("");
            }
        }
    }

}
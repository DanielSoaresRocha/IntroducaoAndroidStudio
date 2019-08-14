package com.example.bolsista.intent_aula;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Inicio extends AppCompatActivity {
    Button enviar;
    EditText texto;

    final int MY_RESULT_CODE = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        inicializar();

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Inicio.this,Tela2.class);

                String msg = texto.getText().toString();

                Bundle b = new Bundle();
                b.putString("TEXTO", msg);

                i.putExtras(b);

                startActivity(i);  //Navegar normalmente para outra tela
                Log.i("INTERACAO","CLICOU");
                //startActivityForResult(i,MY_RESULT_CODE);
            }
        });



    }

    private void inicializar() {
        enviar = findViewById(R.id.enviar);
        texto = findViewById(R.id.texto);
    }
}

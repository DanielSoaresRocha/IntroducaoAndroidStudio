package com.example.bolsista.intent_aula;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Tela2 extends AppCompatActivity {
    TextView textoView;

    final int MY_RESULT_CODE = 99;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        inicialiar();

        //pegarParametrosIntent();


        Intent i = new Intent();

        i.putExtra("DADOS_RESPOSTA", "Deu certo!");
        setResult(Activity.RESULT_OK, i);
        finish();

    }

    private void pegarParametrosIntent() {
        Intent params = getIntent();

        String msg = params.getStringExtra("TEXTO");

        textoView.setText(msg);
    }

    private void inicialiar() {
        textoView = findViewById(R.id.textoView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MY_RESULT_CODE){
            if(resultCode == Activity.RESULT_OK){
                String param = data.getStringExtra("DADOS_RESPOSTA");
                String resultado = param;

                Toast.makeText(this,"A resposta é "+ resultado, Toast.LENGTH_LONG).show();
            }else if(resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show();
            }
        }

    }
}

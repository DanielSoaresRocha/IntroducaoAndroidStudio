package com.example.testedaltonismo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {
    TextView titulo2;
    ImageView imagem;
    EditText editText;
    Button btnOk,cancelar;

    String valor;
    Intent i;

    int verifica = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        inicializar();

        Intent intent = getIntent();

        valor = intent.getStringExtra("imagem");

        if(valor.equals("um")){
            imagem.setImageResource(R.drawable.img1);
        }else if(valor.equals("dois")){
            imagem.setImageResource(R.drawable.img2);
        }else if(valor.equals("tres")){
            imagem.setImageResource(R.drawable.img3);
        }



        i = new Intent();


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("DADOS_RESPOSTA", editText.getText().toString());
                setResult(Activity.RESULT_OK, i);
                finish();

            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED, i);
                finish();
            }
        });

    }

    private void inicializar() {
        titulo2 = findViewById(R.id.titulo2);
        imagem = findViewById(R.id.imagem);
        editText = findViewById(R.id.editText);
        btnOk = findViewById(R.id.btnOk);
        cancelar = findViewById(R.id.cancelar);
    }
}

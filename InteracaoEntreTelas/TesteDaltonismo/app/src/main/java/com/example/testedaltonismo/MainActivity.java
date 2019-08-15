package com.example.testedaltonismo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btnVerifica;
    TextView tituloView, subtitulo, testeView,resp1,resp2,resp3,resultView;

    final int MY_RESULT_CODE1 = 99;
    final int MY_RESULT_CODE2 = 98;
    final int MY_RESULT_CODE3 = 97;

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();

        i = new Intent(MainActivity.this,Tela2.class);

        botoes();

    }

    private void botoes() {

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("imagem","um");
                startActivityForResult(i,MY_RESULT_CODE1);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("imagem","dois");
                startActivityForResult(i,MY_RESULT_CODE2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("imagem","tres");
                startActivityForResult(i,MY_RESULT_CODE3);
            }
        });

        btnVerifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resp1.getText().toString().equals("74") && resp2.getText().toString().equals("2") &&
                        resp3.getText().toString().equals("8")){
                    resultView.setText("Acertou");
                }else{
                    resultView.setText("Daltonismo");
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String param = data.getStringExtra("DADOS_RESPOSTA");
        if(requestCode == MY_RESULT_CODE1){
            if(resultCode == Activity.RESULT_OK){
                resp1.setText(param);
            }
        }else if(requestCode == MY_RESULT_CODE2){
            if(resultCode == Activity.RESULT_OK) {
                resp2.setText(param);
            }
        }else if(requestCode == MY_RESULT_CODE3){
            if(resultCode == Activity.RESULT_OK) {
                resp3.setText(param);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //outState.putInt("",4);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    private void iniciar() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btnVerifica = findViewById(R.id.btnVerifica);

        tituloView = findViewById(R.id.tituloView);
        subtitulo = findViewById(R.id.subtitulo);
        testeView = findViewById(R.id.testeView);
        resp1 = findViewById(R.id.resp1);
        resp2 = findViewById(R.id.resp2);
        resp3 = findViewById(R.id.resp3);
        resultView = findViewById(R.id.resultView);

    }



}

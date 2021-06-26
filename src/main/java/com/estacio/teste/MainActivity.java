package com.estacio.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    ////utilizando material.io da google;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutSenha;
    private TextView textViewRegistrarSe;
    private Button buttonLogar;
    private String emailPadrao = "thiago@gmail.com";
    private String senhaPadrao = "1234";
    private Intent intentIrTelaCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //        findVewById procura uma view pelo id dela !>
        textInputLayoutEmail = findViewById(R.id.textFieldEmail);
        textInputLayoutSenha = findViewById(R.id.textFieldSenha);
        textViewRegistrarSe = findViewById(R.id.textViewResgistrarSe);

        buttonLogar = findViewById(R.id.buttonLogar);

        //Método Construtor Intent(tela atual para a tela que desejo ir/ telaAtual.this, telaDesejada.class)
        intentIrTelaCadastro = new Intent(MainActivity.this, CadastroActivity.class);

        //TextView do button RegistrarSe para proxima tela de cadastrado
        textViewRegistrarSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(intentIrTelaCadastro);
            }
        });


        //  Validação do button LOGAR para ir tela desejada
        buttonLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = textInputLayoutEmail.getEditText().getText().toString();
                String senha = textInputLayoutSenha.getEditText().getText().toString();


                if (login.equals(emailPadrao) && senha.equals(senhaPadrao)) {
                    String mensagem = "ENTRANDO";
                    Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_SHORT).show();
                    textInputLayoutSenha.setError(null);
                    textInputLayoutEmail.setError(null);
                }else{
                    textInputLayoutSenha.setError("Senha ou Email errado");
                    textInputLayoutEmail.setError("Email errado");

                }
            }
        });
    }
}
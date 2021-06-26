package com.estacio.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.estacio.teste.model.Usuario;
import com.estacio.teste.utilidades.TextMask;
import com.estacio.teste.utilidades.ValidaCampos;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroActivity extends AppCompatActivity {

    //Referencia da Autenticação
    private FirebaseAuth autenticacao;
    //Referencia do banco de dados
    FirebaseDatabase banco = FirebaseDatabase.getInstance();

    DatabaseReference usuarios;

    TextInputLayout textInputLayoutNomeCompleto;
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutCelular;
    TextInputLayout textInputLayoutSenhaCadastro;
    TextInputLayout textInputLayoutSenhaCadastroConfirmacao;
    Button buttonRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        inicializaComponentes();
        validaCamposEMascaras();
        cadastrarUsuario();

    }

    public void inicializaComponentes(){
        textInputLayoutNomeCompleto = findViewById(R.id.textFieldNomeCompleto);
        textInputLayoutCelular = findViewById(R.id.textFieldCelular);
        textInputLayoutEmail = findViewById(R.id.textFieldEmail);
        textInputLayoutSenhaCadastro = findViewById(R.id.textFieldSenhaCadastro);
        textInputLayoutSenhaCadastroConfirmacao = findViewById(R.id.textFieldSenhaCadastroConfirmacao);
        buttonRegistrar = findViewById(R.id.buttonRegistrar);

    }

    public void validaCamposEMascaras (){
        textInputLayoutCelular.getEditText().addTextChangedListener(TextMask.mask(textInputLayoutCelular.getEditText(), TextMask.FORMAT_CELULAR));

    }

    public void cadastrarUsuario(){

        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean nomeValido = ValidaCampos.NOME_COMPLETO(textInputLayoutNomeCompleto.getEditText().getText().toString());
                if (nomeValido) {
                    textInputLayoutNomeCompleto.setError(null);
                } else {
                    textInputLayoutNomeCompleto.setError("Nome necessário");
                }

                Usuario novoUsuario = new Usuario();
                novoUsuario.setNomeCompleto(textInputLayoutNomeCompleto.getEditText().getText().toString());
                novoUsuario.setCelular(textInputLayoutCelular.getEditText().getText().toString());
                novoUsuario.setEmail(textInputLayoutEmail.getEditText().getText().toString());
                novoUsuario.setSenhaCadastrado(textInputLayoutSenhaCadastro.getEditText().getText().toString());
                novoUsuario.setSenhaCadastradoConfirmacao(textInputLayoutSenhaCadastroConfirmacao.getEditText().getText().toString());

                usuarios = banco.getReference("usuarios");

                usuarios.push().setValue(novoUsuario);

            }
        });

    }
}
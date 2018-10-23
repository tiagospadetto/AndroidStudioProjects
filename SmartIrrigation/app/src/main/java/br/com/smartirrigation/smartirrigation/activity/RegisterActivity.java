package br.com.smartirrigation.smartirrigation.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.smartirrigation.smartirrigation.R;
import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.User;
import br.com.smartirrigation.smartirrigation.task.PostUserTask;

public class RegisterActivity extends AppCompatActivity implements PostUserTask.PosUserCallBack{

    private EditText email ;
    private EditText senha ;
    private EditText nome ;
    private Button enviar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email_edit);
        senha = findViewById(R.id.senha_edit);
        nome = findViewById(R.id.nome_edit);
        enviar = findViewById(R.id.registrar_button);

        Toolbar album_toolbar=  findViewById(R.id.album_toolbar);
        album_toolbar.setTitle("Registrar");
        setSupportActionBar(album_toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        album_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              PostUserTask task = new PostUserTask(RegisterActivity.this);

              task.execute(nome.getText().toString(),email.getText().toString(),senha.getText().toString());
            }
        });


    }

    @Override
    public void PostUserSuccess(ResponseUser adduser) {
        if(adduser.getStatus().equals("sucesso")){

            Intent intent = new Intent(RegisterActivity.this,
                    LoginActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(getApplicationContext(), adduser.getMensagem(), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), adduser.getMensagem(), Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void PostUserFailure(String message) {


    }
}

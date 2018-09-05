package br.com.smartirrigation.smartirrigation.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.smartirrigation.smartirrigation.R;
import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.User;
import br.com.smartirrigation.smartirrigation.task.PostUserTask;

public class RegisterActivity extends AppCompatActivity implements PostUserTask.PosUserCallBack{

    private TextInputEditText email ;
    private TextInputEditText senha ;
    private TextInputEditText email2 ;
    private TextInputEditText senha2 ;
    private Button enviar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email_edit);
        senha = findViewById(R.id.senha_edit);
        email2 = findViewById(R.id.email2_edit);
        senha2 = findViewById(R.id.senha2_edit);
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
              if(email.getText().toString().equals(email2.getText().toString())){
                  if(senha.getText().toString().equals(senha2.getText().toString())){
                      PostUserTask task = new PostUserTask(RegisterActivity.this);

                      task.execute(email.getText().toString(),email.getText().toString(),senha.getText().toString());
                  }else {
                      Toast.makeText(getApplicationContext(), "Senhas diferem", Toast.LENGTH_SHORT).show();
                  }

              }else{
                  Toast.makeText(getApplicationContext(), "Email's Diferem", Toast.LENGTH_SHORT).show();
              }


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

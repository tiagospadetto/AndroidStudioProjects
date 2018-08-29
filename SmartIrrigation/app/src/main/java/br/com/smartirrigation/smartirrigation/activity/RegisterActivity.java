package br.com.smartirrigation.smartirrigation.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.smartirrigation.smartirrigation.R;
import br.com.smartirrigation.smartirrigation.model.User;
import br.com.smartirrigation.smartirrigation.task.PostUserTask;

public class RegisterActivity extends AppCompatActivity implements PostUserTask.PosUserCallBack{

    private TextInputEditText email ;
    private TextInputEditText senha ;
    private Button enviar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email_edit);
        senha = findViewById(R.id.senha_edit);
        enviar = findViewById(R.id.enviar_button);


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PostUserTask task = new PostUserTask(RegisterActivity.this);

                task.execute(email.getText().toString(),email.getText().toString(),senha.getText().toString());

            }
        });


    }

    @Override
    public void PostUserSuccess(Boolean teste) {

        Intent intent = new Intent(RegisterActivity.this,
                LoginActivity.class);
        startActivity(intent);
        finish();
        Toast.makeText(getApplicationContext(), "Usuario cadastrado com Sucesso !", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void PostUserFailure(String message) {


    }
}

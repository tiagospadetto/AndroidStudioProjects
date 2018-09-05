package br.com.smartirrigation.smartirrigation.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;

import br.com.smartirrigation.smartirrigation.R;
import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.User;
import br.com.smartirrigation.smartirrigation.model.UserReponse;
import br.com.smartirrigation.smartirrigation.task.ValidUserTask;

public class CodPassActivity extends AppCompatActivity implements ValidUserTask.ValidUserCallBack {

    private Button confirma_pass_button ;
    private TextInputEditText codigo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod_pass);

        confirma_pass_button = findViewById(R.id.confirma_pass_button);
        codigo = findViewById(R.id.cod_pass);
        Toolbar pass_toolbar =  findViewById(R.id.pass_cod_toolbar);
        pass_toolbar.setTitle("Digite o código");
        setSupportActionBar(pass_toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        pass_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        confirma_pass_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ValidUserTask task = new ValidUserTask(CodPassActivity.this,CodPassActivity.this);

                task.execute(codigo.getText().toString());
            }
        });
    }

    @Override
    public void ValidUserSuccess(UserReponse user) {

        if(user != null){

            User useraux = new User(user.getId(),user.getEmail(),user.getSenha(),user.getNome());

            Intent intent = new Intent(CodPassActivity.this,
                    ChangePassActivity.class);

            intent.putExtra("user", (Serializable) useraux);
            startActivity(intent);
        }else {
            Toast.makeText(getApplicationContext(), "Código Incorreto", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void ValidUserFailure(String message) {

    }
}

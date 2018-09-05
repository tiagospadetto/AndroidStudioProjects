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
import br.com.smartirrigation.smartirrigation.task.PassTask;

public class EsqPassActivity extends AppCompatActivity implements PassTask.PassCallBack{

    private Button enviar_button ;
    private TextInputEditText email ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esq_pass);

        enviar_button = findViewById(R.id.enviar_button);
        email = findViewById(R.id.email_pass);


        Toolbar pass_toolbar =  findViewById(R.id.pass_toolbar);
        pass_toolbar.setTitle("Esqueci Minha Senha");
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

        enviar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PassTask task = new PassTask(EsqPassActivity.this,EsqPassActivity.this);

                task.execute(email.getText().toString());

            }
        });
    }

    @Override
    public void PassSuccess(ResponseUser user) {
        Toast.makeText(getApplicationContext(), user.getMensagem(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EsqPassActivity.this,
                ChangePassActivity.class);
        startActivity(intent);

    }

    @Override
    public void PassFailure(String message) {

    }
}

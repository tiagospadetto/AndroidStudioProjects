package br.com.smartirrigation.smartirrigation.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import br.com.smartirrigation.smartirrigation.R;
import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.SaveSharedPreference;
import br.com.smartirrigation.smartirrigation.task.AtualizarPerfilTask;

public class EditEmailActivity extends AppCompatActivity implements AtualizarPerfilTask.AtualizarPerfilCallBack{

    private TextInputEditText email_editemail_edit;
    private Button salvaremail_edit_button;
    private Bundle dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_email);

        email_editemail_edit = findViewById(R.id.email_editemail_edit);
        salvaremail_edit_button = findViewById(R.id.salvaremail_edit_button);

        Toolbar edit_email_toolbar =  findViewById(R.id.edit_email_toolbar);
        edit_email_toolbar.setTitle("Digite o nova Senha");
        setSupportActionBar(edit_email_toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        edit_email_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(EditEmailActivity.this,HomeActivity.class);

                intent.putExtra("fragment", "PerfFragment");

                startActivity(intent);

                finish();

            }
        });

        dados = getIntent().getExtras();

        salvaremail_edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AtualizarPerfilTask task = new AtualizarPerfilTask(EditEmailActivity.this);

                task.execute(SaveSharedPreference.getUserName(EditEmailActivity.this),dados.get("nome").toString(),email_editemail_edit.getText().toString());
            }
        });

    }

    @Override
    public void AtualizarPerfilSuccess(ResponseUser teste) {


        Intent intent = new Intent(EditEmailActivity.this,HomeActivity.class);

        intent.putExtra("fragment", "PerfFragment");

        startActivity(intent);

        finish();
    }

    @Override
    public void AtualizarPerfilFailure(String message) {

    }
}

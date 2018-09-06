package br.com.smartirrigation.smartirrigation.activity;

import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import br.com.smartirrigation.smartirrigation.R;
import br.com.smartirrigation.smartirrigation.fragments.PerfFragment;
import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.SaveSharedPreference;
import br.com.smartirrigation.smartirrigation.task.AtualizarPerfilTask;

public class EditNameActivity extends AppCompatActivity implements AtualizarPerfilTask.AtualizarPerfilCallBack{

    private TextInputEditText  nome_edit;
    private Button salvar_edit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);


        nome_edit = findViewById(R.id.nome_edit);
        salvar_edit_button = findViewById(R.id.salvar_edit_button);

        Toolbar edit_name_toolbar =  findViewById(R.id.edit_name_toolbar);
        edit_name_toolbar.setTitle("Digite o novo nome");
        setSupportActionBar(edit_name_toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        edit_name_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

        salvar_edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AtualizarPerfilTask task = new AtualizarPerfilTask(EditNameActivity.this);

                task.execute(SaveSharedPreference.getUserName(EditNameActivity.this),nome_edit.getText().toString(),"tiagospadetto@gmail.com");
            }
        });

    }

    @Override
    public void AtualizarPerfilSuccess(ResponseUser teste) {

        finish();
    }

    @Override
    public void AtualizarPerfilFailure(String message) {

    }
}

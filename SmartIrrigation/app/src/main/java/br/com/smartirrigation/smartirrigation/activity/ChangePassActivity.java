package br.com.smartirrigation.smartirrigation.activity;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.smartirrigation.smartirrigation.R;
import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.User;
import br.com.smartirrigation.smartirrigation.task.AlterarSenhaTask;

public class ChangePassActivity extends AppCompatActivity implements AlterarSenhaTask.AlterarSenhaCallBack{

    private User user ;
    private TextInputEditText pass_change ;
    private TextInputEditText pass_change2 ;
    private Button confirma_change_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);


        Bundle dados = getIntent().getExtras();

        user = (User) dados.getSerializable("user");

        pass_change = findViewById(R.id.pass_change);
        pass_change2 = findViewById(R.id.pass_change2);
        confirma_change_button = findViewById(R.id.confirma_change_button);

        confirma_change_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(pass_change.getText().toString().equals(pass_change2.getText().toString())){

                    AlterarSenhaTask task = new AlterarSenhaTask(ChangePassActivity.this,ChangePassActivity.this);

                    task.execute(user.getId(),user.getNome(),user.getEmail(),pass_change.getText().toString());

                }else{
                    Toast.makeText(getApplicationContext(), "Emails diferem", Toast.LENGTH_SHORT).show();
                }

            }
        });






    }

    @Override
    public void AlterarSenhaSuccess(ResponseUser user) {

    }

    @Override
    public void AlterarSenhaFailure(String message) {

    }
}

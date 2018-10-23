package br.com.smartirrigation.smartirrigation.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import java.util.regex.Pattern;

import br.com.smartirrigation.smartirrigation.R;
import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.SaveSharedPreference;
import br.com.smartirrigation.smartirrigation.task.AtualizarPerfilTask;

public class EditEmailActivity extends AppCompatActivity implements AtualizarPerfilTask.AtualizarPerfilCallBack{

    private TextInputEditText email_editemail_edit;
    private TextInputLayout textInputEmail;
    private Button salvaremail_edit_button;
    private Bundle dados;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_email);

        email_editemail_edit = findViewById(R.id.email_editemail_edit);
        salvaremail_edit_button = findViewById(R.id.salvaremail_edit_button);
        textInputEmail = findViewById(R.id.text_input_email);

        Toolbar edit_email_toolbar =  findViewById(R.id.edit_email_toolbar);
        edit_email_toolbar.setTitle("Digite o novo Email");
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

        email_editemail_edit.setText(dados.get("email").toString());

        salvaremail_edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validateEmail() ){
                    AtualizarPerfilTask task = new AtualizarPerfilTask(EditEmailActivity.this);

                    task.execute(SaveSharedPreference.getUserName(EditEmailActivity.this),dados.get("nome").toString(),email_editemail_edit.getText().toString());
                }

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

    private boolean validateEmail() {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.setError("Please enter a valid email address");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }
    @Override
    public void AtualizarPerfilFailure(String message) {

    }
}

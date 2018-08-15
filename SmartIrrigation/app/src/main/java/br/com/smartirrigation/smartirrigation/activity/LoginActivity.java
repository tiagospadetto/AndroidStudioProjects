package br.com.smartirrigation.smartirrigation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.smartirrigation.smartirrigation.R;

public class LoginActivity extends AppCompatActivity {

    private Button login_Button;
    private TextView cadastrar_textView;
    private TextView esqsenha_TextView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_Button = findViewById(R.id.enviar_button);
        cadastrar_textView = findViewById(R.id.cadastrar_textView);
        esqsenha_TextView =  findViewById(R.id.esqsenha_TextView);

        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,
                        HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cadastrar_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this,
                        RegisterActivity.class);
                startActivity(intent);

            }
        });

        esqsenha_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this,
                        EsqPassActivity.class);
                startActivity(intent);

            }
        });


    }
}

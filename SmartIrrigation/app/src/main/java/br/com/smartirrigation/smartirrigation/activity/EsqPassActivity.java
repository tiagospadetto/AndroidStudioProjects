package br.com.smartirrigation.smartirrigation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.smartirrigation.smartirrigation.R;

public class EsqPassActivity extends AppCompatActivity {

    private Button enviar_button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esq_pass);

        enviar_button = findViewById(R.id.enviar_button);

        enviar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(EsqPassActivity.this,
                        ChangePassActivity.class);
                startActivity(intent);

            }
        });
    }
}

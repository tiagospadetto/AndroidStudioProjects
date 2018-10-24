package br.com.smartirrigation.smartirrigation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

import br.com.smartirrigation.smartirrigation.R;
import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.SaveSharedPreference;
import br.com.smartirrigation.smartirrigation.task.AddCanteiroTask;

public class AddCantActivity extends AppCompatActivity implements AddCanteiroTask.AddCanteiroCallBack {

    private Button add_cant_button;
    private EditText add_id_equip_cant_textview;
    private EditText add_id_cant_textview;
    private EditText add_id_bome_cant_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cant);

        add_cant_button = findViewById(R.id.add_cant_button);
        add_id_equip_cant_textview = findViewById(R.id.add_id_equip_cant_textview);
        add_id_cant_textview = findViewById(R.id.add_id_cant_textview);
        add_id_bome_cant_textview = findViewById(R.id.add_id_bome_cant_textview);


        add_id_equip_cant_textview.setText(SaveSharedPreference.getIdEquip(getApplicationContext()));
        add_id_cant_textview.setText(UUID.randomUUID().toString());

        add_cant_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(add_id_bome_cant_textview.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(), "Erro: Nome do Canteiro vazio", Toast.LENGTH_SHORT).show();

                }else {
                    AddCanteiroTask task = new AddCanteiroTask(AddCantActivity.this);
                    task.execute(add_id_cant_textview.getText().toString(),add_id_equip_cant_textview.getText().toString(),add_id_bome_cant_textview.getText().toString());
                }
            }
        });


    }

    @Override
    public void AddCanteiroSuccess(ResponseUser teste) {

        Toast.makeText(getApplicationContext(), teste.getMensagem(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void AddCanteiroFailure(String message) {

    }
}

package br.com.smartirrigation.smartirrigation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.smartirrigation.smartirrigation.R;
import br.com.smartirrigation.smartirrigation.model.EquipsUser;
import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.SaveSharedPreference;
import br.com.smartirrigation.smartirrigation.task.AddEquipUserTask;

public class AddEquipActivity extends AppCompatActivity implements AddEquipUserTask.AddEquipUserTaskCallBack {

    private EditText add_id_equip_textview ;
    private Button add_equip_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_equip);


        add_id_equip_textview = findViewById(R.id.add_id_equip_textview);
        add_equip_button = findViewById(R.id.add_equip_button);

        Toolbar addequip_toolbar =  findViewById(R.id.addequip_toolbar);
        addequip_toolbar.setTitle("Voltar");
        setSupportActionBar(addequip_toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        addequip_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        add_equip_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddEquipUserTask task = new AddEquipUserTask(AddEquipActivity.this);

                task.execute(SaveSharedPreference.getUserName(getApplicationContext()), add_id_equip_textview.getText().toString());
            }
        });


    }

    @Override
    public void AddEquipUserTaskSuccess(ResponseUser equips) {

        finish();
        Toast.makeText(getApplicationContext(), equips.getMensagem(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void AddEquipUserTaskFailure(String message) {

    }
}

package br.com.smartirrigation.smartirrigation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.smartirrigation.smartirrigation.R;
import br.com.smartirrigation.smartirrigation.adapter.EquipAdapter;
import br.com.smartirrigation.smartirrigation.model.EquipResponse;
import br.com.smartirrigation.smartirrigation.model.EquipsUser;
import br.com.smartirrigation.smartirrigation.model.SaveSharedPreference;
import br.com.smartirrigation.smartirrigation.task.EquipUserTask;

public class EquipamentoActivity extends AppCompatActivity implements EquipUserTask.EquipUserCallBack {


    private Button adcionar_equip_butto;
    private RecyclerView equip_recycler_view;
    private List<EquipResponse> equips = new ArrayList<>();
    private EquipAdapter adapter;
    private TextView num_equip_text_view ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipamento);

        adcionar_equip_butto = findViewById(R.id.adcionar_equip_butto);
        equip_recycler_view = findViewById(R.id.equip_recycler_view);
        num_equip_text_view = findViewById(R.id.num_equip_text_view);

        EquipUserTask task = new EquipUserTask(EquipamentoActivity.this, getApplicationContext());
        task.execute(SaveSharedPreference.getUserName(getApplicationContext()));

        adapter = new EquipAdapter(equips,EquipamentoActivity.this);

        equip_recycler_view.setAdapter(adapter);
        equip_recycler_view.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        equip_recycler_view.setHasFixedSize(true);

        adcionar_equip_butto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(EquipamentoActivity.this, AddEquipActivity.class);
                startActivity(intent2);

            }
        });

    }

    @Override
    public void EquipUserSuccess(List<EquipResponse> response) {

        equips= response;

        adapter = new EquipAdapter(equips,EquipamentoActivity.this);

        equip_recycler_view.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        num_equip_text_view.setText(Integer.toString(equips.size()));

        if(equips.size() > 0){
            adcionar_equip_butto.setEnabled(false);
        }
    }

    @Override
    public void EquipUserFailure(String message) {

    }
}

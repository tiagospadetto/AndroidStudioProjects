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
import br.com.smartirrigation.smartirrigation.adapter.CantAdapter;
import br.com.smartirrigation.smartirrigation.model.CantResponse;
import br.com.smartirrigation.smartirrigation.model.SaveSharedPreference;
import br.com.smartirrigation.smartirrigation.task.CantUserTask;

public class CanteiroActivity extends AppCompatActivity implements CantUserTask.CantUserCallBack {

    private Button adcionar_cant_button;
    private RecyclerView cant_recycler_view;
    private List<CantResponse> cants = new ArrayList<>();
    private CantAdapter adapter;
    private TextView num_cant_text_view ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteiro);

        adcionar_cant_button = findViewById(R.id.adcionar_cant_button);
        cant_recycler_view = findViewById(R.id.cant_recycler_view);
        num_cant_text_view = findViewById(R.id.num_cant_text_view);

        CantUserTask tsk = new CantUserTask(CanteiroActivity.this);
        tsk.execute(SaveSharedPreference.getIdEquip(getApplicationContext()));

        adapter = new CantAdapter(cants,getApplicationContext());
        cant_recycler_view.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        cant_recycler_view.setHasFixedSize(true);

        adcionar_cant_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CanteiroActivity.this, AddCantActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void CantUserSuccess(List<CantResponse> cants) {

        num_cant_text_view.setText(Integer.toString(cants.size()));
    }

    @Override
    public void CantUserFailure(String message) {

    }
}

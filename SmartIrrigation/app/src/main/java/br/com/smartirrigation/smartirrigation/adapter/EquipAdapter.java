package br.com.smartirrigation.smartirrigation.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.smartirrigation.smartirrigation.R;
import br.com.smartirrigation.smartirrigation.model.EquipResponse;

public class EquipAdapter extends RecyclerView.Adapter<EquipAdapter.EquipViewHolder> {

    private List<EquipResponse> equips ;
    private Context context ;

    public EquipAdapter(List<EquipResponse> equips, Context context) {
        this.equips = equips;
        this.context = context;
    }

    @NonNull
    @Override
    public EquipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.equiplist, parent, false);
        return new EquipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EquipAdapter.EquipViewHolder equipViewHolder, int psition) {

        if(equips!= null){

            EquipResponse equip = equips.get(psition);

            equipViewHolder.equipe_title_TextView.setText(equip.getNome().toString());

            equipViewHolder.id_Equip_TextView.setText(equip.getIdEquipamento().toString());
        }

    }

    @Override
    public int getItemCount() {
        if(equips!= null){

            return (equips.size());
        }
        return (0);
    }

    public class EquipViewHolder extends RecyclerView.ViewHolder {

        private TextView equipe_title_TextView;
        private TextView id_Equip_TextView;

        public EquipViewHolder(View itemView) {
            super(itemView);

            id_Equip_TextView = itemView.findViewById(R.id.id_Equip_TextView);
            equipe_title_TextView = itemView.findViewById(R.id.equipe_title_TextView);

        }


    }
}

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
import br.com.smartirrigation.smartirrigation.model.CantResponse;
import br.com.smartirrigation.smartirrigation.model.EquipResponse;

public class CantAdapter extends RecyclerView.Adapter<CantAdapter.CantViewHolder> {

    private List<CantResponse> cants ;
    private Context context ;

    public CantAdapter(List<CantResponse> cants, Context context) {
        this.cants = cants;
        this.context = context;
    }

    @NonNull
    @Override
    public CantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cantlist, parent, false);
        return new CantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CantAdapter.CantViewHolder CantHolder, int psition) {

        if(cants!= null){

            CantResponse equip = cants.get(psition);

            CantHolder.cant_title_TextView.setText(equip.getNome().toString());

            CantHolder.id_Cant_TextView.setText(equip.getIdCanteiro().toString());
        }

    }

    @Override
    public int getItemCount() {
        if(cants!= null){

            return (cants.size());
        }
        return (0);
    }

    public class CantViewHolder extends RecyclerView.ViewHolder {

        private TextView cant_title_TextView;
        private TextView id_Cant_TextView;

        public CantViewHolder(View itemView) {
            super(itemView);

            id_Cant_TextView = itemView.findViewById(R.id.id_cant_TextView);
            cant_title_TextView = itemView.findViewById(R.id.cant_title_TextView);

        }


    }
}

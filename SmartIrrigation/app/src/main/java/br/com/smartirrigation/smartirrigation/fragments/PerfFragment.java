package br.com.smartirrigation.smartirrigation.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.smartirrigation.smartirrigation.R;
import br.com.smartirrigation.smartirrigation.activity.EditEmailActivity;
import br.com.smartirrigation.smartirrigation.activity.EditNameActivity;
import br.com.smartirrigation.smartirrigation.activity.EquipamentoActivity;
import br.com.smartirrigation.smartirrigation.activity.HomeActivity;
import br.com.smartirrigation.smartirrigation.interfaces.TratReturn;
import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.SaveSharedPreference;
import br.com.smartirrigation.smartirrigation.model.User;
import br.com.smartirrigation.smartirrigation.model.UserReponse;
import br.com.smartirrigation.smartirrigation.task.GetUserTask;

import static br.com.smartirrigation.smartirrigation.R.color.colorPrimary;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfFragment extends Fragment implements GetUserTask.GetUserCallBack,TratReturn {

    private TextView nome_user ;
    private TextView email_user ;
    private TextView equipamento_quant;
    private ImageView edit_user;
    private ImageView edit_email;
    private CardView equipamento_card_view;


    private UserReponse user ;
    public PerfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_perf, container, false);

        nome_user = view.findViewById(R.id.nome_user);
        email_user = view.findViewById(R.id.email_user);
        edit_user = view.findViewById(R.id.edit_user);
        edit_email = view.findViewById(R.id.edit_email);
        equipamento_quant = view.findViewById(R.id.equipamento_quant);
        equipamento_card_view = view.findViewById(R.id.equipamento_card_view);

        atualizaFragmentComResposta();


        equipamento_card_view.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
              // equipamento_card_view.setCardElevation(1);
               // equipamento_card_view.setCardBackgroundColor(colorPrimary);


                Intent intent2 = new Intent(getActivity(),
                        EquipamentoActivity.class);

                startActivity(intent2);


            }
        });


        edit_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),
                        EditNameActivity.class);

                intent.putExtra("email", email_user.getText().toString());
                startActivity(intent);

                getActivity().finish();
            }
        });

        edit_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),
                        EditEmailActivity.class);

                intent.putExtra("nome", nome_user.getText().toString());
                intent.putExtra("email", email_user.getText().toString());
                startActivity(intent);

                getActivity().finish();
            }
        });

        return view;
    }

    @Override
    public void GetUserSuccess(UserReponse userres) {

        if(userres != null){

            user = userres;

            nome_user.setText(user.getNome().toString());
            email_user.setText(user.getEmail());
        }
    }

    @Override
    public void GetUserFailure(String message) {

    }

    @Override
    public void atualizaFragmentComResposta() {

        GetUserTask task = new GetUserTask(PerfFragment.this);

        task.execute(SaveSharedPreference.getUserName(getActivity())) ;
    }
}

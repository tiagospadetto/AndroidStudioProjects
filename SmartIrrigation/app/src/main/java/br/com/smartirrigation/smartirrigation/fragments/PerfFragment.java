package br.com.smartirrigation.smartirrigation.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.smartirrigation.smartirrigation.R;
import br.com.smartirrigation.smartirrigation.activity.EditEmailActivity;
import br.com.smartirrigation.smartirrigation.activity.EditNameActivity;
import br.com.smartirrigation.smartirrigation.activity.HomeActivity;
import br.com.smartirrigation.smartirrigation.interfaces.TratReturn;
import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.SaveSharedPreference;
import br.com.smartirrigation.smartirrigation.model.User;
import br.com.smartirrigation.smartirrigation.model.UserReponse;
import br.com.smartirrigation.smartirrigation.task.GetUserTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfFragment extends Fragment implements GetUserTask.GetUserCallBack,TratReturn {

    private TextView nome_user ;
    private TextView email_user ;
    private ImageView edit_user;
    private ImageView edit_email;
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

        atualizaFragmentComResposta();

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

package br.com.smartirrigation.smartirrigation.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;

import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.UserReponse;
import br.com.smartirrigation.smartirrigation.services.GetPass;
import br.com.smartirrigation.smartirrigation.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Response;

public class GetUserTask extends AsyncTask< String, Void, Response<UserReponse>> {


    private GetUserCallBack delegate;


    public GetUserTask(GetUserCallBack delegate) {
        this.delegate = delegate;

    }


    @Override
    protected Response<UserReponse> doInBackground(String... params) {

        GetPass service = RetrofitUtil.getInstance().create(GetPass.class);

        Call<UserReponse> call = service.getuser(params[0]);

        try {
            return call.execute();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
     /*   load = ProgressDialog.show(context, "Por favor Aguarde ...",
                "Enviando Link ...");
                */
    }

    @Override
    protected void onPostExecute(Response<UserReponse> response) {

        if (response == null || !response.isSuccessful()) {
            delegate.GetUserFailure("Erro ao recuperar senha usuario.");
        } else {
            delegate.GetUserSuccess(response.body());
        }

    }
    public interface GetUserCallBack{

        public void GetUserSuccess(UserReponse teste);
        public void GetUserFailure(String message);

    }
}

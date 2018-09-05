package br.com.smartirrigation.smartirrigation.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;

import br.com.smartirrigation.smartirrigation.model.UserReponse;
import br.com.smartirrigation.smartirrigation.services.UserPost;
import br.com.smartirrigation.smartirrigation.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Response;

public class ValidUserTask extends AsyncTask< String, Void, Response<UserReponse>> {

    private ValidUserCallBack delegate;
    private Context context;
    private ProgressDialog load ;

    public ValidUserTask(ValidUserCallBack delegate ,Context  context) {
        this.delegate = delegate;
        this.context = context;
    }


    @Override
    protected Response<UserReponse> doInBackground(String... params) {


        UserPost service = RetrofitUtil.getInstance().create(UserPost.class);

        Call<UserReponse> call = service.validUser( params[0]);

        try {
            return call.execute();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
      /*  load = ProgressDialog.show(context, "Por favor Aguarde ...",
                "Validando codigo ...");*/
    }

    @Override
    protected void onPostExecute(Response<UserReponse> response) {

        if (response == null || !response.isSuccessful()) {
            delegate.ValidUserFailure("Erro ao incluir usuario.");
        } else {
            delegate.ValidUserSuccess(response.body());
        }
       // load.dismiss();
    }
    public interface ValidUserCallBack{

        public void ValidUserSuccess(UserReponse user);
        public void ValidUserFailure(String message);

    }
}
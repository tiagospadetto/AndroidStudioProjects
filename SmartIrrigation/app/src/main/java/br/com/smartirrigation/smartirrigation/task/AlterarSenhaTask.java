package br.com.smartirrigation.smartirrigation.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;

import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.services.UserPost;
import br.com.smartirrigation.smartirrigation.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Response;

public class AlterarSenhaTask  extends AsyncTask< String, Void, Response<ResponseUser>> {

    private AlterarSenhaCallBack delegate;
    private Context context;
  //  private ProgressDialog load ;

    public AlterarSenhaTask(AlterarSenhaCallBack delegate ,Context  context) {
        this.delegate = delegate;
        this.context = context;
    }


    @Override
    protected Response<ResponseUser> doInBackground(String... params) {


        UserPost service = RetrofitUtil.getInstance().create(UserPost.class);

        Call<ResponseUser> call = service.alterarSenha(params[0],params[1],params[2],params[3]);

        try {
            return call.execute();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }
/*
    @Override
    protected void onPreExecute() {

        load = ProgressDialog.show(context, "Por favor Aguarde ...",
                "Alterando Senha ...");
    }
*/
    @Override
    protected void onPostExecute(Response<ResponseUser> response) {

        if (response == null || !response.isSuccessful()) {
            delegate.AlterarSenhaFailure("Erro ao incluir usuario.");
        } else {
            delegate.AlterarSenhaSuccess(response.body());
        }
       // load.dismiss();
    }
    public interface AlterarSenhaCallBack{

        public void AlterarSenhaSuccess(ResponseUser teste);
        public void AlterarSenhaFailure(String message);

    }
}

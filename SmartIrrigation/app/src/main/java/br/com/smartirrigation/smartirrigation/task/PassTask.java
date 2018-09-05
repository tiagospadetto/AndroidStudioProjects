package br.com.smartirrigation.smartirrigation.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;

import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.services.GetPass;
import br.com.smartirrigation.smartirrigation.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Response;

public class PassTask  extends AsyncTask< String, Void, Response<ResponseUser>> {


    private PassCallBack delegate;
    private Context context;
    private ProgressDialog load ;

    public PassTask(PassCallBack delegate, Context context) {
        this.delegate = delegate;
        this.context = context;
    }


    @Override
    protected Response<ResponseUser> doInBackground(String... params) {

        GetPass service = RetrofitUtil.getInstance().create(GetPass.class);

        Call<ResponseUser> call = service.getpassr(params[0]);

        try {
            return call.execute();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        load = ProgressDialog.show(context, "Por favor Aguarde ...",
                "Enviando Link ...");
    }

    @Override
    protected void onPostExecute(Response<ResponseUser> response) {

        if (response == null || !response.isSuccessful()) {
            delegate.PassFailure("Erro ao recuperar senha usuario.");
        } else {
            delegate.PassSuccess(response.body());
        }
        load.dismiss();
    }
    public interface PassCallBack{

        public void PassSuccess(ResponseUser teste);
        public void PassFailure(String message);

    }
}

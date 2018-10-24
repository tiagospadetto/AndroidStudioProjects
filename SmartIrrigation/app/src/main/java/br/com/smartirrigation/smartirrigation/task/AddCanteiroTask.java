package br.com.smartirrigation.smartirrigation.task;

import android.os.AsyncTask;

import java.io.IOException;

import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.services.UserPost;
import br.com.smartirrigation.smartirrigation.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Response;

public class AddCanteiroTask extends AsyncTask< String, Void, Response<ResponseUser>> {

    private  AddCanteiroCallBack delegate;


    public AddCanteiroTask( AddCanteiroCallBack delegate ) {
        this.delegate = delegate;
    }


    @Override
    protected Response<ResponseUser> doInBackground(String... params) {


        UserPost service = RetrofitUtil.getInstance().create(UserPost.class);

        Call<ResponseUser> call = service.addcanteiro(params[0],params[1],params[2]);

        try {
            return call.execute();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Response<ResponseUser> response) {

        if (response == null || !response.isSuccessful()) {
            delegate. AddCanteiroFailure("Erro ao incluir usuario.");
        } else {
            delegate. AddCanteiroSuccess(response.body());
        }


    }
    public interface  AddCanteiroCallBack{

        public void  AddCanteiroSuccess(ResponseUser teste);
        public void  AddCanteiroFailure(String message);

    }
}

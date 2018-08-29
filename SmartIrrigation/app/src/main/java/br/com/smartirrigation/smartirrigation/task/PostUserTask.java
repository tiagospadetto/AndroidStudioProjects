package br.com.smartirrigation.smartirrigation.task;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.UUID;

import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.User;
import br.com.smartirrigation.smartirrigation.services.UserPost;
import br.com.smartirrigation.smartirrigation.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Response;


public class PostUserTask extends AsyncTask< String, Void, Response<ResponseUser>> {

    private PosUserCallBack delegate;

    public PostUserTask(PosUserCallBack delegate) {
        this.delegate = delegate;
    }

    @Override
    protected Response<ResponseUser> doInBackground(String... params) {

        String Id = UUID.randomUUID().toString();

        UserPost service = RetrofitUtil.getInstance().create(UserPost.class);

        Call<ResponseUser> call = service.registerUser(Id,params[0],params[1],params[2]);

        try {
            return call.execute();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Response<ResponseUser> response) {

        if(response == null || !response.isSuccessful()){
            delegate.PostUserFailure("Erro ao incluir usuario.");
        } else {
            delegate.PostUserSuccess(response.isSuccessful());
        }

    }
    public interface PosUserCallBack{

        public void PostUserSuccess(Boolean teste);
        public void PostUserFailure(String message);

    }
}

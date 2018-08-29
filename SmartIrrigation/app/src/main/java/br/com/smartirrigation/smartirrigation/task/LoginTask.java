package br.com.smartirrigation.smartirrigation.task;

import android.os.AsyncTask;

import java.io.IOException;

import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.services.UserPost;
import br.com.smartirrigation.smartirrigation.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Response;

public class LoginTask extends AsyncTask< String, Void, Response<ResponseUser>> {

    private LoginCallBack delegate;

    public LoginTask(LoginCallBack delegate) {
        this.delegate = delegate;
    }


    @Override
    protected Response<ResponseUser> doInBackground(String... params) {


        UserPost service = RetrofitUtil.getInstance().create(UserPost.class);

        Call<ResponseUser> call = service.loginUser(params[0],params[1]);

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
            delegate.LoginFailure("Erro ao incluir usuario.");
        } else {
            delegate.LoginSuccess(response.body());
        }
    }
    public interface LoginCallBack{

        public void LoginSuccess(ResponseUser teste);
        public void LoginFailure(String message);

    }
}

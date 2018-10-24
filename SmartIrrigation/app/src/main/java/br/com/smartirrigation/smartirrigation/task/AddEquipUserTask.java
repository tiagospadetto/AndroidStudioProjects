package br.com.smartirrigation.smartirrigation.task;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;

import br.com.smartirrigation.smartirrigation.model.EquipsUser;
import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.services.UserPost;
import br.com.smartirrigation.smartirrigation.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Response;

public class AddEquipUserTask extends AsyncTask< String, Void, Response<ResponseUser>> {


    private AddEquipUserTaskCallBack delegate;


    public AddEquipUserTask(AddEquipUserTaskCallBack delegate) {
        this.delegate = delegate;

    }

    @Override
    protected Response<ResponseUser> doInBackground(String... params) {

        UserPost service = RetrofitUtil.getInstance().create(UserPost.class);

        Call<ResponseUser> call = service.equipamentos_user_add( params[0],params[1]);

        try {
            return call.execute();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(Response<ResponseUser> response) {

        if (response == null || !response.isSuccessful()) {
            delegate.AddEquipUserTaskFailure("Erro ao buscar equipamento");
        } else {
            delegate.AddEquipUserTaskSuccess(response.body());
        }

    }
    public interface AddEquipUserTaskCallBack{

        public void AddEquipUserTaskSuccess(ResponseUser equips);
        public void AddEquipUserTaskFailure(String message);

    }
}

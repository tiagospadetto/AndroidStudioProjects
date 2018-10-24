package br.com.smartirrigation.smartirrigation.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import br.com.smartirrigation.smartirrigation.model.EquipResponse;
import br.com.smartirrigation.smartirrigation.model.EquipsUser;
import br.com.smartirrigation.smartirrigation.services.UserPost;
import br.com.smartirrigation.smartirrigation.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Response;

public class EquipUserTask extends AsyncTask< String, Void, Response<List<EquipResponse>>> {


    private EquipUserCallBack delegate;
    private Context context;

    public EquipUserTask(EquipUserCallBack delegate, Context context) {
        this.delegate = delegate;
        this.context = context;
    }

    @Override
    protected Response<List<EquipResponse>> doInBackground(String... params) {

        UserPost service = RetrofitUtil.getInstance().create(UserPost.class);

        Call<List<EquipResponse>> call = service.equipamentos_user( params[0]);

        try {
            return call.execute();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(Response<List<EquipResponse>> response) {

        if (response == null || !response.isSuccessful()) {
            delegate.EquipUserFailure("Erro ao buscar equipamento");
        } else {
            delegate.EquipUserSuccess(response.body());
        }

    }
    public interface EquipUserCallBack{

        public void EquipUserSuccess(List<EquipResponse> equips);
        public void EquipUserFailure(String message);

    }


}

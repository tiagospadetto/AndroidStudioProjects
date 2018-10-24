package br.com.smartirrigation.smartirrigation.task;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import br.com.smartirrigation.smartirrigation.model.CantResponse;
import br.com.smartirrigation.smartirrigation.model.EquipResponse;
import br.com.smartirrigation.smartirrigation.services.GetPass;
import br.com.smartirrigation.smartirrigation.services.UserPost;
import br.com.smartirrigation.smartirrigation.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Response;

public class CantUserTask extends AsyncTask< String, Void, Response<List<CantResponse>>> {


    private CantUserCallBack delegate;
    private Context context;

    public CantUserTask(CantUserCallBack delegate) {
        this.delegate = delegate;

    }

    @Override
    protected Response<List<CantResponse>> doInBackground(String... params) {

        GetPass service = RetrofitUtil.getInstance().create(GetPass.class);

        Call<List<CantResponse>> call = service.canteiros_user( params[0]);

        try {
            return call.execute();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(Response<List<CantResponse>> response) {

        if (response == null || !response.isSuccessful()) {
            delegate.CantUserFailure("Erro ao buscar equipamento");
        } else {
            delegate.CantUserSuccess(response.body());
        }

    }
    public interface CantUserCallBack{

        public void CantUserSuccess(List<CantResponse> equips);
        public void CantUserFailure(String message);

    }


}

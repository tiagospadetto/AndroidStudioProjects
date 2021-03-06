package br.com.smartirrigation.smartirrigation.services;
import java.util.List;

import br.com.smartirrigation.smartirrigation.model.CantResponse;
import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.UserReponse;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface GetPass {


    @GET("api/Usuario/RecuperarSenha")
    public Call<ResponseUser> getpassr(@Query("Email") String Email);

    @GET("api/Usuario/ObterUsuario")
    public Call<UserReponse> getuser(@Query("IdUsuario") String IdUsuario);

    @GET("api/Canteiro/ObterPeloEquipamento")
    public Call<List<CantResponse>> canteiros_user(@Query("IdEquipamento") String IdEquipamento);
}

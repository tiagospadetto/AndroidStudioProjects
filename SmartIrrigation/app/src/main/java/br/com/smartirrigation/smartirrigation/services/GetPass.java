package br.com.smartirrigation.smartirrigation.services;
import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface GetPass {


    @GET("api/Usuario/RecuperarSenha")
    public Call<ResponseUser> getpassr(@Query("Email") String Email);
}

package br.com.smartirrigation.smartirrigation.services;

import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserPost {

    @FormUrlEncoded
    @POST("api/Usuario/AdicionarUsuario")
    public Call<ResponseUser> registerUser(@Field("Id") String Id, @Field("Nome") String Nome, @Field("Email") String Email, @Field("Senha") String Senha);

    @FormUrlEncoded
    @POST("api/Usuario/EfetuarLogin")
    public Call<ResponseUser> loginUser( @Field("Email") String Email, @Field("Senha") String Senha);

}

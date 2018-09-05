package br.com.smartirrigation.smartirrigation.services;

import br.com.smartirrigation.smartirrigation.model.ResponseUser;
import br.com.smartirrigation.smartirrigation.model.User;
import br.com.smartirrigation.smartirrigation.model.UserReponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface UserPost {

    @FormUrlEncoded
    @POST("api/Usuario/AdicionarUsuario")
    public Call<ResponseUser> registerUser(@Field("Id") String Id, @Field("Nome") String Nome, @Field("Email") String Email, @Field("Senha") String Senha);

    @FormUrlEncoded
    @POST("api/Usuario/EfetuarLogin")
    public Call<ResponseUser> loginUser( @Field("Email") String Email, @Field("Senha") String Senha);
/*
    @FormUrlEncoded
    @POST("api/Usuario/ValidarUsuario")
    public Call<UserReponse> validUser(@Url String Url);
    */
    @FormUrlEncoded
    @POST("api/Usuario/AlterarSenha")
    public Call<ResponseUser> alterarSenha(@Field("Id") String Id, @Field("Nome") String Nome, @Field("Email") String Email, @Field("Senha") String Senha);

    /*
    @POST("api/Usuario/ValidarUsuario")
    Call<UserReponse> validUser(@Path(value = "fullUrl") String fullUrl);
    */

    @POST("api/Usuario/ValidarUsuario")
    public Call<UserReponse> validUser(@Query("Codigo") String Codigo);
}

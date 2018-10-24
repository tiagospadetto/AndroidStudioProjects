package br.com.smartirrigation.smartirrigation.services;

import java.util.List;

import br.com.smartirrigation.smartirrigation.model.CantResponse;
import br.com.smartirrigation.smartirrigation.model.EquipResponse;
import br.com.smartirrigation.smartirrigation.model.EquipsUser;
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

    @FormUrlEncoded
    @POST("api/Usuario/AlterarPerfil")
    public Call<ResponseUser> atualizarperfil(@Field("Id") String Id, @Field("Nome") String Nome, @Field("Email") String Email);

    @POST("api/Equipamento/ObterPeloUsuario")
    public Call<List<EquipResponse>> equipamentos_user(@Query("IdUsuario") String IdUsuario);

    @POST("api/Equipamento/AssociarUsuarioEquipamento")
    public Call<ResponseUser> equipamentos_user_add(@Query("IdUsuario") String IdUsuario, @Query("IdEquipamento") String IdEquipamento);

    @FormUrlEncoded
    @POST("api/Canteiro/AdicionarCanteiro")
    public Call<ResponseUser> addcanteiro(@Field("IdCanteiro") String IdCanteiro, @Field("IdEquipamento") String IdEquipamento, @Field("Nome") String Nome);

}

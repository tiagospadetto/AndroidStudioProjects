package br.com.smartirrigation.smartirrigation.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitUtil {

    private static Retrofit instance;



    public static Retrofit getInstance(){
        if(instance == null){
            createInstance();
        }
        return instance;
    }

    private static void createInstance(){

        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        instance = new Retrofit.Builder()
                .baseUrl("http://189.7.105.163")
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();
    }
}

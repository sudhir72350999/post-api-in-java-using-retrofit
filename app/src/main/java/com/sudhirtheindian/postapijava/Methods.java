package com.sudhirtheindian.postapijava;
import com.sudhirtheindian.postapijava.model.Model;
import com.sudhirtheindian.postapijava.model.TModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
public interface Methods {
    @FormUrlEncoded
    @POST("/api/users")
    Call<Model> getUserData(@Field("name")String name, @Field("job") String job);



    @FormUrlEncoded
    @POST("/api/V1.0/TDMS/CancelTWOrder")
    Call<TModel> getUserTModelData(
            @Header("SecurityKey") String securityKey,
//            @Field("requestId") String requestId,
//            @Field("requestDateTime") String requestDateTime,
//            @Field("orderNo") String orderNo,
            @Field("systemName") String systemName,
//            @Field("userID") String userID,
            @Field("userType") String userType
//            @Field("cancelOn") String cancelOn
    );

}

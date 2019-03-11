package apk.win.first.bankapl;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ModelApi {
    @GET("currency-cash.json")
    Call<Model> message();

    //@GET("json?input=Киев%20ул.%20Тарасовская,%2019&inputtype=textquery&fields=photos,formatted_address,name,rating,opening_hours,geometry&key=AIzaSyBtWKe-Lw4d7IyAD0Z5fJb6MC6v3o8jLSc")
    @POST("json?inputtype=textquery&fields=formatted_address,geometry&key=AIzaSyBjx2OfTQOVV6f51P-LhYqPtlMr17NxTBc")
    //Call <ModelTwo> getNameStreetToCoordinates();

     //Call <ModelTwo> getNameStreetToCoordinates(@Query("input") String name, @Query("input") String str);

     Call <ModelTwo> getNameStreetToCoordinates(@Query("input") String name);

    //Call<Model> idsInfo(@Query("section") String number);

}

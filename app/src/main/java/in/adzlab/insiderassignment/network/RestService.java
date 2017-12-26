package in.adzlab.insiderassignment.network;

import java.util.Map;

import in.adzlab.insiderassignment.network.ResponseModel.HomePage;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by adityagohad on 25/12/17.
 */

public interface RestService {
    @GET("/home")
    Call<HomePage> getData(@QueryMap Map<String, String> query);
}

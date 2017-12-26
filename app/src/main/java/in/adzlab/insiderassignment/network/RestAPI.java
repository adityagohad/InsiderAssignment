package in.adzlab.insiderassignment.network;

import in.adzlab.insiderassignment.Utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adityagohad on 25/12/17.
 */

public class RestAPI {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private static RestService restService;

    public static RestService getRestService() {
        restService = retrofit.create(RestService.class);
        return restService;
    }
}

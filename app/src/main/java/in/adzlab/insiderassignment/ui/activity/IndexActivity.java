package in.adzlab.insiderassignment.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import in.adzlab.insiderassignment.R;
import in.adzlab.insiderassignment.network.ResponseModel.HomePage;
import in.adzlab.insiderassignment.network.RestAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("norm", "1");
        queryParams.put("filterBy", "go-out");
        queryParams.put("city", "pune");
        RestAPI.getRestService().getData(queryParams).enqueue(new Callback<HomePage>() {
            @Override
            public void onResponse(@NonNull Call<HomePage> call, @NonNull Response<HomePage> response) {
                int count = 0;
                for (Map.Entry<String, List<String>> entry : response.body().getList().getGroupwiseList().entrySet()) {
                    count = count + entry.getValue().size();
                }

                Intent intent = new Intent(IndexActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("data", response.body());
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(@NonNull Call<HomePage> call, @NonNull Throwable t) {

            }
        });
    }
}

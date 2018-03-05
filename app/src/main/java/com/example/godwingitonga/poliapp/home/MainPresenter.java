package com.example.godwingitonga.poliapp.home;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.example.godwingitonga.poliapp.clients.AfricasTalkingGateway;
import com.example.godwingitonga.poliapp.data.model.RequestResponse;
import com.example.godwingitonga.poliapp.data.remote.ApiService;
import com.example.godwingitonga.poliapp.data.remote.ApiUtils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


public class MainPresenter {
    private Activity activity;
    private Location currentLocation;


    private ApiService mAPIService = ApiUtils.getApiService();

    public MainPresenter(MainView view, Activity activity) {

        this.activity = activity;
    }

    public String requestProviders (double latitude, double longitude, String type) {
        String result = "";
        mAPIService.fetchProvider(latitude, longitude, type).enqueue(new Callback<RequestResponse>() {
            @Override
            public void onResponse(@NonNull Call<RequestResponse> call, @NonNull Response<RequestResponse> response) {

                if(response.isSuccessful()) {
                    sendRequest(response.body().getPhoneNumber());
                }
            }

            @Override
            public void onFailure(@NonNull Call<RequestResponse> call, @NonNull Throwable t) {
            }
        });
        return result;
    }

    public void sendRequest(String phoneNumber) {
        String username = "mato";
        String apiKey   = "MyAPIKey";
        String message = "We are lumberjacks. We code all day and sleep all night";
        // Create a new instance of our awesome gateway class
        AfricasTalkingGateway gateway  = new AfricasTalkingGateway(username, apiKey);
        try {
            JSONArray results = gateway.sendMessage(phoneNumber, message);
            for( int i = 0; i < results.length(); ++i ) {
                JSONObject result = results.getJSONObject(i);
                System.out.print(result.getString("status") + ","); // status is either "Success" or "error message"
                System.out.print(result.getString("number") + ",");
                System.out.print(result.getString("messageId") + ",");
                System.out.println(result.getString("cost"));
            }
        } catch (Exception e) {
            System.out.println("Encountered an error while sending " + e.getMessage());
        }
    }
}

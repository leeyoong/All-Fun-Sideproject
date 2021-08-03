package com.example.test.Response;


import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public class ResponseJson {
    private String response_massage;


    public String getResponse_massage()
    {
        return response_massage;
    }

    public void setResponse_massage(String massage)
    {
        this.response_massage = response_massage;
    }

    @Override
    public String toString() {
        return response_massage;
    }
}

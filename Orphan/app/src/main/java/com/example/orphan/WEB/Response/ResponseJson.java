package com.example.orphan.WEB.Response;


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

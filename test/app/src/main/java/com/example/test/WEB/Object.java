package com.example.test.WEB;

import com.google.gson.JsonObject;

import java.util.ArrayList;

public class Object {
    Object(){

    }
    Object(String name, String pass){
        this.name = name;
        this.pass = pass;
    }
    private String name;

    private String pass;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getPass ()
    {
        return pass;
    }

    public void setPass (String pass)
    {
        this.pass = pass;
    }

    public JsonObject toJson(){

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "lee young");
        jsonObject.addProperty("password", "07230723");

        return jsonObject;
    }


    public JsonObject toJson(ArrayList<String> property,ArrayList<String> value){
        JsonObject jsonObject = new JsonObject();


        if(property.size() == 0){
            jsonObject.addProperty("error", "size = 0");
            return jsonObject;
        }

        if(property.size() != value.size()){
            jsonObject.addProperty("error", "not equal both size");
            return jsonObject;
        }
        else{
            for(int i = 0; i < property.size(); i++ ){
                jsonObject.addProperty(property.get(i),value.get(i));
            }
            return jsonObject;


        }






    }
    //public com.google.gson.JsonObject getJsonString(Object jsonObject){}
    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", pass = "+pass+"]";
    }
}

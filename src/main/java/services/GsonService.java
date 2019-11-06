package services;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class GsonService {

    private static Gson gson = new Gson();

    public static Object fromJson(String jsonString, Type type) {
        return gson.fromJson(jsonString, type);
    }



}

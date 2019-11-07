package services;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Service for converting JSON to a model.
 *
 * @author TimvHal
 * @version 06-11-2019
 */
public class GsonService {

    private static Gson gson = new Gson();

    public static Object fromJson(String jsonString, Type type) {
        return gson.fromJson(jsonString, type);
    }

    public static String toJson(Object o) {
        return gson.toJson(o);
    }



}

package utils;

import com.google.gson.Gson;

public enum GsonSingleton {

    INSTANCE;

    private final Gson gson;

    GsonSingleton() {
        gson = new Gson();
    }

    public Gson getGson() {
        return gson;
    }
}

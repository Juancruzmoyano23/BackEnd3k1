package main.java.ar.edu.utnfrc.backend.menu;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private static final ApplicationContext instance = new ApplicationContext();
    private final Map<String, Object> context = new HashMap<>();
    private final Map<Class<?>, Object> services = new HashMap<>();

    private ApplicationContext() {}

    public static ApplicationContext getInstance() {
        return instance;
    }

    public void put(String key, Object value) {
        context.put(key, value);
    }

    public Object get(String key) {
        return context.get(key);
    }

    public <T> void registerService(Class<T> clazz, T service) {
        services.put(clazz, service);
    }

    public <T> T getService(Class<T> clazz) {
        return clazz.cast(services.get(clazz));
    }
}
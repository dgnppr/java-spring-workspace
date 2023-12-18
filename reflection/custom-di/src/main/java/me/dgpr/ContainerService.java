package me.dgpr;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    public static <T> T getObject(Class<T> classType) {
        T instance = createInstance(classType);
        inject(classType, instance);
        return instance;
    }

    private static <T> void inject(Class<T> classType, T instance) {
        Arrays.stream(classType.getDeclaredFields())
                .forEach(f -> {
                    if (f.getAnnotation(Inject.class) != null) {
                        Object field = createInstance(f.getType());
                        f.setAccessible(true);
                        try {
                            f.set(instance, field);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

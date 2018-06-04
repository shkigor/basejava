package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class resumeClass = Resume.class;
        Field field = resumeClass.getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        Resume resume = new Resume();
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");
        System.out.println(resume);

        // invoke resume.toString via reflection
        Method methodToString = resumeClass.getMethod("toString", null);
        System.out.println(methodToString.invoke(resume));
    }
}

package ru.javanoo6.webapp;

import ru.javanoo6.webapp.model.SectionType;

public class TestSingleton {

    private static TestSingleton instance;

    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        getInstance().getInstance().toString();
        Sinleton instance = Sinleton.valueOf("INSTANCE");
        System.out.println(instance.ordinal());
        //name = toString
        for(SectionType type: SectionType.values()){
            System.out.println(type.getTitle());
        }
    }
    public enum Sinleton{
        INSTANCE
    }
}

package ru.javanoo6.webapp.exeptions;

public class StorageExeption extends RuntimeException{
    private final String uuid;

    public StorageExeption(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}

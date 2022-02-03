package ru.javanoo6.webapp.exeptions;

public class DoesntExistStorageExeption extends StorageExeption{
    public DoesntExistStorageExeption(String uuid) {
        super("resume "+uuid+"doesnt exist",uuid);
    }
}

package ru.javanoo6.webapp.exeptions;

public class ExistStorageExeption extends StorageExeption{
    public ExistStorageExeption(String uuid) {
        super("resume "+uuid+"already exist",uuid);

    }

}

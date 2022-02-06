package ru.javanoo6.webapp.exeptions;

public class DoesntExistStorageException extends StorageException {
    public DoesntExistStorageException(String uuid) {
        super("resume "+uuid+"doesnt exist",uuid);
    }
}

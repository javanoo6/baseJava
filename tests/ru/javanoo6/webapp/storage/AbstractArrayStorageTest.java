package ru.javanoo6.webapp.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javanoo6.webapp.exeptions.StorageException;
import ru.javanoo6.webapp.model.Resume;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest{
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
     public void saveOverflow() {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Name" + i));
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume("Overflow"));
    }
}
/*
    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            while (storage.size() < AbstractArrayStorage.STORAGE_LIMIT) {
                storage.save(new Resume("Test Test"));
            }
        } catch (StorageException e) {
            Assert.fail("Unexpected storage overflow");
        }
        storage.save(new Resume("Test Test"));
    }
 */
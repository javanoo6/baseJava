package ru.javanoo6.webapp.storage;

import ru.javanoo6.webapp.storage.serializer.ObjectStreamSerializer;

public class ObjectFileStorageTest extends AbstractStorageTest {

    public ObjectFileStorageTest() {
            super(new FileStorage(STORAGE_DIR, new ObjectStreamSerializer()));
        }
    }

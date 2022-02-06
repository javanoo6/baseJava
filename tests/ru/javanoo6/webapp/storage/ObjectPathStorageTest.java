package ru.javanoo6.webapp.storage;

import ru.javanoo6.webapp.storage.serializer.ObjectStreamSerializer;

public class ObjectPathStorageTest extends AbstractStorageTest {

    public ObjectPathStorageTest() {
            super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializer()));
        }
    }


package ru.javanoo6.webapp.storage;

import ru.javanoo6.webapp.exeptions.DoesntExistStorageExeption;
import ru.javanoo6.webapp.exeptions.ExistStorageExeption;
import ru.javanoo6.webapp.exeptions.StorageExeption;
import ru.javanoo6.webapp.model.Resume;

import java.util.Arrays;
//import

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size=0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage,0,size,null);
        size=0;
    }
    public void update (Resume r) {
        int index = getIndex(r.getUuid());
        if(index==-1){
           throw new DoesntExistStorageExeption(r.getUuid()+" does not exist");
        }else
            storage[index]=r;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage,0,size);
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if(index>=0){
            throw new ExistStorageExeption(r.getUuid()+" exists");
        }else if(size==STORAGE_LIMIT){
            throw new StorageExeption("storage is filled",r.getUuid());
        }else{
            insertElement(r,index);
            size++;
        }

    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if(index<0){
            throw new DoesntExistStorageExeption(uuid+" does not exist");
        }else{
            fillDeletedElement(index);
            storage[size-1]=null;
            size--;
        }

    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if(index<0){
            throw new DoesntExistStorageExeption(uuid+" does not exist");
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);
    protected abstract void fillDeletedElement(int index);
    protected abstract void insertElement(Resume r, int index);
}

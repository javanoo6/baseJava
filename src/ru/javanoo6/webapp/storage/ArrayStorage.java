package ru.javanoo6.webapp.storage;

import ru.javanoo6.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage,0,size,null);
        size=0;
    }
   public void update (Resume r) {
        int index = getIndex(r.getUuid());
        if(index==-1){
            System.out.println("resume "+r.getUuid()+" does not exist");
        }else
            storage[index]=r;
    }

    public void save(Resume r) {
        if(getIndex(r.getUuid())!=1){
            System.out.println("resume "+r.getUuid()+" already exists");
        }else if(size==STORAGE_LIMIT){
            System.out.println("storage is filled");
        }else{
            storage[size]=r;
            size++;
        }

    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if(index==-1){
            System.out.println("resume "+uuid+" does not exist");
        }else{
            storage[index]=storage[size-1];
            storage[size-1]=null;
            size--;
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
         return Arrays.copyOfRange(storage,0,size);
    }


    protected int getIndex(String uuid){
        for (int i=0;i<size;i++){
            if(uuid.equals(storage[i].getUuid())){
                return i;
            }
        }return -1;
    }
}

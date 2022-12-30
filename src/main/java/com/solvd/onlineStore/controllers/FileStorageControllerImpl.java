package com.solvd.onlineStore.controllers;

import java.io.File;

public abstract class FileStorageControllerImpl<E, K> implements IStorageController<E, K>{
    private File file;

    public FileStorageControllerImpl(File file){
        this.file = file;
    }

}

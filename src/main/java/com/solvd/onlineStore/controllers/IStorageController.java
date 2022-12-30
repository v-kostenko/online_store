package com.solvd.onlineStore.controllers;

import java.util.List;

public interface IStorageController<E, K> {

    boolean create(E e);

    boolean delete(E e);

    boolean update(E e);

    E find(K k);

    List<E> findAll();


}

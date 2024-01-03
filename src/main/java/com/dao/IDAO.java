package com.dao;

import java.util.List;

public interface IDAO<T> {

    void saveOrUpdate(T t);
    void delete(T t);
    T getById(Integer id);
    List<T> getAll();
}

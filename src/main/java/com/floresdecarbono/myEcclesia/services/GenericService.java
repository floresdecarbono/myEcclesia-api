package com.floresdecarbono.myEcclesia.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenericService<T, D, I> {

     List<T> findAll();
     T findOne(I id);
     T insert(D model);
     T update(I id, D model);
     void delete(I id);
     void updateData(D source, T destination);

}

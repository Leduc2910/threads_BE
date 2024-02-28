package com.codegym.service.intf;

import java.util.List;
import java.util.Optional;

public interface IService<E> {
    void save(E e);
    void delete(Long id);
    List<E> findAll();
    Optional<E> findEById(Long id);
}

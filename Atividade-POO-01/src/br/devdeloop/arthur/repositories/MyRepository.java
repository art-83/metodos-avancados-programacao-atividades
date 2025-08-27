package br.devdeloop.arthur.repositories;

import br.devdeloop.arthur.models.enums.UniversityClass;

import java.util.Map;

public interface MyRepository <T> {
    T save(T user);
    T findById(String id);
    Map<String, T> findAll();
    Map<String, T> findByUniversityClass(UniversityClass universityClass);
    T removeById(String id);
}
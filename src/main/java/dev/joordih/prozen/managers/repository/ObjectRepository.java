package dev.joordih.prozen.managers.repository;

import dev.joordih.prozen.managers.models.Model;

public interface ObjectRepository<T extends Model> {
    T find(String id);
    void remove(String id);
    void save(T model);
}

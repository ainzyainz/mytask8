package DAO;

public interface DAO<T> {
    T save(T obj);
    boolean delete(int id);
    T update(T obj);
    T read(int id);
}

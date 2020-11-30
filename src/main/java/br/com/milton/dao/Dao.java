package br.com.milton.dao;
import java.io.Serializable;
import java.util.List;
 
public interface Dao<T, I extends Serializable>{
    public T save(T entity);
    public void delete(Class<T> classe, I pk);
    public T getById(Class<T> classe, I pk);
    public List<T> getAll(Class<T> classe);
}
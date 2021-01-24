package me.inver;

public interface Repository<T> {
    public T[] findAll();
    public T findOneById(int id);
    public void removeOneById(int id);
    public void saveOne(T model);
    public boolean exists(int id);
}

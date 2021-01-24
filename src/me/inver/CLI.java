package me.inver;

public interface CLI<T> {
    public void execute(String[] commandFragments);
    public void printHelp();
    public void list();
    public void printOne(T object, boolean isListItem);
    public void printOneById(int id);
    public void create(T object);
    public void remove(int id);
    public void printNotFound();
}

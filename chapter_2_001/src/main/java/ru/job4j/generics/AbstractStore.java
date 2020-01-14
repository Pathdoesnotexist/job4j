package ru.job4j.generics;

import java.util.Iterator;

public class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> simpleArray;

    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        this.simpleArray.add(model);

    }
//дописать булин, разобраться куда он нужен почему не воид///////////////////////////////////
    @Override
    public boolean replace(String id, T model) {
        this.simpleArray.set(this.getIndex(id), model);
        return false;
    }

    @Override
    public boolean delete(String id) {
        this.simpleArray.remove(this.getIndex(id));
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")

    public T findById(String id) {
        return (T) this.simpleArray.get(this.getIndex(id));
    }

    private int getIndex(String id) {
        int index = -1;
        Iterator<T> iterator = this.simpleArray.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                break;
            }
            index++;
        }
        return index;
        //если ничего не находит то выбрасывает ArrayIndexOutOfBoundsException тк индекс передаваемый отсюда -1, обработать это
    }

    public static void main(String[] args) {
        RoleStore store = new RoleStore(5);
        store.add(new Role("23a"));
        store.add(new Role("35a"));
        store.add(new Role("67b"));
        store.add(new Role("23t"));
        store.add(new Role("03c"));


        System.out.println(store.findById("23a").getId());
        System.out.println(store.findById("03c").getId());
        store.replace("23a", new Role("88u"));
        System.out.println(store.findById("23a").getId());
//        store.delete("03c");
        System.out.println(store.findById("03c").getId());
        System.out.println(store.findById("23b").getId());



    }
}

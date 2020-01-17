package ru.job4j.generics;

import java.util.Iterator;

public class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> simpleArray;

    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray<>(size);
    }

    /**
     * добавление элемента в массив в свободную ячейку, если она есть
     * @param model добавляемый элемент
     */
    @Override
    public void add(T model) {
            this.simpleArray.add(model);
    }
    /**
     * замена элемента новым элементом
     * @param id идентификатор заменяемого элемента
     * @param model вставляемый элемент
     * @return результат замены
     */
    @Override
    public boolean replace(String id, T model) {
        int index = this.getIndex(id);
        boolean result = false;
        if (index != -1) {
            this.simpleArray.set(index, model);
            result = true;
        }
        return result;
    }
    /**
     * удаление элемента по идентификаотру
     * @param id идентификатор элемента
     * @return результат удаления
     */
    @Override
    public boolean delete(String id) {
        int index = this.getIndex(id);
        boolean result = false;
        if (index != -1) {
            this.simpleArray.remove(index);
            result = true;
        }
        return result;
    }
    /**
     * получение элемента по идентификаотру
     * @param id идентификатор элемента
     * @return элемент массива
     */
    @Override
    public T findById(String id) {
        int index = this.getIndex(id);
        return (index == -1) ? null : this.simpleArray.get(index);
    }
    /**
     * поиск индекса элемента в массиве по идентификатору
     * @param id идентификатор элемента
     * @return индекс элемента или -1
     */
    private int getIndex(String id) {
        int index = 0;
        boolean existInRange = false;
        Iterator<T> iterator = this.simpleArray.iterator();
        while (iterator.hasNext()) {
            T nextElement = iterator.next();
            if (nextElement != null && nextElement.getId().equals(id)) {
                existInRange = true;
                break;
            }
            index++;
        }
        return existInRange ? index : -1;
    }
}

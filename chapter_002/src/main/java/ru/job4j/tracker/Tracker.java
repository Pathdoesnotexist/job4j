package ru.job4j.tracker;
import java.util.*;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    public final Item[] items = new Item[10]; //поменять на приват когда закончишь

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items[this.position++] = item;
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    public String generateId() {                        //поменять на приват когда закончишь
        Random rm = new Random();
        return String.valueOf(Math.abs(rm.nextLong() + System.currentTimeMillis()));
    }
    /**
     * Метод возвращает копию массива this.items без null элементов
     * @param items массив this.items
     * @return копию this.items без null
     */
    public Item[] findAll(Item[] items) {
        int index = 0;
        for (Item item : items) {
            if (item != null) {
                index++;
            } else {
                break;
            }
        }
        Item[] listOfAll = new Item[index];
        System.arraycopy(this.items, 0, listOfAll, 0, index);
        return listOfAll;
    }

    /**
     * получение заявки по id - проверяет в цикле все элементы массива this.items,
     * cравнивая id с аргументом String id и возвращает найденный Item.
     * Если Item не найден - возвращает null.
     * @param id null
     * @return null
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item  : this.items) {
            if (item.getId().equals(id)) {
                System.out.println("Найден!  " + item.getName() + " ID Key: " + item.getId());  // удалить эти строки
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * должен заменить ячейку в массиве this.items. Для этого необходимо найти ячейку в массиве по id
     * Метод должен вернуть boolean результат - удалось ли провести операцию.
     * @param id null
     * @param item null
     * @return null
     */
    public boolean replace(String id, Item item) {
        return false;
    }

    /**
     * должен удалить ячейку в массиве this.items. Для этого необходимо найти ячейку в массиве по id.
     * Далее сместить все значения справа от удаляемого элемента - на одну ячейку влево с помощью System.arrayCopy().
     * Метод должен вернуть boolean результат - удалось ли провести операцию.
     * @param id null
     * @return null
     */
    public boolean delete(String id) {
        Item toDelete = findById(id);
        return false;
    }

    /**
     * получение списка по имени - проверяет в цикле все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item)
     * с аргументом метода String key. Элементы, у которых совпадает name,
     * копирует в результирующий массив и возвращает его;
     * @param key null
     * @return null
     */
    public Item[] findByName(String key) {
        int position = 0;
        Item[] nameList = new Item[100];
        for (Item item : this.items) {
            if (item.getName().equals(key)) {
                nameList[position++] = item;
            }
        }
        return nameList;
    }
}

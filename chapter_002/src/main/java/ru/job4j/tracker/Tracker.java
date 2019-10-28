package ru.job4j.tracker;
import java.util.*;

public class Tracker {
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Длина списка.
     */
    private int length = 100;
    /**
     * Массив для хранение заявок.
     */
    public final Item[] items = new Item[length]; //поменять на приват когда закончишь
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
     * @return копию this.items без null-ячеек
     */
    public Item[] findAll(Item[] items) {
        return Arrays.copyOf(items, position);
    }
    /**
     * получение заявки по id
     * @param id завки для поиска
     * @return заявку или null
     */
    public Item findById(String id) {
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                return this.items[i];
            }
        }
        return null;
    }
    /**
     * заменяет ячейку в массиве this.items, если она существует
     * @param id идентификатор элемента, который надо заменить
     * @param item элемент который всятавляем вместо заменяемого
     * @return результат операции
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                result = true;
                break;
            }
        }
        return result;
//        Item targetItem = findById(id);
//        if (targetItem != null) {
//            int index = Arrays.asList(this.items).indexOf(targetItem);
//            this.items[index] = item;
//            return true;
//        } else {
//            return false;
//        }
    }
    /**
     * удаляет ячейку в массиве this.items, если она существует
     * @param id идентификатор элемента, который надо удалить
     * @return результат операции
     */
    public boolean delete(String id) {
        Item targetItem = findById(id);
        if (targetItem != null) {
            int index = Arrays.asList(this.items).indexOf(targetItem);
            System.arraycopy(this.items, index + 1, this.items, index, this.items.length - 1 - index);
            this.items[this.items.length - 1] = null;
            position--;
            return true;
        } else {
            return false;
        }
    }
    /**
     * получение списка по имени в результирующий массив
     * @param key имя элемента для сортировки
     * @return массив, содержащий все элементы с заданным именем
     */
    public Item[] findByName(String key) {
        int pos = 0;
        Item[] nameList = new Item[length];
        for (Item item : findAll(this.items)) {
            if (item.getName().equals(key)) {
                nameList[pos++] = item;
            }
        }
        return Arrays.copyOf(nameList, pos);
    }
}

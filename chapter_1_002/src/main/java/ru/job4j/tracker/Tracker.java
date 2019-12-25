package ru.job4j.tracker;
import java.util.*;

public class Tracker {
    /**
     * Список для хранение заявок.
     */
    public List<Item> items = new ArrayList<>();
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    public String generateId() {
        Random rm = new Random();
        return String.valueOf(Math.abs(rm.nextLong() + System.currentTimeMillis()));
    }
    /**
     * Метод возвращает копию массива this.items без null элементов
     * @param items массив this.items
     * @return копию this.items без null-ячеек
     */
    public List<Item> findAll(List<Item> items) {
        return items;
    }
    /**
     * получение заявки по id
     * @param id завки для поиска
     * @return заявку или null
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    /**
     * заменяет ячейку в массиве this.items, если она существует
     * @param id идентификатор элемента, который надо заменить
     * @param item элемент который всятавляем вместо заменяемого
     * @return результат операции
     */
    public boolean rename(String id, Item item) {
        boolean result = false;
        for (Item value : items) {
            if (value.getId().equals(id)) {
                item.setId(value.getId());
                items.set(items.indexOf(value), item);
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * удаляет ячейку в массиве this.items, если она существует
     * @param id идентификатор элемента, который надо удалить
     * @return результат операции
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * получение списка по имени в результирующий массив
     * @param key имя элемента для сортировки
     * @return массив, содержащий все элементы с заданным именем
     */
    public List<Item> findByName(String key) {
        int pos = 0;
        List<Item> nameList = new ArrayList<>();
        for (Item item : findAll(this.items)) {
            if (item.getName().equals(key)) {
                nameList.add(item);
            }
        }
        return nameList;
    }
}

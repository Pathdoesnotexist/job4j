package ru.job4j.bank;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Bank {
    /**
     * Карта-список для будущих клиентов банка, ключ:Клиент - значение:Список счетов
     */
    private TreeMap<User, ArrayList<Account>> treeMap = new TreeMap<>();
    /**
     * Выводит список всех существующих клиентов
     * @return список клиентов банка
     */
    public String toString() {
        return "Bank accounts: " + treeMap;
    }
    /**
     * Добавление нового клиента банка в список
     * @param user - клиент, которого необходимо добавить
     */
    public void addUser(User user) {
        this.treeMap.putIfAbsent(user, new ArrayList<>());
    }
    /**
     * Удаление клиента банка из списка
     * @param user - клиент, которого необходимо удалить
     */
    public void deleteUser(User user) {
        this.treeMap.remove(user);
    }
    /**
     * Поиск клиента в списке клиентов по номеру паспорта и добавление ему нового счета
     * @param passport - номер паспорта пользователя
     * @param account - новый счет, который необходимо добавить пользователю
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, ArrayList<Account>> entry : this.treeMap.entrySet()) {
            User user = entry.getKey();
            ArrayList<Account> accountList = entry.getValue();
            if (user.getPassport().equals(passport)) {
                accountList.add(account);
                break;
            }
        }
    }
    /**
     * Поиск клиента в списке клиентов по номеру паспорта и удаление у него существующего счета
     * @param passport - номер паспорта пользователя
     * @param account - новый счет, который необходимо добавить пользователю
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, ArrayList<Account>> entry : this.treeMap.entrySet()) {
            User user = entry.getKey();
            ArrayList<Account> accountList = entry.getValue();
            if (user.getPassport().equals(passport)) {
                accountList.remove(account);
                break;
            }
        }
    }
    /**
     * Проверка, имеется ли счет у пользователя
     * @param user - пользователь, которого проверяем
     * @param account - счет который ищем
     * @return результат поиска
     */
    private boolean accountExist(User user, Account account) {
        return this.treeMap.get(user).contains(account);
    }
    /**
     * Перевод условных единис с одного счета на другой
     * @param userFrom пользователь, со счета которого переводим условные единицы
     * @param accountFrom  счет с которого переводим условные единицы
     * @param userTo пользователь, на счет которого переводим условные единицы
     * @param accountTo счет на который переводим условные единицы
     * @param amount количество условных единиц для перевода
     * @return результат операции
     */
    public boolean transfer(User userFrom, Account accountFrom,
                            User userTo, Account accountTo, double amount) {
        boolean result = false;
        if (accountExist(userFrom, accountFrom) && accountExist(userTo,accountTo) && amount > 0 && accountFrom.getValue() > amount) {
             accountFrom.setValue(accountFrom.getValue() - amount);
             accountTo.setValue(accountTo.getValue() + amount);
             result = true;
        }
        return result;
    }
}
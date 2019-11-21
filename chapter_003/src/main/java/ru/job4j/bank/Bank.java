package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
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
        this.treeMap.put(user, new ArrayList<>());
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
            if (user.getPassport() == Integer.parseInt(passport)) {
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
            if (user.getPassport() == Integer.parseInt(passport)) {
                accountList.remove(account);
                break;
            }
        }
    }
    /**
     * Получение списка счетов по имени пользователя
     * @param user - пользователь, список счетов которого необходимо получить
     * @return список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return this.treeMap.get(user);
    }
    /**
     * Получение конкретного счета пользователя из списка счетов
     * @param user - пользователь, чей счет ищем
     * @param account - счет, номер которого ищем
     * @return счет
     */
    private Account getActualAccount(User user, Account account) { //получаем порядковый номер счета пользователя
        ArrayList<Account> list = this.treeMap.get(user);
        return list.get(list.indexOf(account));
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
        if (this.treeMap.get(userFrom).contains(accountFrom) && this.treeMap.get(userTo).contains(accountTo)) {
            result = getActualAccount(userFrom, accountFrom).makeTransfer(getActualAccount(userTo, accountTo), amount);
        }
        return result;
    }
}
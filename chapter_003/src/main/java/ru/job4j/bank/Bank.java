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
     * Поиск пользователя по номеру паспорта или null
     * @param passport номер паспорта
     * @return пользователя с соотвествующим паспортом
     */
    private User userByPassport(String passport) {
        User result = null;
        for (Map.Entry<User, ArrayList<Account>> entry : this.treeMap.entrySet()) {
            User user = entry.getKey();
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }
    /**
     * Возвращает счет по реквизитам, если он есть у пользователя или null
     * @param user пользователь, чей список счетов проверяем
     * @param requisites реквизиты счета
     * @return пользователя или null
     */
    private Account accountByRequisites(User user, String requisites) {
        Account result = null;
        if (user != null) {
            ArrayList<Account> accountList = this.treeMap.get(user);
            for (Account account : accountList) {
                if (account.getRequisites().equals(requisites)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
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
    public boolean addAccountToUser(String passport, Account account) {
        boolean result = false;
        if (userByPassport(passport) != null) {
            this.treeMap.get(userByPassport(passport)).add(account);
            result = true;
        }
        return result;
    }
    /**
     * Поиск клиента в списке клиентов по номеру паспорта и удаление у него существующего счета
     * @param passport - номер паспорта пользователя
     * @param account - новый счет, который необходимо добавить пользователю
     */
    public boolean deleteAccountFromUser(String passport, Account account) {
        boolean result = false;
        if (userByPassport(passport) != null && this.treeMap.get(userByPassport(passport)).contains(account)) {
            this.treeMap.get(userByPassport(passport)).remove(account);
            result = true;
        }
        return result;
    }
    /**
     * Перевод условных единиц между счетами пользователей
     * @param srcPassport номер паспорта пользователя-отправителя
     * @param srcRequisite счет отправителя
     * @param destPassport номер паспорта пользователя-получателя
     * @param dstRequisite счет получателя
     * @param amount сумма для перевода
     * @return результат операции
     */
    public boolean transfer(String srcPassport, String srcRequisite,
                            String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        User userFrom = userByPassport(srcPassport);
        User userTo = userByPassport(destPassport);
        Account accountFrom = accountByRequisites(userFrom, srcRequisite);
        Account accountTo = accountByRequisites(userTo, dstRequisite);
        if (accountFrom != null && accountTo != null && amount > 0 && accountFrom.getValue() > amount) {
             accountFrom.setValue(accountFrom.getValue() - amount);
             accountTo.setValue(accountTo.getValue() + amount);
             result = true;
        }
        return result;
    }
}
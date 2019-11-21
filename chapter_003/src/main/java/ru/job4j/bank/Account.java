package ru.job4j.bank;

public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return this.value;
    }
    public String getRequisites() {
        return this.requisites;
    }
    /**
     * Перевод денег с текущего счета на целевой
     * @param destination - счет, на который выполняется перевод
     * @param amount - сумма перевода
     * @return - результат выполнения операции
     */
    boolean makeTransfer(Account destination, double amount) {
        boolean result = false;
        if (amount > 0 && amount < this.value && destination != null) {
            result = true;
            this.value -= amount;
            destination.value += amount;
        }
        return result;
    }

    public String toString() {
        return "Account{" + "value=" + value + ", requisites='" + requisites + "\\" + "}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return this.requisites.equals(account.requisites);
    }

    public int hashCode() {
        return this.requisites.hashCode();
    }
}
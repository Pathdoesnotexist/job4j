package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import static org.hamcrest.core.Is.is;

public class BankTest {
    private Bank alphaBank = new Bank();
    private User andrey = new User("Andrey", "4568");
    private User pavel = new User("Pavel", "2389");
    private User eugene = new User("Eugene", "4097");
    private Account andreyMain = new Account(1000, "Main");
    private Account pavelMain = new Account(500, "Main");
    private Account pavelCredit = new Account(450, "Credit");
    private Account eugeneMain = new Account(2500, "Main");

    @Test
    public void addUsers() {
        alphaBank.addUser(pavel);
        alphaBank.addUser(eugene);
        alphaBank.addUser(andrey);

        TreeMap<User, ArrayList<Account>> example = new TreeMap<>();
        example.put(andrey, new ArrayList<>());
        example.put(eugene, new ArrayList<>());
        example.put(pavel, new ArrayList<>());
        String expected = "Bank accounts: " + example;

        Assert.assertThat(alphaBank.toString(), is(expected));
    }

    @Test
    public void deleteUsers() {
        alphaBank.addUser(pavel);
        alphaBank.addUser(eugene);
        alphaBank.addUser(andrey);
        alphaBank.deleteUser(pavel);
        alphaBank.deleteUser(eugene);

        TreeMap<User, ArrayList<Account>> example = new TreeMap<>();
        example.put(andrey, new ArrayList<>());
        String expected = "Bank accounts: " + example;

        Assert.assertThat(alphaBank.toString(), is(expected));
    }

    @Test
    public void addAccountsSuccess() {
        alphaBank.addUser(pavel);
        boolean result = alphaBank.addAccountToUser("2389", pavelMain);
        Assert.assertTrue(result);
    }

    @Test
    public void addAccountsFail() {
        alphaBank.addUser(pavel);
        boolean result = alphaBank.addAccountToUser("2000", pavelMain);
        Assert.assertFalse(result);
    }

    @Test
    public void deleteAccountSuccess() {
        alphaBank.addUser(pavel);
        alphaBank.addAccountToUser("2389", pavelMain);
        boolean result = alphaBank.deleteAccountFromUser("2389", pavelMain);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteAccountFailWrongAccount() {
        alphaBank.addUser(pavel);
        alphaBank.addAccountToUser("2389", pavelMain);
        boolean result = alphaBank.deleteAccountFromUser("2389", pavelCredit);
        Assert.assertFalse(result);
    }

    @Test
    public void deleteAccountFailWrongUser() {
        alphaBank.addUser(pavel);
        alphaBank.addAccountToUser("2389", pavelMain);
        boolean result = alphaBank.deleteAccountFromUser("2388", pavelMain);
        Assert.assertFalse(result);
    }

    @Test
    public void transferTrue() {
        alphaBank.addUser(eugene);
        alphaBank.addUser(andrey);
        alphaBank.addAccountToUser(andrey.getPassport(), andreyMain);
        alphaBank.addAccountToUser(eugene.getPassport(), eugeneMain);
        boolean result = alphaBank.transfer("4097", "Main", "4568", "Main", 1200);
        Assert.assertTrue(result);
    }

    @Test
    public void transferFalseByAmount() {
        alphaBank.addUser(eugene);
        alphaBank.addUser(andrey);
        alphaBank.addAccountToUser(andrey.getPassport(), andreyMain);
        alphaBank.addAccountToUser(eugene.getPassport(), eugeneMain);
        boolean result = alphaBank.transfer("4097", "Main", "4568", "Main", 12000);
        Assert.assertFalse(result);
    }

    @Test
    public void transferFalseUserNotExist() {
        alphaBank.addUser(eugene);
        alphaBank.addUser(andrey);
        alphaBank.addAccountToUser(andrey.getPassport(), andreyMain);
        alphaBank.addAccountToUser(eugene.getPassport(), eugeneMain);
        boolean result = alphaBank.transfer("4097", "Main", "4000", "Main", 12000);
        Assert.assertFalse(result);
    }

    @Test
    public void transferFalseAccountNotExist() {
        alphaBank.addUser(eugene);
        alphaBank.addUser(andrey);
        alphaBank.addAccountToUser(andrey.getPassport(), andreyMain);
        alphaBank.addAccountToUser(eugene.getPassport(), eugeneMain);
        boolean result = alphaBank.transfer("4097", "Main", "4568", "Man", 1);
        Assert.assertFalse(result);
    }
}

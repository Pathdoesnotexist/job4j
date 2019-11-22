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
    public void addAccounts() {

        alphaBank.addUser(pavel);
        alphaBank.addAccountToUser(pavel.getPassport(), pavelMain);
        alphaBank.addAccountToUser(pavel.getPassport(), pavelCredit);

        TreeMap<User, ArrayList<Account>> example = new TreeMap<>();
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(pavelMain);
        accounts.add(pavelCredit);
        example.put(pavel, accounts);
        String expected = "Bank accounts: " + example;

        Assert.assertThat(alphaBank.toString(), is(expected));
    }

    @Test
    public void deleteAccounts() {

        alphaBank.addUser(pavel);
        alphaBank.addAccountToUser(pavel.getPassport(), pavelMain);
        alphaBank.addAccountToUser(pavel.getPassport(), pavelCredit);
        alphaBank.deleteAccountFromUser(pavel.getPassport(), pavelMain);

        TreeMap<User, ArrayList<Account>> example = new TreeMap<>();
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(pavelCredit);
        example.put(pavel, accounts);
        String expected = "Bank accounts: " + example;

        Assert.assertThat(alphaBank.toString(), is(expected));
    }

    @Test
    public void transferTrue() {
        alphaBank.addUser(eugene);
        alphaBank.addUser(andrey);
        alphaBank.addAccountToUser(andrey.getPassport(), andreyMain);
        alphaBank.addAccountToUser(eugene.getPassport(), eugeneMain);
        boolean result = alphaBank.transfer(eugene, eugeneMain, andrey, andreyMain, 1200);
        Assert.assertTrue(result);
    }

    @Test
    public void transferFalse() {
        alphaBank.addUser(eugene);
        alphaBank.addUser(andrey);
        alphaBank.addAccountToUser(andrey.getPassport(), andreyMain);
        alphaBank.addAccountToUser(eugene.getPassport(), eugeneMain);
        boolean result = alphaBank.transfer(eugene, eugeneMain, andrey, andreyMain, 12000);
        Assert.assertFalse(result);
    }
}

package me.inver;

import java.math.BigDecimal;

public class Account implements Model{
    private int owner;
    private AccountType type;
    private BigDecimal balance;
    private final int id;
    private static int idCounter = 1;

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    @Override
    public int getId() {
        return id;
    }

    public Account(int owner, AccountType accountType, String balance) {
        this.id = Account.idCounter++;
        this.balance = new BigDecimal(balance);
        this.type = accountType;
        this.owner = owner;
    }
}

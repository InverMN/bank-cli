package me.inver;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AccountRepository implements Repository<Account>{
    private ArrayList<Account> accounts = new ArrayList();

    @Override
    public Account[] findAll() {
        Account[] accountsArray = new Account[accounts.size()];
        for (int i = 0; i < accounts.size(); i++)
            accountsArray[i] = accounts.get(i);
        return accountsArray;
    }

    @Override
    public Account findOneById(int id) {
        return accounts.stream().filter(singleAccount -> singleAccount.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void removeOneById(int id) {
        accounts = (ArrayList<Account>) accounts
                .stream()
                .filter(singleAccount -> singleAccount.getId() != id)
                .collect(Collectors.toList());
    }

    @Override
    public void saveOne(Account account) {
        accounts.add(account);
    }

    @Override
    public boolean exists(int id) {
        return findOneById(id) != null;
    }
}

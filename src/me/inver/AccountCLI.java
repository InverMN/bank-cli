package me.inver;

import java.math.BigDecimal;

public class AccountCLI implements CLI<Account> {
    private AccountRepository accountRepository = new AccountRepository();

    @Override
    public void execute(String[] commandFragments) {
        switch (commandFragments[1]) {
            case "list":
                list();
                break;
            case "get":
                printOneById(Integer.parseInt(commandFragments[2]));
                break;
            case "create":
                create(new Account(Integer.parseInt(commandFragments[2]), Main.defaultAccountType, commandFragments[3]));
                break;
            case "remove":
                remove(Integer.parseInt(commandFragments[2]));
                break;
            case "set":
                set(commandFragments);
                break;
            case "help":
                printHelp();
                break;
            default:
                printNotFound();
        }
    }

    public void printNotFound() {
        System.out.println("Subcommand not found. See \"account help\"");
    }

    public void printHelp() {
        System.out.println("NOT IMPLEMENTED");
    }

    public void list() {
        Account[] allAccounts = accountRepository.findAll();
        System.out.println("accounts:");
        for(Account account : allAccounts)
            printOne(account, true);
    }

    public void printOneById(int id) {
        Account account = accountRepository.findOneById(id);
        System.out.println("account:");
        printOne(account, false);
    }

    public void printOne(Account account, boolean isListItem) {
        if(isListItem) System.out.println("  - id: " + account.getId());
        else System.out.println("    id: " + account.getId());

        System.out.println("    owner: " + account.getOwner());
        System.out.println("    type: " + account.getType());
        System.out.println("    balance: " + account.getBalance());
    }

    public void create(Account account) {
        accountRepository.saveOne(account);
        System.out.println("Created new account");
    }

    public void remove(int id) {
        accountRepository.removeOneById(id);
        System.out.println("Deleted account");
    }

    public void set(String[] commandFragments) {
        switch (commandFragments[3]) {
            case "balance":
                setBalance(Integer.parseInt(commandFragments[2]), commandFragments[4]);
            case "owner":
                setOwner(Integer.parseInt(commandFragments[2]), Integer.parseInt(commandFragments[4]));
        }
    }

    public void setBalance(int accountId, String newBalance) {
        Account account = accountRepository.findOneById(accountId);
        account.setBalance(new BigDecimal(newBalance));
        System.out.println("Set new balance");
    }

    public void setOwner(int accountId, int newOwner) {
        Account account = accountRepository.findOneById(accountId);
        account.setOwner(newOwner);
        System.out.println("Set new owner");
    }
}

package me.inver;

import java.util.Scanner;

public class Main {
    public static AccountType defaultAccountType;
    private static final ClientCLI clientCLI = new ClientCLI();
    private static final AccountCLI accountCLI = new AccountCLI();

    public static void main(String[] args) {
        setDefaultAccountType(args[0]);
        listenCommands();
    }

    static private void setDefaultAccountType(String type) {
        switch (type) {
            case "CHECKING_ACCOUNT":
                defaultAccountType = AccountType.CHECKING_ACCOUNT;
                break;
            case "MONEY_MARKET":
                defaultAccountType = AccountType.MONEY_MARKET;
                break;
            case "RETIREMENT":
                defaultAccountType = AccountType.RETIREMENT;
                break;
            default:
                defaultAccountType = AccountType.SAVING_ACCOUNT;
        }
    }

    static private void listenCommands() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String command = scanner.nextLine();
            executeCommand(command);
        }
    }

    static private void executeCommand(String command) {
        String[] commandFragments = command.split("\\s+");

        switch (commandFragments[0]) {
            case "client":
                clientCLI.execute(commandFragments);
                break;
            case "account":
                accountCLI.execute(commandFragments);
                break;
            case "help":
                System.out.println("NOT IMPLEMENTED");
                break;
            default:
                printCommandNotFound();
        }
    }

    static private void printCommandNotFound() {
        System.out.println("Command not found. See \"help\"");
    }
}

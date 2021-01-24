package me.inver;

public class ClientCLI implements CLI<Client> {
    private final ClientRepository clientRepository = new ClientRepository();

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
                create(new Client(commandFragments[2], commandFragments[3], commandFragments[4]));
                break;
            case "remove":
                remove(Integer.parseInt(commandFragments[2]));
                break;
            case "help":
                printHelp();
                break;
            default:
                printNotFound();
        }
    }

    public void printNotFound() {
        System.out.println("Subcommand not found. See \"client help\"");
    }

    @Override
    public void list() {
        Client[] allClients = clientRepository.findAll();
        System.out.println("clients:");
        for(Client client : allClients)
            printOne(client, true);
    }

    @Override
    public void printOneById(int id) {
        Client client = clientRepository.findOneById(id);
        System.out.println("client:");
        printOne(client, false);
    }

    @Override
    public void create(Client object) {
        clientRepository.saveOne(object);
        System.out.println("Created new client");
    }

    @Override
    public void remove(int id) {
        clientRepository.removeOneById(id);
        System.out.println("Deleted client");
    }

    @Override
    public void printOne(Client client, boolean isListItem) {
        if(isListItem) System.out.println("  - id: " + client.getId());
        else System.out.println("    id: " + client.getId());

        System.out.println("    name: " + client.getName());
        System.out.println("    surname: " + client.getSurname());
        System.out.println("    address: " + client.getAddress());
    }

    @Override
    public void printHelp() {
        System.out.println("NOT IMPLEMENTED");
    }
}

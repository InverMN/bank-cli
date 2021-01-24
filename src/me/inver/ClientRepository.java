package me.inver;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ClientRepository implements Repository<Client> {
    private ArrayList<Client> clients = new ArrayList();

    @Override
    public Client[] findAll() {
        Client[] clientsArray = new Client[clients.size()];
        for (int i = 0; i < clients.size(); i++)
            clientsArray[i] = clients.get(i);
        return clientsArray;
    }

    @Override
    public Client findOneById(int id) {
        return clients.stream().filter(singleClient -> singleClient.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void removeOneById(int id) {
        clients = (ArrayList<Client>) clients
                .stream()
                .filter(singleClient -> singleClient.getId() != id)
                .collect(Collectors.toList());
    }

    @Override
    public void saveOne(Client client) {
        clients.add(client);
    }

    @Override
    public boolean exists(int id) {
        return findOneById(id) != null;
    }
}

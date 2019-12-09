package repository;

import model.Client;

public class BlockedClientRepository extends AbstractRepository<Client> {

    private static BlockedClientRepository blockedClientRepository;

    private BlockedClientRepository() {
    }

    public static BlockedClientRepository getInstance() {
        if (blockedClientRepository != null) {
            return blockedClientRepository;
        } else {
            blockedClientRepository = new BlockedClientRepository();
        }

        return blockedClientRepository;
    }
}

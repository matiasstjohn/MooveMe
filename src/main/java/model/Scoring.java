package model;

import util.Entity;
import util.KeyGenerator;
import java.util.ArrayList;
import java.util.List;

public class Scoring implements Entity {

    private final Zone zone;
    private final Long key;
    private List<Client> leaderBoard;

    public Scoring(Zone zone) {
        this.zone = zone;
        this.key = new KeyGenerator().generateKey();
        this.leaderBoard = new ArrayList<>();
    }

    @Override
    public Long getKey() {
        return key;
    }

    public Zone getZone() {
        return zone;
    }

    public void addClients(Client client) {
        if (client.hasZone(zone)) {
            leaderBoard.add(client);
        }
    }

    public void sortLeaderBoard(List<Client> clients) {
        clients.sort((Client a, Client b)-> b.getAccumulatedScore() - a.getAccumulatedScore());
    }

    public List<Client> getLeaderBoard() {
        sortLeaderBoard(leaderBoard);
        return leaderBoard;
    }
}

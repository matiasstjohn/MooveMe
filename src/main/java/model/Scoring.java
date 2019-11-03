package model;
import java.util.List;

public class Scoring {
    private List<Client> leaderBoard;
    private List<Discount> discounts;
    private final Zone zone;

    public Scoring(List<Client> leaderBoard, Zone zone) {
        this.leaderBoard = leaderBoard;
        this.zone = zone;
    }

    public void sortLeaderBoard(List<Client> clients) {
        clients.sort((Client a, Client b)-> b.getAccumulatedScore() - a.getAccumulatedScore());
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    public List<Client> getLeaderBoard() {
        return leaderBoard;
    }
}

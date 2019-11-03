package model;
import java.util.List;

public class Client extends User implements ClientI {
    private String phoneNumber;
    private String nickname;
    private Boolean isBlocked;
    private List<Zone> zones;
    private Integer accumulatedScore;
    private Integer scoreToUse;
    private List<Discount> discounts;

    public Client(String username, String password, String phoneNumber, String nickname) {
        super(username, password);
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
    }

    @Override
    public Integer getAccumulatedScore(){
        return accumulatedScore;
    }

    @Override
    public List<Discount> getDiscounts() {
        return discounts;
    }

    @Override
    public String getNickname() {
        return nickname;
    }

    @Override
    public Integer getScoreToUse() {
        return scoreToUse;
    }

    @Override
    public void addDiscounts(Discount discountToAdd) {
        discounts.add(discountToAdd);
    }

    @Override
    public void sumScore(Integer score) {
        this.accumulatedScore += score;
        this.scoreToUse += score;
    }

    @Override
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void addZone(Zone zone) {
        zones.add(zone);
    }

    @Override
    public void blockClient() { isBlocked = true; }

    @Override
    public void unBlockClient() { isBlocked = false; }

    @Override
    public String getPhoneNumber() { return phoneNumber; }

}

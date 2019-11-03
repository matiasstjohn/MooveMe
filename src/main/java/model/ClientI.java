package model;

import java.util.List;

public interface ClientI {
    Integer getAccumulatedScore();
    List<Discount> getDiscounts();
    String getNickname();
    Integer getScoreToUse();
    void addDiscounts(Discount discounts);
    void sumScore(Integer score);
    void setNickname(String nickname);
    void setPhoneNumber(String phoneNumber);
    void addZone(Zone zone);
    void blockClient();
    void unBlockClient();
    String getPhoneNumber();

}

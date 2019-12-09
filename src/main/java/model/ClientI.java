package model;

import util.Voucher;
import java.util.List;

public interface ClientI {

    Integer getPhoneNumber();

    String getNickname();

    Boolean isBlocked();

    Integer getAccumulatedScore();

    Integer getScoreToUse();

    List<Discount> getDiscounts();

    List<Voucher> getVouchers();

    void blockClient();

    void unBlockClient();

    void addZone(Zone zone);

    Boolean hasZone(Zone zone);

    void sumScore(Integer score);

    void useScore(Integer score);

    void addDiscounts(Discount discounts);

    void useDiscount(Discount discount);

    void addVoucher(Voucher voucher);

    void useVoucher(Voucher voucher);
}

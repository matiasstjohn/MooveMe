package model;

import util.Voucher;
import java.util.ArrayList;
import java.util.List;

public class Client extends User implements ClientI {

    private Integer phoneNumber;
    private String nickname;
    private Boolean isBlocked;
    private Integer accumulatedScore;
    private Integer scoreToUse;
    private List<Zone> zones;
    private List<Discount> discounts;
    private List<Voucher> vouchers;

    public Client(String username, String password, Integer phoneNumber, String nickname) {
        super(username, password);
        this.accumulatedScore = 0;
        this.scoreToUse = 0;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
        this.zones = new ArrayList<>();
        this.discounts = new ArrayList<>();
        this.vouchers = new ArrayList<>();
    }

    @Override
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getNickname() {
        return nickname;
    }

    @Override
    public Boolean isBlocked() {
        return isBlocked;
    }

    @Override
    public Integer getAccumulatedScore() {
        return accumulatedScore;
    }

    @Override
    public Integer getScoreToUse() {
        return scoreToUse;
    }

    @Override
    public List<Discount> getDiscounts() {
        return discounts;
    }

    @Override
    public List<Voucher> getVouchers() {
        return vouchers;
    }

    @Override
    public void blockClient() { isBlocked = true; }

    @Override
    public void unBlockClient() { isBlocked = false; }

    @Override
    public void sumScore(Integer score) {
        this.accumulatedScore += score;
        this.scoreToUse += score;
    }

    @Override
    public void useScore(Integer score) {
        scoreToUse -= score;
    }

    @Override
    public void addZone(Zone zone) {
        zones.add(zone);
    }

    @Override
    public Boolean hasZone(Zone zone) {
        for (Zone zone1: zones) {
            if (zone1.equals(zone)) return true;
        }

        return false;
    }

    @Override
    public void addDiscounts(Discount discountToAdd) {
        discounts.add(discountToAdd);
    }

    @Override
    public void useDiscount(Discount discount) {
        discounts.remove(discount);
    }

    @Override
    public void addVoucher(Voucher voucher) {
        vouchers.add(voucher);
    }

    @Override
    public void useVoucher(Voucher voucher) {
        vouchers.remove(voucher);
    }
}

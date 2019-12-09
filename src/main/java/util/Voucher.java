package util;

public class Voucher {

    private final String description;
    private final Integer percent;

    public Voucher(String description) {
        this.description = description;
        this.percent = 50;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPercent() {
        return percent;
    }

    public boolean equals(Voucher voucher) {
        return this.getDescription().equals(voucher.getDescription());
    }
}

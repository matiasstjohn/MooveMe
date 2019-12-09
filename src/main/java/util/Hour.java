package util;

public class Hour {

    private int minute;
    private int hour;

    public Hour(int minute, int hour) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    public int compareTo(Hour tripTime) {
        return this.getHour() - tripTime.getHour();
    }
}

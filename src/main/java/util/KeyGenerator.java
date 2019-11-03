package util;

public class KeyGenerator {
    private Integer key;

    public KeyGenerator() {
    }

    public Integer generateKey() {
        return key += 1;
    }
}

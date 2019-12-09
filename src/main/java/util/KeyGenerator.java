package util;

import java.util.Date;

public class KeyGenerator {

    public Long generateKey() {
        return new Date().getTime();
    }
}

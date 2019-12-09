package model;

import util.Entity;
import util.KeyGenerator;

public abstract class User implements Entity {
    private final Long key;
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.key = new KeyGenerator().generateKey();
        this.username = username;
        this.password = password;
    }

    @Override
    public Long getKey() {
        return key;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

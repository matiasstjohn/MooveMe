package util;

import model.User;

public interface UserRepositoryInterface {

    User searchByUsername(String username);
}

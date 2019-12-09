package repository;

import model.Admin;
import model.User;
import util.UserRepositoryInterface;
import java.util.List;

public class AdminRepository extends AbstractRepository<Admin> implements UserRepositoryInterface {

    private static AdminRepository adminRepository;

    private AdminRepository() {
        create(new Admin("admin", "pass"));
    }

    @Override
    public User searchByUsername(String username) {
        List<Admin> admins = findAll();

        for (Admin admin: admins) {
            if (admin.getUsername().equals(username)) return admin;
        }

        return null;
    }

    public static AdminRepository getInstance() {
        if (adminRepository != null) {
            return adminRepository;
        } else {
            adminRepository = new AdminRepository();
        }

        return adminRepository;
    }
}

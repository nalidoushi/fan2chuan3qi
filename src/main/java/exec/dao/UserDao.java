package exec.dao;

import exec.domain.User;

public interface UserDao {
    public User findUserById(int id);
    public void insertUser(User user);
}

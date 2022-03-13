package service;

import Dao.UserDAO;
import java.sql.SQLException;
import java.util.List;
import model.User;

public class UserService {
    private UserDAO userDao;
    
    public UserService() {
        userDao = new UserDAO();
    }
    
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }
    
    public void addUser(User user) throws SQLException {
        userDao.addUser(user);
    }
    
    public void deleteUser(int id_User) throws SQLException {
        userDao.deleteUser(id_User);
    }
    
    public User getUserById(int id_User) throws SQLException {
        return userDao.getUserById(id_User);
    }
    
    public void updateUser(User user) throws SQLException {
        userDao.updateUser(user);
    }
    
    public boolean isLoginUser(User user) throws SQLException {
        return userDao.isLoginUser(user);
    }
    
    public boolean isLoginAdmin(User user) throws SQLException {
        return userDao.isLoginAdmin(user);
    }
    
    public int register(User user) throws SQLException {
        return userDao.register(user);
    }
    
}

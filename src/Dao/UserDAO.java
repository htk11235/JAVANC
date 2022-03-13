package Dao;

import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<User>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM Accounts";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId_User(rs.getInt("id_User"));
                user.setId_Role(rs.getInt("id_Role"));
                user.setUser_Name(rs.getString("user_Name"));
                user.setPass_Word(rs.getString("pass_Word"));

                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User getUserById(int id_User) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM Accounts WHERE id_User = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_User);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId_User(rs.getInt("id_User"));
                user.setId_Role(rs.getInt("id_Role"));
                user.setUser_Name(rs.getString("user_Name"));
                user.setPass_Word(rs.getString("pass_Word"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void addUser(User user) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "INSERT INTO Accounts(id_Role, user_Name, pass_Word) VALUES(?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId_Role());
            preparedStatement.setString(2, user.getUser_Name());
            preparedStatement.setString(3, user.getPass_Word());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateUser(User user) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "UPDATE Accounts SET id_Role = ?, user_Name = ?, pass_Word = ? WHERE id_User = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId_Role());
            preparedStatement.setString(2, user.getUser_Name());
            preparedStatement.setString(3, user.getPass_Word());
            preparedStatement.setInt(4, user.getId_User());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id_User) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "DELETE FROM Accounts WHERE id_User = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_User);

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean isLoginUser(User user) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM Accounts WHERE user_Name = ? AND id_Role = (select id_Role from Roles where role_Name = ?) AND BINARY_CHECKSUM(pass_Word) = BINARY_CHECKSUM(?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUser_Name());
        preparedStatement.setString(2, "USER");
        preparedStatement.setString(3, user.getPass_Word());

        ResultSet rs = preparedStatement.executeQuery();
        return rs.next();
    }

    public boolean isLoginAdmin(User user) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM Accounts WHERE user_Name = ? AND id_Role = (select id_Role from Roles where role_Name = ?) AND pass_Word = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUser_Name());
        preparedStatement.setString(2, "ADMIN");
        preparedStatement.setString(3, user.getPass_Word());

        ResultSet rs = preparedStatement.executeQuery();
        return rs.next();
    }

    public int register(User user) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "INSERT INTO Accounts(id_Role, user_Name, pass_Word) VALUES(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, user.getUser_Name());
            preparedStatement.setString(3, user.getPass_Word());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

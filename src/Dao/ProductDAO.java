package Dao;

import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<Product>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM Products";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setId_Product(rs.getInt("id_Product"));
                product.setId_Category(rs.getInt("id_Category"));
                product.setProduct_Name(rs.getString("product_Name"));
                product.setPrice(rs.getDouble("price"));

                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public Product getProductById(int id_Product) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM Products WHERE id_Product = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_Product);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setId_Product(rs.getInt("id_Product"));
                product.setId_Category(rs.getInt("id_Category"));
                product.setProduct_Name(rs.getString("product_Name"));
                product.setPrice(rs.getDouble("price"));

                return product;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int addProduct(Product product) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "INSERT INTO Products(id_Category, product_Name, price) VALUES(?, ?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getId_Category());
            preparedStatement.setString(2, product.getProduct_Name());
            preparedStatement.setDouble(3, product.getPrice());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateProduct(Product product) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "UPDATE Products SET id_Category = ?, product_Name = ?, price = ? WHERE id_Product = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getId_Category());
            preparedStatement.setString(2, product.getProduct_Name());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getId_Product());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteProduct(int id_Product) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "DELETE FROM Products WHERE id_Product = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_Product);

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }
}

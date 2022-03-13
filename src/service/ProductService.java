package service;

import Dao.ProductDAO;
import java.sql.SQLException;
import java.util.List;
import model.Product;


public class ProductService {
    private ProductDAO productDao;
    
    public ProductService() {
        productDao = new ProductDAO();
    }
    
    public List<Product> getAllProducts() throws SQLException {
        return productDao.getAllProducts();
    }
    
    public int addProduct(Product product) throws SQLException {
        return productDao.addProduct(product);
    }
    
    public int deleteProduct(int id_Product) throws SQLException {
        return productDao.deleteProduct(id_Product);
    }
    
    public Product getProductById(int id_Product) throws SQLException {
        return productDao.getProductById(id_Product);
    }
    
    public int updateProduct(Product product) throws SQLException {
        return productDao.updateProduct(product);
    }
}

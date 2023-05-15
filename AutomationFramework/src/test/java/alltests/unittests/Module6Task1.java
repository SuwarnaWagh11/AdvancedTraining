package alltests.unittests;

import com.epam.tamentoring.bo.Product;
import com.epam.tamentoring.bo.ShoppingCart;
import com.epam.tamentoring.exceptions.ProductNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Module6Task1 {

    List<Product> productList;
    ShoppingCart shoppingCart;
    Product product1, product2, product3, product4, product5, product6, product7, product8;
   @Before
   public void setUpTestData() {
       productList = new ArrayList<>();
       product1 = new Product(1, "P1", 2, 4);
       product2 = new Product(2, "P2", 2, 4);
       product3 = new Product(3, "P3", 2, 4);
       product4 = new Product(4, "P4", 2, 4);
       productList.add(product1);productList.add(product2);productList.add(product3);productList.add(product4);
       shoppingCart = new ShoppingCart(productList);
   }
   @Test
   public void addSingleProducts() {
       product5 = new Product(5, "P5", 2, 4);
       shoppingCart.addProductToCart(product5);
       Assert.assertTrue(shoppingCart.getProducts().contains(product5));
       Assert.assertEquals(product5, shoppingCart.getProductById(5));
   }
    @Test
    public void addMultipleProducts() {
        product5 = new Product(5, "P5", 2, 4);
        product6 = new Product(6, "P6", 2, 4);
        product7 = new Product(7, "P7", 2, 4);
        shoppingCart.addProductToCart(product5);
        shoppingCart.addProductToCart(product6);
        shoppingCart.addProductToCart(product7);
        Assert.assertTrue(shoppingCart.getProducts().contains(product5));
        Assert.assertTrue(shoppingCart.getProducts().contains(product6));
        Assert.assertTrue(shoppingCart.getProducts().contains(product7));
        Assert.assertEquals(product5, shoppingCart.getProductById(5));
        Assert.assertEquals(product6, shoppingCart.getProductById(6));
        Assert.assertEquals(product7, shoppingCart.getProductById(7));
    }
    @Test
    public void addNullProducts() {
        try {
            shoppingCart.addProductToCart(null);
        }catch(NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void removeSingleProducts() {
        shoppingCart.removeProductFromCart(product4);
        Assert.assertFalse(shoppingCart.getProducts().contains(product4));
    }
    @Test
    public void removeMultipleProducts() {
        shoppingCart.removeProductFromCart(product4);
        shoppingCart.removeProductFromCart(product3);
        Assert.assertFalse(shoppingCart.getProducts().contains(product4));
        Assert.assertFalse(shoppingCart.getProducts().contains(product3));
    }
    @Test
    public void removeUnlistedProducts() {
        try {
            shoppingCart.removeProductFromCart(product5);
        } catch(NullPointerException ex) {
        System.out.println(ex.getMessage());
        }
    }
    @Test
    public void removeNullProducts() {
        try {
            shoppingCart.removeProductFromCart(null);
        } catch(NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void verifyTotalPriceAfterRemovingSingleProduct() {
        shoppingCart.removeProductFromCart(product4);
        Assert.assertEquals(24, shoppingCart.getCartTotalPrice(), 0.0001);

    }
    @Test
    public void verifyTotalPriceAfterRemovingMultipleProduct() {
        shoppingCart.removeProductFromCart(product4);
        shoppingCart.removeProductFromCart(product3);
        Assert.assertEquals(16, shoppingCart.getCartTotalPrice(), 0.0001);
    }
    @Test
    public void verifyTotalPriceAfterRemovingUnlistedProduct() {
        try {
            shoppingCart.removeProductFromCart(product7);
        } catch(NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void verifyTotalPriceAfterRemovingNullProduct() {
        try {
            shoppingCart.removeProductFromCart(null);
        } catch(NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void verifyExceptionAfterRemovingProductFromCart() {
        shoppingCart.removeProductFromCart(product4);
        try{
            shoppingCart.removeProductFromCart(product1);
        }catch (ProductNotFoundException ex){
            Assert.assertEquals(ex.getMessage(), "Product is not found in the cart: Product(id=4, name=P4, price=2.0, quantity=4.0)");
        }
    }
    @Test
    public void verifyGetProductByIdForNonExistingProduct() {
        try{
            shoppingCart.getProductById(product3.getId());
        }catch (ProductNotFoundException ex){
            Assert.assertEquals(ex.getMessage(), "Product with 3 ID is not found in the shopping cart!");
        }
    }
}

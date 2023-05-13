package alltests.unittests;

import com.epam.tamentoring.bo.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    @InjectMocks
    OrderService orderService;
    @Mock
    DiscountUtility discountUtil;
    Product product1,product2,product3;
    ShoppingCart shoppingCart;
    List<Product> productList;
    UserAccount user;

    @Before
    public void init(){
     MockitoAnnotations.openMocks(this);
     productList = new ArrayList<>();
     product1 = new Product(001, "P1", 2, 4);
     product2 = new Product(002, "P2", 2, 4);
     product3 = new Product(003, "P3", 2, 4);
     productList.add(product1);productList.add(product2);productList.add(product3);
     shoppingCart = new ShoppingCart(productList);
     user = new UserAccount("John","Smith","1990/10/10", shoppingCart);
    }
    @Test
    public void validateTestForDiscountAmount3(){
        Mockito.when(discountUtil.calculateDiscount(user)).thenReturn(3.0);
        Assert.assertEquals(orderService.getOrderPrice(user), 21.00, 0.001);
    }
    @Test
    public void mockObjectCalledOnce(){
        Mockito.when(discountUtil.calculateDiscount(user)).thenReturn(3.0);
        Assert.assertEquals(orderService.getOrderPrice(user), 21.00, 0.001);
        Mockito.verify(discountUtil, Mockito.times(1)).calculateDiscount(user);
    }
    @Test
    public void mockObjectHasNoOtherInteractions(){
        Mockito.when(discountUtil.calculateDiscount(user)).thenReturn(3.0);
        Assert.assertEquals(orderService.getOrderPrice(user), 21.00, 0.001);
        Mockito.verify(discountUtil, Mockito.times(1)).calculateDiscount(user);
        Mockito.verifyNoMoreInteractions(discountUtil);
    }
}

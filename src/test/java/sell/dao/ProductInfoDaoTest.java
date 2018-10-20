package sell.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sell.mapping.ProductInfo;
import java.math.BigDecimal;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao productInfoDao;


    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("测试");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setDescription("还不错");
        productInfo.setProductIcon("http://test.com");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(10);
        ProductInfo result = productInfoDao.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByProductStatus() {
    }
}
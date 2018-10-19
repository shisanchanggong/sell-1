package sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sell.mapping.ProductInfo;

import java.util.List;

/**
 * @author totalo
 * 商品dao
 */
public interface ProductInfoDao extends JpaRepository<ProductInfoDao,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}

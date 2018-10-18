package sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sell.mapper.ProductCategory;

/**
 * @author totalo
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

}

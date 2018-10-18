package sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sell.mapping.ProductCategoryMapping;

/**
 * @author totalo
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategoryMapping,Integer> {

}

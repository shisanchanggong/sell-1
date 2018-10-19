package sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sell.mapping.ProductCategory;

import java.util.List;


/**
 * @author totalo
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

    /**
     * 根据类目类型查询
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}

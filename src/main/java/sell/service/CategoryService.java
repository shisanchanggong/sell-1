package sell.service;

import sell.mapping.ProductCategory;

import java.util.List;

/**
 * @author totalo
 * 类目服务类
 */
public interface CategoryService {

    /**
     * 单ID查询
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 从列表中查询
     * @param categoryList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryList);

    /**
     * 新增类目查询
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}

package sell.mapping;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.Date;


/**
 * product_category
 * 商品类目表
 * @author totalo
 * @Entity 实体类
 * @DynamicUpdate 动态更新
 * @Data getset方法插件
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    /**类目id*/
    @Id
    @GeneratedValue
    private Integer categoryId;

    /**类目名*/
    private String categoryName;

    /**类目编号*/
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "ProductCategoryMapping{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }
}

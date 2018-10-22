package sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 处理表单数据
 * @author totalo
 */
@Data
public class ProductForm {

    /***/
    private String productId;

    /**商品名*/
    private String productName;

    /**单价*/
    private BigDecimal productPrice;

    /**库存*/
    private Integer productStock;

    /**商品描述*/
    private String productDescription;

    /**商品小图*/
    private String productIcon;


    /**类目编号*/
    private Integer categoryType;
}

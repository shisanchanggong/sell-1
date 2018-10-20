package sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import sell.mapping.ProductInfo;

import java.util.List;

/**
 * @author totalo
 * 商品包含类目
 * @JsonProperty Json序列化得返回相关字段
 * 创建VO考虑前端所需字段，保障安全性和隐私性
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}

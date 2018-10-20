package sell.enums;

import lombok.Getter;

/**
 * @author totalo
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10,"商品不存"),
    PRODUCT_STOCK_ERROR(11,"库存异常")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

package sell.enums;

import lombok.Getter;

/**
 * @author totalo
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10,"商品不存"),
    PRODUCT_STOCK_ERROR(11,"库存异常"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDER_DETAIL_NOT_EXIST(12,"订单详情错误")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

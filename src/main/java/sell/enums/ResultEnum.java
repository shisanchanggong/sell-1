package sell.enums;

import lombok.Getter;

/**
 * @author totalo
 */
@Getter
public enum ResultEnum {

    SUCCESS(0,"成功"),

    PARAM_ERROR(1,"参数错误"),

    PRODUCT_NOT_EXIST(10,"商品不存"),

    PRODUCT_STOCK_ERROR(11,"库存异常"),

    ORDER_NOT_EXIST(12,"订单不存在"),

    ORDER_DETAIL_NOT_EXIST(13,"订单详情错误"),

    ORDER_STATUS_ERROR(14,"订单状态异常"),

    ORDER_UPDATE_FAIL(15,"订单更新失败"),

    ORDER_DERAIL_EMPTY(16,"订单详情为空"),

    CART_EMPTY(17,"购物车不能为空"),

    ORDER_OWN_ERROR(18,"订单匹配异常"),

    WECHAT_MP_ERROR(19,"公众号授权异常"),

    PRODUCT_STATUS_ERROR(20,"商品状态异常"),

    LOGIN_FAIL(21,"登陆失败")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

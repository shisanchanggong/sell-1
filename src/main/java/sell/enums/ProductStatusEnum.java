package sell.enums;

import lombok.Getter;

/**
 * @author totalo
 * 商品状态枚举
 * @Getter 出自lombok,表示构造方法
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{

    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;

    private String msg;

    ProductStatusEnum(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }
}

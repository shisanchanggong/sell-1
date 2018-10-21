package sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 表单验证
 * @author totalo
 */
@Data
public class OrderForm {

    /**买家姓名*/
    @NotEmpty(message = "姓名必填")
    private String name;

    /**买家手机号*/
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**买家openid*/
    @NotEmpty(message = "OpenId必填")
    private String openId;

    /**买家地址*/
    @NotEmpty(message = "地址必填")
    private String address;

    /**购物车列表项*/
    @NotEmpty(message = "购物车不为空")
    private String items;

}

package sell.dto;

import lombok.Data;
import sell.enums.OrderStatusEnum;
import sell.enums.PayStatusEnum;
import sell.mapping.OrderDetail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 数据传输对象
 */
@Data
public class OrderDTO {
    private String orderId;

    /**买家名字*/
    private String buyerName;

    /**买家手机号*/
    private String buyerPhone;

    /**买家地址*/
    private String buyerAddress;

    /**买家openid*/
    private String buyerOpenid;

    /**订单金额*/
    private BigDecimal orderAmount;

    /**订单状态 默认0新下单 */
    private Integer orderStatus;

    /**支付状态。默认0未支付*/
    private Integer payStatus;

    /**创建时间*/
    private Date createTime;

    /**更新时间*/
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}

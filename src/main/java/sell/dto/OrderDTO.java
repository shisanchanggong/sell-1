package sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import sell.enums.OrderStatusEnum;
import sell.enums.PayStatusEnum;
import sell.mapping.OrderDetail;
import sell.utils.serializer.Date2LongSerializer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 数据传输对象
 * @author totalo
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    /**订单详情*/
    List<OrderDetail> orderDetailList;
}

package sell.service;

import sell.dto.OrderDTO;

/**
 * 买家
 * @author totalo
 */
public interface BuyerService {

    /**查询订单*/
    OrderDTO findOrderOne(String openid,String orderId);

    OrderDTO cancelOrder(String openid,String orderId);
}

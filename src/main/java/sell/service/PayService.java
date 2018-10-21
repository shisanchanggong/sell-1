package sell.service;

import sell.dto.OrderDTO;

/**
 * 支付接口
 */
public interface PayService {

    void create(OrderDTO orderDTO);
}

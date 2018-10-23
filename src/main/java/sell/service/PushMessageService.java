package sell.service;

import sell.dto.OrderDTO;

public interface PushMessageService {
    /**
     * 订单状态
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}

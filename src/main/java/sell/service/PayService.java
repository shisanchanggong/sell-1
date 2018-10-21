package sell.service;

import com.lly835.bestpay.model.PayResponse;
import sell.dto.OrderDTO;

/**
 * 支付接口
 */
public interface PayService {

    /**
     * 发起支付
     * @param orderDTO
     * @return
     */
    PayResponse create(OrderDTO orderDTO);

    /**
     * 异步消息通知
     * @param notifyData
     * @return
     */
    PayResponse notify(String notifyData);
}

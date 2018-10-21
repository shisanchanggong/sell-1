package sell.service;

import com.lly835.bestpay.model.PayResponse;
import sell.dto.OrderDTO;

/**
 * 支付接口
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);
}

package sell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sell.dto.OrderDTO;
import sell.enums.ResultEnum;
import sell.exception.SellException;
import sell.service.OrderService;

/**
 * 支付
 * @author totalo
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    public void create(@RequestParam("orderId")String orderId,
                       @RequestParam("returnUrl")String returnUrl) {
        //查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //发起支付

    }
}

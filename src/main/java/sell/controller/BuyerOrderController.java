package sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sell.VO.ResultVO;
import sell.converter.OrderForm2OrderDTOConverter;
import sell.converter.OrderMaster2OrderDTOConverter;
import sell.dto.OrderDTO;
import sell.enums.ResultEnum;
import sell.exception.SellException;
import sell.form.OrderForm;
import sell.service.OrderService;
import sell.utils.ResultVOUtil;
import sun.rmi.runtime.Log;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户点单
 * @author totalo
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult) {
        if ( bindingResult.hasErrors()) {
            log.error("【创建订单】参数错误{}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        log.info("【info1】{}",orderDTO);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        log.info("【info】{}",orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());

        return ResultVOUtil.success(map);
    }
}
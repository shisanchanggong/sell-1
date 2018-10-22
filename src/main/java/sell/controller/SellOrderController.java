package sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sell.dto.OrderDTO;
import sell.enums.ResultEnum;
import sell.exception.SellException;
import sell.service.OrderService;

import java.util.Map;

/**
 * 卖家端后天管理
 * @author totalo
 * ModelAndView 模板渲染
 */
@Controller
@Slf4j
@RequestMapping("/seller/order")
public class SellOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                             @RequestParam(value = "size",defaultValue = "10")Integer size,
                             Map<String,Object> map) {
        PageRequest pageRequest = new PageRequest(page - 1,size);
        Page<OrderDTO> orderDTOPage = orderService.findAllList(pageRequest);
        map.put("orderDTOPage",orderDTOPage);
        map.put("curretPage",page);
        map.put("size",size);
        return new ModelAndView("order/list",map);
    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId")String orderId,
                               Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        }catch (SellException e){
            log.info("【卖家订单】订单不存在");
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");

            return new ModelAndView("common/error",map);
        }
        map.put("msg", ResultEnum.SUCCESS);
        map.put("url","/sell/seller/order/list");

        return new ModelAndView("common/success",map);
    }
}

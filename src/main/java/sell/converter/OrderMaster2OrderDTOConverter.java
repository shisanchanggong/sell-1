package sell.converter;

import org.springframework.beans.BeanUtils;
import sell.dto.OrderDTO;
import sell.mapping.OrderMaster;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 转换器是什么鬼哦
 * 终于知道包啥地都是假地 自己想有就有的东西
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e ->
                convert(e)).collect(Collectors.toList());
    }
}

package sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sell.mapping.OrderDetail;

import java.util.List;

/**
 * @author totalo
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);
}

package sell.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sell.mapping.OrderMaster;

/**
 * @author totalo
 *
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {

    /**
     * 通过用户参数查询用户订单列表
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}

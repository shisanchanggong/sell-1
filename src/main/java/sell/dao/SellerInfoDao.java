package sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sell.mapping.SellerInfo;

public interface SellerInfoDao extends JpaRepository<SellerInfo,String> {

    SellerInfo findByOpenid(String openid);
}

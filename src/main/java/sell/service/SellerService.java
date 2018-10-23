package sell.service;

import sell.mapping.SellerInfo;

/**
 * 卖家端
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}

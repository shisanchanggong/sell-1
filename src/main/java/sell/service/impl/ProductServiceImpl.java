package sell.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sell.dao.ProductInfoDao;
import sell.dto.CartDTO;
import sell.enums.ProductStatusEnum;
import sell.enums.ResultEnum;
import sell.exception.SellException;
import sell.mapping.ProductInfo;
import sell.service.ProductService;

import javax.transaction.Transactional;
import java.util.List;

/***
 * @author totalo
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO :cartDTOList){
            ProductInfo productInfo = productInfoDao.findOne(cartDTO.getProductId());
                if(productInfo == null){
                    throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
                }

                Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
                if(result < 0){
                    throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
                }
                productInfo.setProductStock(result);

                productInfoDao.save(productInfo);
            }
        }
}

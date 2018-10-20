package sell.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sell.VO.ProductInfoVO;
import sell.VO.ProductVO;
import sell.VO.ResultVO;
import java.util.Arrays;

/**
 * @author totalo
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO = new ResultVO();
        ProductInfoVO productInfoVO = new ProductInfoVO();
        ProductVO productVO = new ProductVO();

        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
        resultVO.setData(Arrays.asList(productVO));

        return  resultVO;

    }
}

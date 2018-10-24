package sell.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sell.VO.ProductInfoVO;
import sell.VO.ProductVO;
import sell.VO.ResultVO;
import sell.mapping.ProductCategory;
import sell.mapping.ProductInfo;
import sell.service.CategoryService;
import sell.service.ProductService;
import sell.utils.ResultVOUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author totalo
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product",key = "123")
    public ResultVO list(){
        //1.查询所有上架得商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目（一次性查询）
       // List<Integer> categoryTypeList = new ArrayList<>();
        /**传统方法
        for(ProductInfo productInfo : productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }
        */

        // 精简方法java 8 lamba表达式
        List<Integer> categoryTypeList =  productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        //外层list
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory :productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            //第二层list
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);

    }
}

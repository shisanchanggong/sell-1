package sell.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sell.enums.ProductStatusEnum;
import sell.exception.SellException;
import sell.form.ProductForm;
import sell.mapping.ProductCategory;
import sell.mapping.ProductInfo;
import sell.service.CategoryService;
import sell.service.ProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/***
 * 卖家商品列表
 * @author totalo
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

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
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        map.put("productInfoPage",productInfoPage);
        map.put("curretPage",page);
        map.put("size",size);
        return new ModelAndView("product/list",map);
    }

    /**
     * 上架
     * @param productId
     * @return
     */
    @GetMapping("/onSale")
    public ModelAndView onSale(@RequestParam("productId")String productId,
                               Map<String, Object> map) {
        try {
            productService.onSale(productId);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");

            return new ModelAndView("common/error",map);
        }
        map.put("msg","成功");
        map.put("url","/sell/seller/product/list");

        return new ModelAndView("common/success",map);
    }

    /**
     * 上架
     * @param productId
     * @return
     */
    @GetMapping("/offSale")
    public ModelAndView offSale(@RequestParam("productId")String productId,
                               Map<String, Object> map) {
        try {
            productService.offSale(productId);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");

            return new ModelAndView("common/error",map);
        }
        map.put("msg","成功");
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    /**
     * 修改商品
     * @param productId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false)String productId,
                      Map<String,Object>map){
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo",productInfo);
        }
        //查询所有得类目
        List<ProductCategory> list = categoryService.findAll();
        map.put("categoryList",list);

        return new ModelAndView("product/index",map);
    }

    /**
     * 保存更新方法
     * @param productForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm productForm,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/product/list");

            return new ModelAndView("/common/error",map);
        }

        ProductInfo productInfo = productService.findOne(productForm.getProductId());
        BeanUtils.copyProperties(productForm,productInfo);

        try {
            productService.save(productInfo);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
        }
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("/common/success",map);
    }
}

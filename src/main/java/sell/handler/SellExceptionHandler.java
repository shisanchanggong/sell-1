package sell.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import sell.config.ProjectUrl;
import sell.exception.SellerAuthorizeException;

/**
 * 异常处理
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrl projectUrl;

    /**
     * 拦截登陆异常
     */
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect"
                .concat(projectUrl.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat(projectUrl.getSell()
                        .concat("/sell/seller/login")));
    }
}

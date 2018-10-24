package sell.exception;

import lombok.Data;
import sell.enums.ResultEnum;

/**
 * @author totalo
 * 自定义异常
 */
@Data
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String defaultMessage) {
        super(defaultMessage);
        this.code = code;
    }
}

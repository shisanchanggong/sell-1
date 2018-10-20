package sell.utils;

import sell.VO.ResultVO;

/**
 * 结果工具
 */
public class ResultVOUtil {
    /***
     * 带参数成功
     * @param object
     * @return
     */
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    /**
     * 不带参数
     * @return
     */
    public static ResultVO success(){
        return success(null);
    }

    /**
     * 发生错误
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}

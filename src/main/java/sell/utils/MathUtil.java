package sell.utils;

/**
 * 考虑精度问题，需要对于数据进行统一处理
 */
public class MathUtil {

    private final static double e = 0.001;

    public static Boolean equals(Double b1,Double b2){
        Double result = Math.abs(b1 - b2);
        if (result < e) {
            return true;
        }
        return false;
    }
}

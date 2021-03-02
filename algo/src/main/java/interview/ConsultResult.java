package interview;

/**
 * @author allen.jin
 * @date 2021/1/18
 * @Description TODO
 */
public class ConsultResult {
    private boolean isEnable;
    private String errorCode;

    public ConsultResult(boolean isEnable, String errorCode) {
        this.isEnable = isEnable;
        this.errorCode = errorCode;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

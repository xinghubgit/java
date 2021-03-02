package interview;

/**
 * @author allen.jin
 * @date 2021/1/18
 * @Description TODO
 */
public interface PaymentMethod {
    ConsultResult isEnabled();

    String getPaymentMethod();
}

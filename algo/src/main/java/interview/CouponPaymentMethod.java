package interview;

/**
 * @author allen.jin
 * @date 2021/1/18
 * @Description TODO
 */
public class CouponPaymentMethod implements PaymentMethod {
    @Override
    public String getPaymentMethod() {
        return PaymentMethodEnum.COUPON.name();
    }

    @Override
    public ConsultResult isEnabled() {
        /**
         * CouponPayment Check
         */
        return null;
    }
}

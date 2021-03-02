package interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @author allen.jin
 * @date 2021/1/18
 * @Description PaymentRemoteServiceImpl
 */
@Service
public class PaymentRemoteServiceImpl implements  PaymentRemoteSerivce {

    @Autowired
    private List<PaymentMethod> paymentMethods;

    private Map<String, PaymentMethod> map;

    /**
     * @auther: allen.jin
     * @date: 2021/1/18
     * @Description: To get all PaymentMethod implements and put them into map.
     */
    @PostConstruct
    public void init() {
        paymentMethods.stream().forEach(x -> {
            map.put(x.getPaymentMethod(), x);
        });
    }

    /**
     * @auther: allen.jin
     * @date: 2021/1/18
     * @Description: Get PaymentMethod through different paymentType; Return the PaymentMethod result.
     */
    @Override
    public ConsultResult isEnabled(String paymentType) {
        PaymentMethod method = map.get(paymentType);
        if (method == null) {
            return new ConsultResult(false, "");
        }
        return method.isEnabled();
    }
}

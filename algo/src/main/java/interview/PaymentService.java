package interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author allen.jin
 * @date 2021/1/18
 * @Description PaymentService
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentRemoteSerivce paymentRemoteSerivce;

    /**
     * @auther: allen.jin
     * @date: 2021/1/18
     * @Description: get all available Payment Methods.
     */
    public List<String> getAvailablePaymentMethods() {
        return Arrays.asList(PaymentMethodEnum.values())
                .parallelStream()
                .filter(s -> paymentRemoteSerivce.isEnabled(s.name()).isEnable())
                .map(x -> x.name())
                .collect(Collectors.toList());
    }
}

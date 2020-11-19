package com.allen.svc.service.impl;

import com.allen.svc.service.CalcService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @date 2020/11/16
 */

@Profile("java8")
@Service
public class CalcServiceImpl implements CalcService {
    @Override
    public Integer sum(Integer... nums) {
        System.out.println("java 8 CalcService ...");
        Integer sum = Stream.of(nums).reduce(0, Integer::sum);
        System.out.println("Sum = " + sum);
        return sum;
    }
}

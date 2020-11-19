package com.allen.svc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date 2020/11/12
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private String name;
    private String secu;
    private String csfId;
}

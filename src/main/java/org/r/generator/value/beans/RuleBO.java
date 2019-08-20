package org.r.generator.value.beans;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RuleBO {


    /**
     * 字符串模式
     */
    private String pattern;

    /**
     * 最大值
     */
    private BigDecimal maxValue;

    /**
     * 最小值
     */
    private BigDecimal minValue = BigDecimal.ZERO;


}

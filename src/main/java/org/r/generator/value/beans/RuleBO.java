package org.r.generator.value.beans;

import lombok.Data;

@Data
public class RuleBO {


    /**
     * 长度
     */
    private Integer length;

    /**
     * 字符串模式
     */
    private String Pattern;

    /**
     * 最大值
     */
    private Integer maxValue;

    /**
     * 最小值
     */
    private Integer minValue = 0;


}

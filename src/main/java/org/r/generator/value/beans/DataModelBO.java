package org.r.generator.value.beans;

import lombok.Data;

import java.util.List;

@Data
public class DataModelBO {

    /**
     * 属性名称
     */
    private String name;

    /**
     * 属性类型
     */
    private String type;

    /**
     * 属性在当前的数据模型的深度，从1开始
     */
    private Integer deep;

    /**
     * 属性限制
     */
    private RuleBO rule;

    /**
     * 是否需要生成
     */
    private boolean isIgnore;

    /**
     * 是否是数组
     */
    private boolean isArray;

    /**
     * 子属性
     */
    private List<DataModelBO> children;

}

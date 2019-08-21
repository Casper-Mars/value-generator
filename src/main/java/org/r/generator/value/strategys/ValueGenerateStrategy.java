package org.r.generator.value.strategys;


import org.r.generator.value.beans.RuleBO;

public interface ValueGenerateStrategy<T> {

    /**
     * 生成值
     *
     * @return
     */
    T getValue();

    /**
     * 根据属性名称生成值
     *
     * @param propertyName 属性名称
     * @return
     */
    T getValue(String propertyName);


    /**
     * 根据属性值的限制条件产生值
     *
     * @param rule 限制条件
     * @return
     */
    default T getValue(RuleBO rule) {
        return getValue();
    }


}

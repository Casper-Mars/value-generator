package org.r.generator.value.strategys;


import org.r.generator.value.beans.RuleBO;
import org.r.generator.value.tool.UtilTool;

public class IntegerValueGenerateStrategy implements ValueGenerateStrategy<Integer> {

    /**
     * 生成值
     *
     * @return
     */
    @Override
    public Integer getValue() {
        return UtilTool.getRandomInteger(0, 100);
    }

    /**
     * 根据属性名称生成值
     *
     * @param propertyName 属性名称
     * @return
     */
    @Override
    public Integer getValue(String propertyName) {
        return 1;
    }

    /**
     * 根据属性值的限制条件产生值
     *
     * @param rule 限制条件
     * @return
     */
    @Override
    public Integer getValue(RuleBO rule) {

        if (rule.getMaxValue() != null && rule.getMinValue() != null && rule.getMaxValue().compareTo(rule.getMinValue()) > 0) {
            return UtilTool.getRandomInteger(rule.getMinValue().intValue(), rule.getMaxValue().intValue());
        }
        return getValue();
    }
}

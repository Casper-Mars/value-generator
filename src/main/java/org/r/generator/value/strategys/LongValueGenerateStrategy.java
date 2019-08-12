package org.r.generator.value.strategys;


import org.r.generator.value.beans.RuleBO;
import org.r.generator.value.tool.UtilTool;

public class LongValueGenerateStrategy implements ValueGenerateStrategy<Long> {
    /**
     * 生成值
     *
     * @return
     */
    @Override
    public Long getValue() {
        return UtilTool.getRandomLong();
    }

    /**
     * 根据属性名称生成值
     *
     * @param propertyName 属性名称
     * @return
     */
    @Override
    public Long getValue(String propertyName) {
        return null;
    }

    /**
     * 根据属性值的限制条件产生值
     *
     * @param rule 限制条件
     * @return
     */
    @Override
    public Long getValue(RuleBO rule) {
        return null;
    }
}

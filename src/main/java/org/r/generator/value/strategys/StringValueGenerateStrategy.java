package org.r.generator.value.strategys;


import org.r.generator.value.beans.RuleBO;
import org.r.generator.value.tool.StringUtilTool;

public class StringValueGenerateStrategy implements ValueGenerateStrategy<String> {


    /**
     * 生成值
     *
     * @return
     */
    @Override
    public String getValue() {

        return StringUtilTool.getRandomString(20);
    }

    /**
     * 根据属性名称生成值
     *
     * @param propertyName 属性名称
     * @return
     */
    @Override
    public String getValue(String propertyName) {
        return "";
    }


    /**
     * 根据属性值的限制条件产生值
     *
     * @param rule 限制条件
     * @return
     */
    @Override
    public String getValue(RuleBO rule) {
        if (StringUtilTool.isEmpty(rule.getPattern())) {
            return StringUtilTool.getRandomString(20);
        } else {
            return StringUtilTool.getRegString(rule.getPattern());
        }
    }
}

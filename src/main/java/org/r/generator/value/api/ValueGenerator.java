package org.r.generator.value.api;

import org.r.generator.value.beans.DataModelBO;
import org.r.generator.value.beans.RuleBO;
import org.r.generator.value.strategys.ValueGenerateStrategy;
import org.r.generator.value.strategys.ValueGenerateStrategyBuilder;

import java.util.HashMap;
import java.util.Map;

public class ValueGenerator {


    /**
     * 根据数据模型生成值，并填充到数据模型中
     *
     * @param model 数据模型
     */
    public Map<String,Object> getValue(DataModelBO model) {











        return new HashMap<>();
    }

    /**
     * 根据参数属性生成值
     *
     * @param propertyName 参数名
     * @param type         参数类型
     * @param rule         参数限制
     * @return
     */
    public Object getValue(String propertyName, String type, RuleBO rule) {

        ValueGenerateStrategy strategy = ValueGenerateStrategyBuilder.getStrategy(type);
        if (rule != null) {
            return strategy.getValue(rule);
        } else {
            return strategy.getValue();
        }
    }


}

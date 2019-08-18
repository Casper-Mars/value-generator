package org.r.generator.value.api;

import org.r.generator.value.beans.DataModelBO;
import org.r.generator.value.beans.RuleBO;
import org.r.generator.value.strategys.ValueGenerateStrategy;
import org.r.generator.value.strategys.ValueGenerateStrategyBuilder;
import org.r.generator.value.tool.CollectionTool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValueGenerator {


    /**
     * 根据数据模型生成值，并填充到数据模型中
     *
     * @param model 数据模型
     */
    public Map<String, Object> getValue(DataModelBO model) {
        Map<String, Object> result = new HashMap<>();
        if (model == null) {
            return result;
        }
        result.put(model.getName(), generateValue(model.getChildren()));
        return result;
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


    /**
     * 遍历数据模型产生值
     *
     * @param model 数据模型集合
     * @return
     */
    private Map<String, Object> generateValue(List<DataModelBO> model) {
        Map<String, Object> result = new HashMap<>();
        if (!CollectionTool.isEmpty(model)) {
            for (DataModelBO t : model) {
                List<DataModelBO> children = t.getChildren();
                if (CollectionTool.isNotEmpty(children)) {
                    result.put(t.getName(), generateValue(children));
                } else {
                    result.put(t.getName(), getValue(t.getName(), t.getType(), t.getRule()));
                }
            }
        }
        return result;
    }


}

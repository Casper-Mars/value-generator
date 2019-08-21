package org.r.generator.value.service;

import org.r.generator.value.beans.DataModelBO;
import org.r.generator.value.strategys.ValueGenerateStrategy;
import org.r.generator.value.strategys.ValueGenerateStrategyBuilder;
import org.r.generator.value.tool.CollectionTool;
import org.r.generator.value.tool.UtilTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateService {

    private static GenerateService generateService;

    public static GenerateService getInstance() {
        synchronized (GenerateService.class) {
            if (generateService == null) {
                generateService = new GenerateService();
            }
        }
        return generateService;
    }


    /**
     * 获取单个随机值
     *
     * @param modelBO 属性信息
     * @return
     */
    public Object getSingleValue(DataModelBO modelBO) {

        ValueGenerateStrategy strategy = ValueGenerateStrategyBuilder.getStrategy(modelBO.getType());
        if (strategy == null) {
            return null;
        }
        if (modelBO.isIgnore()) {
            return null;
        }
        if (!modelBO.isArray()) {
            return strategy.getValue(modelBO.getRule());
        } else {
            List<Object> tmp = new ArrayList<>();
            /*产生数组随机长度*/
            Integer randomLength = UtilTool.getRandomInteger(10, 20);
            for (int i = 0; i < randomLength; i++) {
                tmp.add(strategy.getValue(modelBO.getRule()));
            }
            return tmp;
        }
    }


    /**
     * 获取模型的随机值
     *
     * @param modelBO 模型信息
     * @return
     */
    public Object getValue(DataModelBO modelBO) {

        Object target = null;
        List<DataModelBO> children = modelBO.getChildren();
        if (CollectionTool.isEmpty(children)) {
            target = getSingleValue(modelBO);
        } else {
            if (modelBO.isArray()) {
                List<Object> tmp = new ArrayList<>();
                /*产生数组随机长度*/
                Integer randomLength = UtilTool.getRandomInteger(10, 20);
                for (int i = 0; i < randomLength; i++) {
                    tmp.add(getPojoValue(modelBO));
                }
                target = tmp;
            } else {
                target = getPojoValue(modelBO);
            }
        }
        return target;
    }

    private Object getPojoValue(DataModelBO modelBO) {
        List<DataModelBO> children = modelBO.getChildren();
        Map<String, Object> tmp = new HashMap<>();
        for (DataModelBO t : children) {
            tmp.put(t.getName(), getValue(t));
        }
        return tmp;
    }


}

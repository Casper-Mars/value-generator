package org.r.generator.value.api;

import org.r.generator.value.beans.RuleBO;
import org.r.generator.value.strategys.ValueGenerateStrategy;
import org.r.generator.value.strategys.ValueGenerateStrategyBuilder;

public class ValueGenerator {


    Object getValue(String propertyName, String type, RuleBO rule) {


        ValueGenerateStrategy strategy = ValueGenerateStrategyBuilder.getStrategy(type);
        System.out.println("hello world");

        return strategy.getValue(rule);
    }


}

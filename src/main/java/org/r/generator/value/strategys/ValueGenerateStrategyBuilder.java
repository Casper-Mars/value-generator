package org.r.generator.value.strategys;

import org.r.container.vue.service.strategys.ValueGenerateStrategy;

public class ValueGenerateStrategyBuilder {


    public static ValueGenerateStrategy getStrategy(String type) {

        ValueGenerateStrategy result = null;

        switch (type) {
            case "String":
                result = new StringValueGenerateStrategy();
                break;
            case "Integer":
                result = new IntegerValueGenerateStrategy();
                break;
            case "Long":
                result = new LongValueGenerateStrategy();
                break;
        }

        return result;
    }


}

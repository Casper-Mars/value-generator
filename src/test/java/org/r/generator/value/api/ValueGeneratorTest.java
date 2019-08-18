package org.r.generator.value.api;

import org.junit.Test;
import org.r.generator.value.beans.DataModelBO;
import org.r.generator.value.beans.RuleBO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ValueGeneratorTest {


    @Test
    public void getValue() {

        ValueGenerator valueGenerator = new ValueGenerator();
        Map<String, Object> value = valueGenerator.getValue(getDataModel());


    }


    private DataModelBO getDataModel() {

        DataModelBO target = new DataModelBO();
        target.setName("data");
        target.setType("Object");

        List<DataModelBO> children = new ArrayList<>();
        DataModelBO modelBO1 = new DataModelBO();
        modelBO1.setName("name");
        modelBO1.setType("String");
        modelBO1.setRule(RuleBO.builder().Pattern("([a-z]|[A-Z]){5,10}").build());
        children.add(modelBO1);

        DataModelBO modelBO2 = new DataModelBO();
        modelBO2.setName("age");
        modelBO2.setType("Integer");
        modelBO2.setRule(RuleBO.builder().maxValue(100).build());
        children.add(modelBO2);


        target.setChildren(children);
        return target;
    }


}
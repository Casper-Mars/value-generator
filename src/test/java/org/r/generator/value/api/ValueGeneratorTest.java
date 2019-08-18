package org.r.generator.value.api;

import org.junit.Assert;
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
        DataModelBO modelBO = getDataModel();
        Assert.assertNotNull("model is null",modelBO);
        Map<String, Object> value = valueGenerator.getValue(modelBO);

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

        DataModelBO modelBO3 = new DataModelBO();
        modelBO3.setName("amount");
        modelBO3.setType("BigDecimal");
        modelBO3.setRule(RuleBO.builder().maxValue(100).build());
        children.add(modelBO3);

        DataModelBO modelBO4 = new DataModelBO();
        modelBO4.setName("address");
        modelBO4.setType("AddressDTO");
        List<DataModelBO> children2 = new ArrayList<>();
        DataModelBO modelBO5 = new DataModelBO();
        modelBO5.setName("city");
        modelBO5.setType("String");
        modelBO5.setRule(RuleBO.builder().Pattern("([a-z]|[A-Z]){5,10}").build());
        children2.add(modelBO5);
        modelBO4.setChildren(children2);
        children.add(modelBO4);


        target.setChildren(children);
        return target;
    }


}
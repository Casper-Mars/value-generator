package org.r.generator.value.tool;

import java.util.Collection;

public class CollectionTool {


    public static boolean isEmpty(Collection target) {

        return target == null || target.size() == 0;
    }


    public static boolean isNotEmpty(Collection target) {
        return !isEmpty(target);
    }

}

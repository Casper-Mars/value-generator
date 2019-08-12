package org.r.generator.value.tool;

import com.mifmif.common.regex.Generex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringUtilTool {


    /**
     * 获取指定长度的随机字符串
     *
     * @param length 长度
     * @return
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }


    /**
     * 获取全部符合指定正则表达式的字符串，或者随机一个
     *
     * @param pattern 正则表达式
     * @return
     */
    private static List<String> getRegString0(String pattern, boolean randomOne) {
        List<String> result = new ArrayList<>();
        Generex generex = new Generex(pattern);
        if (randomOne) {
            result.add(generex.random());
        } else {
            result.addAll(generex.getAllMatchedStrings());
        }
        return result;
    }


    public static String getRegString(String pattern) {

        List<String> regString0 = getRegString0(pattern, true);
        return regString0.get(0);
    }

    /**
     * 获取指定个数的符合指定正则的字符串
     *
     * @param pattern 正则表达式
     * @param num     数量
     * @return
     */
    public static List<String> getRegStrings(String pattern, Integer num) {

        List<String> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            result.add(getRegString(pattern));
        }
        return result;
    }


    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}

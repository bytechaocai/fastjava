package com.bytechaocai.fastweb.core.util;

/**
 * 字符串工具。
 *
 * @author bytechaocai
 */
public class StrUtil {
    /**
     * 将下划线转换为小驼峰。
     *
     * @param str 原始名字
     *
     * @return 大驼峰名字。
     */
    public static String underlineToLowerCamel(String str) {
        str = str.toLowerCase();
        StringBuilder builder = new StringBuilder(str);
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '_') {
                builder.deleteCharAt(i);
                builder.replace(i, i + 1, String.valueOf(Character.toUpperCase(builder.charAt(i))));
            }
        }
        return builder.toString();
    }

    /**
     * 下划线转大驼峰。
     *
     * @param str 原始名字。
     *
     * @return 大驼峰名字。
     */
    public static String underlineToUpperCamel(String str) {
        String s = underlineToLowerCamel(str);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}

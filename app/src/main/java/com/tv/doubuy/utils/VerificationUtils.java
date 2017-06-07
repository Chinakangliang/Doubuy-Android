package com.tv.doubuy.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @Module : 工具类你
 * @Comments : 输入验证工具类
 * @Author : eric.chen
 * @CreateDate : 2016-10-29
 * @ModifiedBy : eric.chen
 * @ModifiedDate: 2016-10-29
 * @Modified:
 */
public class VerificationUtils {
    // 正则表达式：验证身份证
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * 验证手机号是否合法
     *
     * @param mobile
     * @return
     */
    public static boolean isPhoneLegal(String mobile) {
        Pattern p1 = Pattern.compile("^1[3|4|5|7|8][0-9]{9}$");
        Matcher m1 = p1.matcher(mobile);
        return m1.matches();
    }

    /**
     * 过滤特殊字符
     */
    public static String StringFilter(String str) throws PatternSyntaxException {
        String regEx = str.replaceAll("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……& amp;*（）——+|{}【】‘；：”“’。，、？|-]", "");
        return regEx.trim();
    }

    /**
     * 验证密码是否合法(数字+字母)
     *
     * @param password
     * @return
     */
    public static boolean isPasswordLegal(String password) {
        Pattern p1 = Pattern.compile("^([A-Za-z]|[0-9])+$");
        Matcher m1 = p1.matcher(password);
        return m1.matches();
    }

    /**
     * 校验身份证
     *
     * @param id
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String id) {
        return Pattern.matches(REGEX_ID_CARD, id);
    }

    /**
     * 校验银行卡卡号
     *
     * @param cardId
     * @return
     */
    public static boolean checkBankCard(String cardId) {
        char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
        if (bit == 'N') {
            return false;
        }
        return cardId.charAt(cardId.length() - 1) == bit;
    }

    /**
     * 检验文本是否合格
     *
     * @param content
     * @return
     */
    public static String checkContent(String content) {
        String regEx = "[^a-zA-Z0-9\u4E00-\u9FA5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(content);
        return m.replaceAll("").trim();
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     *
     * @param nonCheckCodeCardId
     * @return
     */
    public static char getBankCardCheckCode(String nonCheckCodeCardId) {
        if (nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }

    /**
     * 判断email格式是否正确
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isInputLegal(String code) {
        boolean isLegal = true;
        if (code.length() < 4) {
            isLegal = false;
        }
        return isLegal;
    }
}


package com.my.note.psninfodemo;

import com.my.note.mapper.Azx12Mapper;
import com.my.note.mapper.PsnInfoMapper;
import com.my.note.psninfodemo.dto.AgeRangeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 基本信息工具类
 *
 * @Author：勇敢牛牛
 * @Date：2024-12-21 15:32
 * @Description： 例如：常用的姓名、证件号码脱敏。姓名、证件号码合法性验证
 */
@Component
public class PsnInfoUtil {

    @Autowired
    private PsnInfoMapper psnInfoMapper;


    // 验证18位身份证号码的正则表达式
    private static final String REGEX_18_ID_CARD = "^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))((0[1-9])|(1[0-9])|(2[0-9])|(3[0-1]))\\d{3}[0-9Xx]$";

    // 验证15位身份证号码的正则表达式（旧版身份证，现在使用较少但可做兼容验证）
    private static final String REGEX_15_ID_CARD = "^[1-9]\\d{7}((0[1-9])|(1[0-2]))((0[1-9])|(1[0-9])|(2[0-9])|(3[0-1]))\\d{3}$";

    // 简单验证中文姓名的正则表达式，这里假设姓名由2 - 4个汉字组成（可按需调整范围）
    private static final String REGEX_CHINESE_NAME = "^[\u4e00-\u9fa5]{2,4}$";


    /**
     * 查询年龄分布区间数据，出参结构如下：
     * <p>
     * {
     * "axis": "20岁以下",
     * "manValue": 1,
     * "womenValue": 0
     * }
     * </p>
     *
     * @return
     */
    public List<AgeRangeDO> queryAgeRange() {
        return psnInfoMapper.queryAgeRange();
    }


    /**
     * 验证姓名是否符合简单中文姓名格式要求
     *
     * @param name 要验证的姓名
     * @return 如果符合格式要求返回true，否则返回false
     */
    public static boolean validateName(String name) {
        if (name == null) {
            return false;
        }
        return Pattern.matches(REGEX_CHINESE_NAME, name);
    }

    /**
     * 验证身份证号码是否合法
     *
     * @param idCard 要验证的身份证号码
     * @return 如果合法返回true，否则返回false
     */
    public static boolean validateIDCard(String idCard) {
        if (idCard == null) {
            return false;
        }
        if (idCard.length() == 18) {
            return Pattern.matches(REGEX_18_ID_CARD, idCard);
        } else if (idCard.length() == 15) {
            return Pattern.matches(REGEX_15_ID_CARD, idCard);
        }
        return false;
    }


    /**
     * 证件号码脱敏
     *
     * @param idCard
     * @return
     */
    public static String desensitizeIdCard(String idCard) {
        if (idCard == null || idCard.length() < 11) {
            return idCard;
        }
        // 保留前3位和后4位，中间用星号替换
        return idCard.substring(0, 3) +
                "****" +
                idCard.substring(idCard.length() - 4);
    }

    /**
     * 姓名脱敏
     *
     * @param fullName
     * @return
     */
    public static String desensitizeName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            return fullName;
        }
        int length = fullName.length();
        if (length == 1) {
            return fullName;
        }
        if (length == 2) {
            return fullName.charAt(0) + "*";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(fullName.charAt(0));
        for (int i = 1; i < length - 1; i++) {
            sb.append('*');
        }
        sb.append(fullName.charAt(length - 1));
        return sb.toString();
    }


}

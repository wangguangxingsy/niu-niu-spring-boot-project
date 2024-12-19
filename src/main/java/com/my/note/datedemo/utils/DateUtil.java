package com.my.note.datedemo.utils;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author：勇敢牛牛
 * @Date：2024-12-14 17:16
 * @Description：
 */
@Component
public class DateUtil {


    /**
     * 根据活动开始时间、结束时间来计算活动时长（单位：h）
     *
     * @param endDate
     * @param startDate
     * @return
     */
    public static double calculateDuration(Date startDate, Date endDate) {
        long diffInMillis = endDate.getTime() - startDate.getTime();
        double durationInSeconds = (double) diffInMillis / 1000;
        // 将秒数转换为小时数，保留一位小数
        double durationInHours = durationInSeconds / 3600;
        DecimalFormat df = new DecimalFormat("#.#");
        return Double.parseDouble(df.format(durationInHours));
    }

    /**
     * 根据日期排序倒叙
     *
     * @param dateStrList 字符串类型
     * @return
     */
    public static List<String> sortByStr(List<String> dateStrList) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        List<String> resList = dateStrList.stream().sorted(Comparator.comparing(dateStr -> {
            try {
                return sdf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
                return new java.util.Date(0);
            }
        })).collect(Collectors.toList());
        //默认是正序，如需要倒叙可反转list
        Collections.reverse(resList);
        return resList;
    }

    /**
     * 根据日期排序倒叙
     *
     * @param dateList 日期类型
     * @return
     */
    public static List<Date> sortByDate(List<Date> dateList) {
        //按照日期自然顺序排序（升序）
        return dateList.stream().sorted().collect(Collectors.toList());
    }
}

package com.my.note.threaddemo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.note.areacodedemo.dto.AreaCodeResDTO;
import com.my.note.areacodedemo.entity.Azx12;
import com.my.note.mapper.Azx12Mapper;
import com.my.note.threaddemo.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

/**
 * 多线程 实现类
 *
 * @Author：wangguangxing
 * @Date：2025-01-03 14:56
 * @Description：
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    private Azx12Mapper azx12Mapper;

    /**
     * 使用多线程查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    @Async("taskExecutor")
    public Future<List<AreaCodeResDTO>> queryAreaByThread(int pageNum, int pageSize) {
        try {
            //模拟接口查询耗时3秒
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String res = "[\n" +
                "        {\n" +
                "            \"value\": \"110000000000\",\n" +
                "            \"label\": \"北京市\",\n" +
                "            \"children\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"120000000000\",\n" +
                "            \"label\": \"天津市\",\n" +
                "            \"children\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"130000000000\",\n" +
                "            \"label\": \"河北省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"130500000000\",\n" +
                "                    \"label\": \"邢台市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130900000000\",\n" +
                "                    \"label\": \"沧州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130600000000\",\n" +
                "                    \"label\": \"保定市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130400000000\",\n" +
                "                    \"label\": \"邯郸市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130100000000\",\n" +
                "                    \"label\": \"石家庄市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130700000000\",\n" +
                "                    \"label\": \"张家口市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130300000000\",\n" +
                "                    \"label\": \"秦皇岛市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130800000000\",\n" +
                "                    \"label\": \"承德市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130200000000\",\n" +
                "                    \"label\": \"唐山市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"140000000000\",\n" +
                "            \"label\": \"山西省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"140400000000\",\n" +
                "                    \"label\": \"长治市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140900000000\",\n" +
                "                    \"label\": \"忻州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140800000000\",\n" +
                "                    \"label\": \"运城市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140500000000\",\n" +
                "                    \"label\": \"晋城市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140300000000\",\n" +
                "                    \"label\": \"阳泉市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140600000000\",\n" +
                "                    \"label\": \"朔州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140200000000\",\n" +
                "                    \"label\": \"大同市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140100000000\",\n" +
                "                    \"label\": \"太原市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140700000000\",\n" +
                "                    \"label\": \"晋中市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"150000000000\",\n" +
                "            \"label\": \"内蒙古自治区\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"150800000000\",\n" +
                "                    \"label\": \"巴彦淖尔市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150700000000\",\n" +
                "                    \"label\": \"呼伦贝尔市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150400000000\",\n" +
                "                    \"label\": \"赤峰市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150200000000\",\n" +
                "                    \"label\": \"包头市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150500000000\",\n" +
                "                    \"label\": \"通辽市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150100000000\",\n" +
                "                    \"label\": \"呼和浩特市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150900000000\",\n" +
                "                    \"label\": \"乌兰察布市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150600000000\",\n" +
                "                    \"label\": \"鄂尔多斯市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150300000000\",\n" +
                "                    \"label\": \"乌海市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"210000000000\",\n" +
                "            \"label\": \"辽宁省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"210600000000\",\n" +
                "                    \"label\": \"丹东市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210200000000\",\n" +
                "                    \"label\": \"大连市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210300000000\",\n" +
                "                    \"label\": \"鞍山市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210400000000\",\n" +
                "                    \"label\": \"抚顺市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210900000000\",\n" +
                "                    \"label\": \"阜新市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210800000000\",\n" +
                "                    \"label\": \"营口市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210500000000\",\n" +
                "                    \"label\": \"本溪市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210700000000\",\n" +
                "                    \"label\": \"锦州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210100000000\",\n" +
                "                    \"label\": \"沈阳市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"220000000000\",\n" +
                "            \"label\": \"吉林省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"220500000000\",\n" +
                "                    \"label\": \"通化市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"220100000000\",\n" +
                "                    \"label\": \"长春市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"220400000000\",\n" +
                "                    \"label\": \"辽源市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"220200000000\",\n" +
                "                    \"label\": \"吉林市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"220300000000\",\n" +
                "                    \"label\": \"四平市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"220800000000\",\n" +
                "                    \"label\": \"白城市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"220700000000\",\n" +
                "                    \"label\": \"松原市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"220600000000\",\n" +
                "                    \"label\": \"白山市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"230000000000\",\n" +
                "            \"label\": \"黑龙江省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"230900000000\",\n" +
                "                    \"label\": \"七台河市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230400000000\",\n" +
                "                    \"label\": \"鹤岗市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230300000000\",\n" +
                "                    \"label\": \"鸡西市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230100000000\",\n" +
                "                    \"label\": \"哈尔滨市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230200000000\",\n" +
                "                    \"label\": \"齐齐哈尔市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230700000000\",\n" +
                "                    \"label\": \"伊春市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230600000000\",\n" +
                "                    \"label\": \"大庆市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230800000000\",\n" +
                "                    \"label\": \"佳木斯市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230500000000\",\n" +
                "                    \"label\": \"双鸭山市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"310000000000\",\n" +
                "            \"label\": \"上海市\",\n" +
                "            \"children\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"320000000000\",\n" +
                "            \"label\": \"江苏省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"320500000000\",\n" +
                "                    \"label\": \"苏州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320400000000\",\n" +
                "                    \"label\": \"常州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320800000000\",\n" +
                "                    \"label\": \"淮安市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320100000000\",\n" +
                "                    \"label\": \"南京市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320700000000\",\n" +
                "                    \"label\": \"连云港市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320200000000\",\n" +
                "                    \"label\": \"无锡市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320900000000\",\n" +
                "                    \"label\": \"盐城市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320600000000\",\n" +
                "                    \"label\": \"南通市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320300000000\",\n" +
                "                    \"label\": \"徐州市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"330000000000\",\n" +
                "            \"label\": \"浙江省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"330800000000\",\n" +
                "                    \"label\": \"衢州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330400000000\",\n" +
                "                    \"label\": \"嘉兴市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330300000000\",\n" +
                "                    \"label\": \"温州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330700000000\",\n" +
                "                    \"label\": \"金华市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330900000000\",\n" +
                "                    \"label\": \"舟山市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330100000000\",\n" +
                "                    \"label\": \"杭州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330600000000\",\n" +
                "                    \"label\": \"绍兴市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330500000000\",\n" +
                "                    \"label\": \"湖州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330200000000\",\n" +
                "                    \"label\": \"宁波市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"340000000000\",\n" +
                "            \"label\": \"安徽省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"340700000000\",\n" +
                "                    \"label\": \"铜陵市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"340200000000\",\n" +
                "                    \"label\": \"芜湖市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"340300000000\",\n" +
                "                    \"label\": \"蚌埠市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"340600000000\",\n" +
                "                    \"label\": \"淮北市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"340800000000\",\n" +
                "                    \"label\": \"安庆市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"340500000000\",\n" +
                "                    \"label\": \"马鞍山市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"340400000000\",\n" +
                "                    \"label\": \"淮南市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"340100000000\",\n" +
                "                    \"label\": \"合肥市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"350000000000\",\n" +
                "            \"label\": \"福建省\",\n" +
                "            \"children\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"360000000000\",\n" +
                "            \"label\": \"江西省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"360500000000\",\n" +
                "                    \"label\": \"新余市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360400000000\",\n" +
                "                    \"label\": \"九江市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360100000000\",\n" +
                "                    \"label\": \"南昌市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360600000000\",\n" +
                "                    \"label\": \"鹰潭市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360900000000\",\n" +
                "                    \"label\": \"宜春市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360300000000\",\n" +
                "                    \"label\": \"萍乡市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360700000000\",\n" +
                "                    \"label\": \"赣州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360800000000\",\n" +
                "                    \"label\": \"吉安市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360200000000\",\n" +
                "                    \"label\": \"景德镇市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"370000000000\",\n" +
                "            \"label\": \"山东省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"370400000000\",\n" +
                "                    \"label\": \"枣庄市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370900000000\",\n" +
                "                    \"label\": \"泰安市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370300000000\",\n" +
                "                    \"label\": \"淄博市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370500000000\",\n" +
                "                    \"label\": \"东营市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370800000000\",\n" +
                "                    \"label\": \"济宁市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370200000000\",\n" +
                "                    \"label\": \"青岛市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370600000000\",\n" +
                "                    \"label\": \"烟台市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370700000000\",\n" +
                "                    \"label\": \"潍坊市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370100000000\",\n" +
                "                    \"label\": \"济南市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"410000000000\",\n" +
                "            \"label\": \"河南省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"410500000000\",\n" +
                "                    \"label\": \"安阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410900000000\",\n" +
                "                    \"label\": \"濮阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410600000000\",\n" +
                "                    \"label\": \"鹤壁市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410800000000\",\n" +
                "                    \"label\": \"焦作市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410300000000\",\n" +
                "                    \"label\": \"洛阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410200000000\",\n" +
                "                    \"label\": \"开封市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410700000000\",\n" +
                "                    \"label\": \"新乡市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410400000000\",\n" +
                "                    \"label\": \"平顶山市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410100000000\",\n" +
                "                    \"label\": \"郑州市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"420000000000\",\n" +
                "            \"label\": \"湖北省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"420800000000\",\n" +
                "                    \"label\": \"荆门市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"420500000000\",\n" +
                "                    \"label\": \"宜昌市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"420700000000\",\n" +
                "                    \"label\": \"鄂州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"420600000000\",\n" +
                "                    \"label\": \"襄樊市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"420100000000\",\n" +
                "                    \"label\": \"武汉市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"420200000000\",\n" +
                "                    \"label\": \"黄石市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"420900000000\",\n" +
                "                    \"label\": \"孝感市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"420300000000\",\n" +
                "                    \"label\": \"十堰市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"430000000000\",\n" +
                "            \"label\": \"湖南省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"430300000000\",\n" +
                "                    \"label\": \"湘潭市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430700000000\",\n" +
                "                    \"label\": \"常德市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430600000000\",\n" +
                "                    \"label\": \"岳阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430900000000\",\n" +
                "                    \"label\": \"益阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430500000000\",\n" +
                "                    \"label\": \"邵阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430100000000\",\n" +
                "                    \"label\": \"长沙市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430400000000\",\n" +
                "                    \"label\": \"衡阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430800000000\",\n" +
                "                    \"label\": \"张家界市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430200000000\",\n" +
                "                    \"label\": \"株洲市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"440000000000\",\n" +
                "            \"label\": \"广东省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"440200000000\",\n" +
                "                    \"label\": \"韶关市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440600000000\",\n" +
                "                    \"label\": \"佛山市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440500000000\",\n" +
                "                    \"label\": \"汕头市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440800000000\",\n" +
                "                    \"label\": \"湛江市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440400000000\",\n" +
                "                    \"label\": \"珠海市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440900000000\",\n" +
                "                    \"label\": \"茂名市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440300000000\",\n" +
                "                    \"label\": \"深圳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440700000000\",\n" +
                "                    \"label\": \"江门市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440100000000\",\n" +
                "                    \"label\": \"广州市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"450000000000\",\n" +
                "            \"label\": \"广西壮族自治区\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"450500000000\",\n" +
                "                    \"label\": \"北海市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450400000000\",\n" +
                "                    \"label\": \"梧州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450700000000\",\n" +
                "                    \"label\": \"钦州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450100000000\",\n" +
                "                    \"label\": \"南宁市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450300000000\",\n" +
                "                    \"label\": \"桂林市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450800000000\",\n" +
                "                    \"label\": \"贵港市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450200000000\",\n" +
                "                    \"label\": \"柳州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450900000000\",\n" +
                "                    \"label\": \"玉林市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450600000000\",\n" +
                "                    \"label\": \"防城港市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"460000000000\",\n" +
                "            \"label\": \"海南省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"460100000000\",\n" +
                "                    \"label\": \"海口市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"500000000000\",\n" +
                "            \"label\": \"重庆市\",\n" +
                "            \"children\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"510000000000\",\n" +
                "            \"label\": \"四川省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"510400000000\",\n" +
                "                    \"label\": \"攀枝花市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"510900000000\",\n" +
                "                    \"label\": \"遂宁市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"510300000000\",\n" +
                "                    \"label\": \"自贡市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"510500000000\",\n" +
                "                    \"label\": \"泸州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"510800000000\",\n" +
                "                    \"label\": \"广元市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"510600000000\",\n" +
                "                    \"label\": \"德阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"510700000000\",\n" +
                "                    \"label\": \"绵阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"510100000000\",\n" +
                "                    \"label\": \"成都市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"520000000000\",\n" +
                "            \"label\": \"贵州省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"520300000000\",\n" +
                "                    \"label\": \"遵义市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"520200000000\",\n" +
                "                    \"label\": \"六盘水市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"520400000000\",\n" +
                "                    \"label\": \"安顺市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"520100000000\",\n" +
                "                    \"label\": \"贵阳市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"530000000000\",\n" +
                "            \"label\": \"云南省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"530700000000\",\n" +
                "                    \"label\": \"丽江市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"530100000000\",\n" +
                "                    \"label\": \"昆明市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"530300000000\",\n" +
                "                    \"label\": \"曲靖市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"530600000000\",\n" +
                "                    \"label\": \"昭通市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"530900000000\",\n" +
                "                    \"label\": \"临沧市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"530400000000\",\n" +
                "                    \"label\": \"玉溪市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"530800000000\",\n" +
                "                    \"label\": \"普洱市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"530500000000\",\n" +
                "                    \"label\": \"保山市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"540000000000\",\n" +
                "            \"label\": \"西藏自治区\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"540100000000\",\n" +
                "                    \"label\": \"拉萨市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"610000000000\",\n" +
                "            \"label\": \"陕西省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"610800000000\",\n" +
                "                    \"label\": \"榆林市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610300000000\",\n" +
                "                    \"label\": \"宝鸡市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610200000000\",\n" +
                "                    \"label\": \"铜川市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610500000000\",\n" +
                "                    \"label\": \"渭南市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610100000000\",\n" +
                "                    \"label\": \"西安市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610600000000\",\n" +
                "                    \"label\": \"延安市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610900000000\",\n" +
                "                    \"label\": \"安康市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610700000000\",\n" +
                "                    \"label\": \"汉中市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610400000000\",\n" +
                "                    \"label\": \"咸阳市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"620000000000\",\n" +
                "            \"label\": \"甘肃省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"620700000000\",\n" +
                "                    \"label\": \"张掖市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"620100000000\",\n" +
                "                    \"label\": \"兰州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"620400000000\",\n" +
                "                    \"label\": \"白银市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"620900000000\",\n" +
                "                    \"label\": \"酒泉市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"620500000000\",\n" +
                "                    \"label\": \"天水市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"620800000000\",\n" +
                "                    \"label\": \"平凉市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"620600000000\",\n" +
                "                    \"label\": \"武威市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"620300000000\",\n" +
                "                    \"label\": \"金昌市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"630000000000\",\n" +
                "            \"label\": \"青海省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"630100000000\",\n" +
                "                    \"label\": \"西宁市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"640000000000\",\n" +
                "            \"label\": \"宁夏回族自治区\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"640400000000\",\n" +
                "                    \"label\": \"固原市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"640500000000\",\n" +
                "                    \"label\": \"中卫市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"640200000000\",\n" +
                "                    \"label\": \"石嘴山市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"640300000000\",\n" +
                "                    \"label\": \"吴忠市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"640100000000\",\n" +
                "                    \"label\": \"银川市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"650000000000\",\n" +
                "            \"label\": \"新疆维吾尔自治区\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"650100000000\",\n" +
                "                    \"label\": \"乌鲁木齐市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"650200000000\",\n" +
                "                    \"label\": \"克拉玛依市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<AreaCodeResDTO> list = mapper.readValue(res, List.class);
            return new AsyncResult<>(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 不使用多线程
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<AreaCodeResDTO> queryArea(int pageNum, int pageSize) {
        try {
            //模拟接口查询耗时3秒
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String res = "[\n" +
                "        {\n" +
                "            \"value\": \"110000000000\",\n" +
                "            \"label\": \"北京市\",\n" +
                "            \"children\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"120000000000\",\n" +
                "            \"label\": \"天津市\",\n" +
                "            \"children\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"130000000000\",\n" +
                "            \"label\": \"河北省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"130500000000\",\n" +
                "                    \"label\": \"邢台市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130900000000\",\n" +
                "                    \"label\": \"沧州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130600000000\",\n" +
                "                    \"label\": \"保定市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130400000000\",\n" +
                "                    \"label\": \"邯郸市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130100000000\",\n" +
                "                    \"label\": \"石家庄市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130700000000\",\n" +
                "                    \"label\": \"张家口市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130300000000\",\n" +
                "                    \"label\": \"秦皇岛市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130800000000\",\n" +
                "                    \"label\": \"承德市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"130200000000\",\n" +
                "                    \"label\": \"唐山市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"140000000000\",\n" +
                "            \"label\": \"山西省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"140400000000\",\n" +
                "                    \"label\": \"长治市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140900000000\",\n" +
                "                    \"label\": \"忻州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140800000000\",\n" +
                "                    \"label\": \"运城市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140500000000\",\n" +
                "                    \"label\": \"晋城市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140300000000\",\n" +
                "                    \"label\": \"阳泉市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140600000000\",\n" +
                "                    \"label\": \"朔州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140200000000\",\n" +
                "                    \"label\": \"大同市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140100000000\",\n" +
                "                    \"label\": \"太原市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"140700000000\",\n" +
                "                    \"label\": \"晋中市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"150000000000\",\n" +
                "            \"label\": \"内蒙古自治区\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"150800000000\",\n" +
                "                    \"label\": \"巴彦淖尔市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150700000000\",\n" +
                "                    \"label\": \"呼伦贝尔市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150400000000\",\n" +
                "                    \"label\": \"赤峰市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150200000000\",\n" +
                "                    \"label\": \"包头市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150500000000\",\n" +
                "                    \"label\": \"通辽市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150100000000\",\n" +
                "                    \"label\": \"呼和浩特市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150900000000\",\n" +
                "                    \"label\": \"乌兰察布市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150600000000\",\n" +
                "                    \"label\": \"鄂尔多斯市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"150300000000\",\n" +
                "                    \"label\": \"乌海市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"210000000000\",\n" +
                "            \"label\": \"辽宁省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"210600000000\",\n" +
                "                    \"label\": \"丹东市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210200000000\",\n" +
                "                    \"label\": \"大连市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210300000000\",\n" +
                "                    \"label\": \"鞍山市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210400000000\",\n" +
                "                    \"label\": \"抚顺市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210900000000\",\n" +
                "                    \"label\": \"阜新市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210800000000\",\n" +
                "                    \"label\": \"营口市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210500000000\",\n" +
                "                    \"label\": \"本溪市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210700000000\",\n" +
                "                    \"label\": \"锦州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"210100000000\",\n" +
                "                    \"label\": \"沈阳市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"220000000000\",\n" +
                "            \"label\": \"吉林省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"220500000000\",\n" +
                "                    \"label\": \"通化市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"220100000000\",\n" +
                "                    \"label\": \"长春市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"220400000000\",\n" +
                "                    \"label\": \"辽源市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"220200000000\",\n" +
                "                    \"label\": \"吉林市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"220300000000\",\n" +
                "                    \"label\": \"四平市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"220800000000\",\n" +
                "                    \"label\": \"白城市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"220700000000\",\n" +
                "                    \"label\": \"松原市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"220600000000\",\n" +
                "                    \"label\": \"白山市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"230000000000\",\n" +
                "            \"label\": \"黑龙江省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"230900000000\",\n" +
                "                    \"label\": \"七台河市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230400000000\",\n" +
                "                    \"label\": \"鹤岗市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230300000000\",\n" +
                "                    \"label\": \"鸡西市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230100000000\",\n" +
                "                    \"label\": \"哈尔滨市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230200000000\",\n" +
                "                    \"label\": \"齐齐哈尔市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230700000000\",\n" +
                "                    \"label\": \"伊春市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230600000000\",\n" +
                "                    \"label\": \"大庆市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230800000000\",\n" +
                "                    \"label\": \"佳木斯市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"230500000000\",\n" +
                "                    \"label\": \"双鸭山市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"310000000000\",\n" +
                "            \"label\": \"上海市\",\n" +
                "            \"children\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"320000000000\",\n" +
                "            \"label\": \"江苏省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"320500000000\",\n" +
                "                    \"label\": \"苏州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320400000000\",\n" +
                "                    \"label\": \"常州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320800000000\",\n" +
                "                    \"label\": \"淮安市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320100000000\",\n" +
                "                    \"label\": \"南京市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320700000000\",\n" +
                "                    \"label\": \"连云港市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320200000000\",\n" +
                "                    \"label\": \"无锡市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320900000000\",\n" +
                "                    \"label\": \"盐城市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320600000000\",\n" +
                "                    \"label\": \"南通市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"320300000000\",\n" +
                "                    \"label\": \"徐州市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"330000000000\",\n" +
                "            \"label\": \"浙江省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"330800000000\",\n" +
                "                    \"label\": \"衢州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330400000000\",\n" +
                "                    \"label\": \"嘉兴市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330300000000\",\n" +
                "                    \"label\": \"温州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330700000000\",\n" +
                "                    \"label\": \"金华市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330900000000\",\n" +
                "                    \"label\": \"舟山市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330100000000\",\n" +
                "                    \"label\": \"杭州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330600000000\",\n" +
                "                    \"label\": \"绍兴市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330500000000\",\n" +
                "                    \"label\": \"湖州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"330200000000\",\n" +
                "                    \"label\": \"宁波市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"340000000000\",\n" +
                "            \"label\": \"安徽省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"340700000000\",\n" +
                "                    \"label\": \"铜陵市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"340200000000\",\n" +
                "                    \"label\": \"芜湖市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"340300000000\",\n" +
                "                    \"label\": \"蚌埠市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"340600000000\",\n" +
                "                    \"label\": \"淮北市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"340800000000\",\n" +
                "                    \"label\": \"安庆市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"340500000000\",\n" +
                "                    \"label\": \"马鞍山市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"340400000000\",\n" +
                "                    \"label\": \"淮南市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"340100000000\",\n" +
                "                    \"label\": \"合肥市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"350000000000\",\n" +
                "            \"label\": \"福建省\",\n" +
                "            \"children\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"360000000000\",\n" +
                "            \"label\": \"江西省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"360500000000\",\n" +
                "                    \"label\": \"新余市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360400000000\",\n" +
                "                    \"label\": \"九江市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360100000000\",\n" +
                "                    \"label\": \"南昌市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360600000000\",\n" +
                "                    \"label\": \"鹰潭市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360900000000\",\n" +
                "                    \"label\": \"宜春市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360300000000\",\n" +
                "                    \"label\": \"萍乡市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360700000000\",\n" +
                "                    \"label\": \"赣州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360800000000\",\n" +
                "                    \"label\": \"吉安市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"360200000000\",\n" +
                "                    \"label\": \"景德镇市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"370000000000\",\n" +
                "            \"label\": \"山东省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"370400000000\",\n" +
                "                    \"label\": \"枣庄市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370900000000\",\n" +
                "                    \"label\": \"泰安市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370300000000\",\n" +
                "                    \"label\": \"淄博市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370500000000\",\n" +
                "                    \"label\": \"东营市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370800000000\",\n" +
                "                    \"label\": \"济宁市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370200000000\",\n" +
                "                    \"label\": \"青岛市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370600000000\",\n" +
                "                    \"label\": \"烟台市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370700000000\",\n" +
                "                    \"label\": \"潍坊市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"370100000000\",\n" +
                "                    \"label\": \"济南市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"410000000000\",\n" +
                "            \"label\": \"河南省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"410500000000\",\n" +
                "                    \"label\": \"安阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410900000000\",\n" +
                "                    \"label\": \"濮阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410600000000\",\n" +
                "                    \"label\": \"鹤壁市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410800000000\",\n" +
                "                    \"label\": \"焦作市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410300000000\",\n" +
                "                    \"label\": \"洛阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410200000000\",\n" +
                "                    \"label\": \"开封市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410700000000\",\n" +
                "                    \"label\": \"新乡市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410400000000\",\n" +
                "                    \"label\": \"平顶山市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"410100000000\",\n" +
                "                    \"label\": \"郑州市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"420000000000\",\n" +
                "            \"label\": \"湖北省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"420800000000\",\n" +
                "                    \"label\": \"荆门市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"420500000000\",\n" +
                "                    \"label\": \"宜昌市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"420700000000\",\n" +
                "                    \"label\": \"鄂州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"420600000000\",\n" +
                "                    \"label\": \"襄樊市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"420100000000\",\n" +
                "                    \"label\": \"武汉市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"420200000000\",\n" +
                "                    \"label\": \"黄石市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"420900000000\",\n" +
                "                    \"label\": \"孝感市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"420300000000\",\n" +
                "                    \"label\": \"十堰市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"430000000000\",\n" +
                "            \"label\": \"湖南省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"430300000000\",\n" +
                "                    \"label\": \"湘潭市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430700000000\",\n" +
                "                    \"label\": \"常德市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430600000000\",\n" +
                "                    \"label\": \"岳阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430900000000\",\n" +
                "                    \"label\": \"益阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430500000000\",\n" +
                "                    \"label\": \"邵阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430100000000\",\n" +
                "                    \"label\": \"长沙市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430400000000\",\n" +
                "                    \"label\": \"衡阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430800000000\",\n" +
                "                    \"label\": \"张家界市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"430200000000\",\n" +
                "                    \"label\": \"株洲市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"440000000000\",\n" +
                "            \"label\": \"广东省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"440200000000\",\n" +
                "                    \"label\": \"韶关市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440600000000\",\n" +
                "                    \"label\": \"佛山市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440500000000\",\n" +
                "                    \"label\": \"汕头市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440800000000\",\n" +
                "                    \"label\": \"湛江市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440400000000\",\n" +
                "                    \"label\": \"珠海市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440900000000\",\n" +
                "                    \"label\": \"茂名市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440300000000\",\n" +
                "                    \"label\": \"深圳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440700000000\",\n" +
                "                    \"label\": \"江门市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"440100000000\",\n" +
                "                    \"label\": \"广州市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"450000000000\",\n" +
                "            \"label\": \"广西壮族自治区\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"450500000000\",\n" +
                "                    \"label\": \"北海市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450400000000\",\n" +
                "                    \"label\": \"梧州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450700000000\",\n" +
                "                    \"label\": \"钦州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450100000000\",\n" +
                "                    \"label\": \"南宁市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450300000000\",\n" +
                "                    \"label\": \"桂林市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450800000000\",\n" +
                "                    \"label\": \"贵港市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450200000000\",\n" +
                "                    \"label\": \"柳州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450900000000\",\n" +
                "                    \"label\": \"玉林市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"450600000000\",\n" +
                "                    \"label\": \"防城港市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"460000000000\",\n" +
                "            \"label\": \"海南省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"460100000000\",\n" +
                "                    \"label\": \"海口市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"500000000000\",\n" +
                "            \"label\": \"重庆市\",\n" +
                "            \"children\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"510000000000\",\n" +
                "            \"label\": \"四川省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"510400000000\",\n" +
                "                    \"label\": \"攀枝花市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"510900000000\",\n" +
                "                    \"label\": \"遂宁市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"510300000000\",\n" +
                "                    \"label\": \"自贡市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"510500000000\",\n" +
                "                    \"label\": \"泸州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"510800000000\",\n" +
                "                    \"label\": \"广元市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"510600000000\",\n" +
                "                    \"label\": \"德阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"510700000000\",\n" +
                "                    \"label\": \"绵阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"510100000000\",\n" +
                "                    \"label\": \"成都市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"520000000000\",\n" +
                "            \"label\": \"贵州省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"520300000000\",\n" +
                "                    \"label\": \"遵义市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"520200000000\",\n" +
                "                    \"label\": \"六盘水市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"520400000000\",\n" +
                "                    \"label\": \"安顺市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"520100000000\",\n" +
                "                    \"label\": \"贵阳市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"530000000000\",\n" +
                "            \"label\": \"云南省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"530700000000\",\n" +
                "                    \"label\": \"丽江市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"530100000000\",\n" +
                "                    \"label\": \"昆明市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"530300000000\",\n" +
                "                    \"label\": \"曲靖市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"530600000000\",\n" +
                "                    \"label\": \"昭通市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"530900000000\",\n" +
                "                    \"label\": \"临沧市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"530400000000\",\n" +
                "                    \"label\": \"玉溪市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"530800000000\",\n" +
                "                    \"label\": \"普洱市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"530500000000\",\n" +
                "                    \"label\": \"保山市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"540000000000\",\n" +
                "            \"label\": \"西藏自治区\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"540100000000\",\n" +
                "                    \"label\": \"拉萨市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"610000000000\",\n" +
                "            \"label\": \"陕西省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"610800000000\",\n" +
                "                    \"label\": \"榆林市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610300000000\",\n" +
                "                    \"label\": \"宝鸡市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610200000000\",\n" +
                "                    \"label\": \"铜川市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610500000000\",\n" +
                "                    \"label\": \"渭南市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610100000000\",\n" +
                "                    \"label\": \"西安市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610600000000\",\n" +
                "                    \"label\": \"延安市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610900000000\",\n" +
                "                    \"label\": \"安康市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610700000000\",\n" +
                "                    \"label\": \"汉中市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"610400000000\",\n" +
                "                    \"label\": \"咸阳市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"620000000000\",\n" +
                "            \"label\": \"甘肃省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"620700000000\",\n" +
                "                    \"label\": \"张掖市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"620100000000\",\n" +
                "                    \"label\": \"兰州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"620400000000\",\n" +
                "                    \"label\": \"白银市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"620900000000\",\n" +
                "                    \"label\": \"酒泉市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"620500000000\",\n" +
                "                    \"label\": \"天水市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"620800000000\",\n" +
                "                    \"label\": \"平凉市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"620600000000\",\n" +
                "                    \"label\": \"武威市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"620300000000\",\n" +
                "                    \"label\": \"金昌市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"630000000000\",\n" +
                "            \"label\": \"青海省\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"630100000000\",\n" +
                "                    \"label\": \"西宁市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"640000000000\",\n" +
                "            \"label\": \"宁夏回族自治区\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"640400000000\",\n" +
                "                    \"label\": \"固原市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"640500000000\",\n" +
                "                    \"label\": \"中卫市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"640200000000\",\n" +
                "                    \"label\": \"石嘴山市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"640300000000\",\n" +
                "                    \"label\": \"吴忠市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"640100000000\",\n" +
                "                    \"label\": \"银川市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"650000000000\",\n" +
                "            \"label\": \"新疆维吾尔自治区\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"value\": \"650100000000\",\n" +
                "                    \"label\": \"乌鲁木齐市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"value\": \"650200000000\",\n" +
                "                    \"label\": \"克拉玛依市\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<AreaCodeResDTO> list = mapper.readValue(res, List.class);
            return list;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 推送到数据库
     *
     * @param
     */
    @Override
    public void pushData(List<Azx12> list, int start, int end) {
        for (int i = start; i < end; i++) {
            insert(list.get(i));
        }
    }

    /**
     * 异步多线程保存
     *
     * @param azx12
     */
    @Async("taskExecutor")
    public void insert(Azx12 azx12) {
        azx12Mapper.insert(azx12);
    }
}

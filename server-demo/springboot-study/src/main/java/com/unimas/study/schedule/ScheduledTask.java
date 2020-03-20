package com.unimas.study.schedule;/**
 * Created by 50204 on 2020/3/19.
 */

import com.unimas.study.config.MysqlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName ScheduledTask
 * @Description TODO
 * @Author 50204
 * @Date 2020/3/19 23:14
 * @Version 1.0
 **/
@Component
public class ScheduledTask {

    @Autowired
    private MysqlConfig mysqlConfig;

    /**
     * 定时方法,  1秒的频率
     */
    @Scheduled(fixedRate = 1000)
    public void testSchedule(){
        System.out.println(" 定时方法------》 正在执行。。。  , 动态注入配置的实体类属性为： " +  mysqlConfig );
    }
    
}

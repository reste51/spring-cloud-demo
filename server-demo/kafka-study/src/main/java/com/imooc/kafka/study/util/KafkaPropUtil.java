package com.imooc.kafka.study.util;

import java.util.Properties;

/**
 * kafka的配置
 * @ClassName KafkaUtil
 * @Description TODO
 * @Author DELL
 * @Date 2020/5/17 12:25
 * @Version 1.0
 **/
public class KafkaPropUtil {

    /**
     * 获取 kafka 的通用配置
     * @return
     */
    public static Properties getCommonProp() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.136.128:9092");
        props.put("acks", "all");       //判定是否成功发送，“all”会阻塞，性能低但可靠
        props.put("retries", 0);        //失败重试次数
        props.put("batch.size", 16384);//缓存区的大小，每个"活跃"的分区有一个缓存区
        /*
            消息延迟时间，单位毫秒，小于这个时间的消息组成批一次请求就发送过去，
            在高负载情况下时间间隔太近的也会组成批发送
            不再高负载下可以时间大点，以时间换有效的请求
        */
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);//缓存的总量，大于这个数就会阻塞
        //key和value 序列化 转成字节
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

    /**
     *  获取偏移量的kafka
     * @return
     */
    public static Properties getOffsetProp() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.240.128:9092");
        props.put("group.id", "test");   //消费者组 ，不能不写，这个不一定和9092的消费者的group.id对应，随便写的
        props.put("enable.auto.commit", "true"); //自动提交偏移量为true，不自动提交则为false
        props.put("auto.commit.interval.ms", "1000");//自动提交的频率，一秒一次
        props.put("session.timeout.ms", "30000");//停止心跳时间超过30s，就认为有故障
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }

}

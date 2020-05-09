package com.imooc.kafka.study;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * kafka的生产者
 *
 * linux 命令为： bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
 * @ClassName MyProducer
 * @Description TODO
 * @Author DELL
 * @Date 2020/5/8 22:20
 * @Version 1.0
 **/
public class MyProducer {
    // 发送消息
    private static KafkaProducer<String,String> producer;

    // 设置配置 
    static {
        Properties properties = new Properties();
        // broker list 的服务
        properties.put("bootstrap.servers","192.168.240.128:9092");
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<String, String>(properties);
    }

    // 1.发送消息_ 只发送不管结果
    private static void  sendMessageForgetResult(){
        ProducerRecord<String,String> record = new ProducerRecord<String, String>("test3","name","ForgetResult");
        producer.send(record);
        producer.close();
    }

    public static void main(String[] args) {
        sendMessageForgetResult();
    }

}

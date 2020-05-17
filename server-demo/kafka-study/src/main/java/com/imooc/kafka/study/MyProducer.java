package com.imooc.kafka.study;

import com.imooc.kafka.study.util.KafkaPropUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
        ProducerRecord<String,String> record = new ProducerRecord<String, String>("cs111","name","ForgetResult");
        producer.send(record);
        producer.close();
    }
    /*
        2. 非阻塞方式 发送
        注: 阻塞的时， 打印数字是 有顺序的， 而异步则是  无顺序的
      */
    private static void  sendMsgWithNonblocking(){
        Producer<String, String> producer = new KafkaProducer<>(KafkaPropUtil.getProperties());
        for(int i = 0; i < 100; i++) {
            //异步，添加消息到缓存区，等待到一定程度把这些消息一起发送到集群
            producer.send(new ProducerRecord<String, String>("cs111",  Integer.toString(i)));
        }
        producer.close();  //关闭生产者，不关闭为造成还没发送过去的消息发生泄漏
    }

    /*
        3. 有返回值的阻塞
        接收了返回值他还是非阻塞的，Future调用了get()方法是就成阻塞的了，  直到相关请求完成返回RecordMetadata 或者抛出异常
        可以自己试试，当把第二行注释起来很快，放开就会速度慢下来
        注: 阻塞的时， 打印数字是 有顺序的， 而异步则是  无顺序的
     */
    public static  void  sendMsgWithResult() throws ExecutionException, InterruptedException {
        Producer<String, String> producer = new KafkaProducer<>(KafkaPropUtil.getProperties());

        for(int i = 0; i < 100; i++) {
            //异步，添加消息到缓存区，等待到一定程度把这些消息一起发送到集群
            Future<RecordMetadata> frm = producer.send(new ProducerRecord<String, String>("cs111",  Integer.toString(i)+"：is Blocking!"));
            RecordMetadata rm = frm.get();
            System.out.println(String.format("阻塞信息为：topic: %s, 分区为: %s",rm.topic(),rm.partition()));
        }
        producer.close();
    }
    /*
     4. 接收回调函数的非阻塞
      如果你想提高性能也就是非阻塞，但是你想知道传过去了吗，也就是成功了吗
      如果你想通过判断 Future<RecordMetadata> 是否为 null ，那你肯定不对，因为不管成不成功，Future<RecordMetadata> 都不为null
     */
    public static void  sendMsgWithCallback() throws ExecutionException, InterruptedException {
        Producer<String, String> producer = new KafkaProducer<>(KafkaPropUtil.getProperties());

        for(int i = 0; i < 100; i++) {
            //异步，添加消息到缓存区，等待到一定程度把这些消息一起发送到集群
            ProducerRecord record = new ProducerRecord<String, String>("cs111",  Integer.toString(i)+"：is Blocking!");
            Future<RecordMetadata> frm = producer.send(record,(recordMetadata, e) -> {
                if(e!=null){
                    System.out.println(" 调用出错！ 请稍后再试");
                }else {
                    System.out.println("调用成功！");
                }
            });
            // 注释为 异步, 开启为  同步
            RecordMetadata rm = frm.get();
            System.out.println(String.format("阻塞信息为：topic: %s, 分区为: %s",rm.topic(),rm.partition()));
        }
        producer.close();
    }

    public static void main(String[] args) throws Exception {
//        sendMessageForgetResult();
//        sendMsgWithNonblocking();
//        sendMsgWithResult();

        sendMsgWithCallback();
    }


}

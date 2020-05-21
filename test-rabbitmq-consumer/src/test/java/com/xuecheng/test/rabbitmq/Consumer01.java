package com.xuecheng.test.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

/**
 * @program: xcEduService01
 * @description: 消费者测试类
 * @author: Chai.duolai
 * @create: 2020-03-15 18:34
 **/
public class Consumer01 {
    public static final String QUEUE="helloworld";
    
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        //设置MabbitMQ所在服务器的ip和端口
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        //创建与mq的Tcp连接
        Connection connection = factory.newConnection();
        //创建与交换机的通道
        Channel channel = connection.createChannel();
        //声明队列
        /*param1:队列名称
        param2:是否持久化
        param3:队列是否独占此连接
        param4:队列不再使用时是否自动删除此队列
        param5:队列参数*/
        channel.queueDeclare(QUEUE, true, false, false, null);
        //定义消费方法
        DefaultConsumer consumer=new DefaultConsumer(channel){
            public void handleDelivery(String consumerTag,Envelope envelope,
                                       AMQP.BasicProperties properties,byte[] body) throws UnsupportedEncodingException {
                //获得交换机
                String exchange = envelope.getExchange();
                //路由key
                String routingKey = envelope.getRoutingKey();
                //消息id
                long deliveryTag = envelope.getDeliveryTag();
                String msg=new String(body,"utf-8");
                System.out.println("receive message.." + msg);
            }
        };
        /**
         * 监听队列String queue, boolean autoAck,Consumer callback
         * 参数明细
         * 1、队列名称
         * 2、是否自动回复，设置为true为表示消息接收到自动向mq回复接收到了，mq接收到回复会删除消息，设置
         为false则需要手动回复
         * 3、消费消息的方法，消费者接收到消息后调用此方法
         */
        channel.basicConsume(QUEUE, true, consumer);
    }
}
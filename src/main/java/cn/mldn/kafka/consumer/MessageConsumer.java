package cn.mldn.kafka.consumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class MessageConsumer {
	public static final String SERVERS = "kafka-single:9095";
	public static final String TOPIC = "mldn-topic";
//
//	static {
//		System.setProperty("java.security.auth.login.config", "d:\\kafka_client_jaas.conf"); // 表示系统环境属性
//	}
  
	public static void main(String[] args) {
		// 如果想要使用kafka发送消息，需要定义一些环境属性 
		Properties prop = new Properties();  
 
//		prop.setProperty(SaslConfigs.SASL_MECHANISM, "PLAIN");
//		prop.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT"); 
		 
		prop.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVERS);
		prop.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		prop.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
		prop.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "group-5");  
		// 定义消费者处理对象
		Consumer<String, Integer> consumer = new KafkaConsumer<>(prop);
		consumer.subscribe(Arrays.asList(TOPIC)); // 设置消费者读取的主题名称
		boolean flag = true;
		while (flag) {
			ConsumerRecords<String, Integer> allRecords = consumer.poll(200); 
			for (ConsumerRecord<String, Integer> record : allRecords) {
				System.out.println("key = " + record.key() + "、value = " + record.value());
			}
		} 
		consumer.close();
	}
}

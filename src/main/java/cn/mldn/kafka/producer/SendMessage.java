package cn.mldn.kafka.producer;

import java.util.Properties;  

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord; 
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class SendMessage {
	public static final String SERVERS = "kafka-single:9095";
	public static final String TOPIC = "mldn-topic"; 

//	static {
//		System.setProperty("java.security.auth.login.config", "D:\\kafka_client_jaas.conf"); // 表示系统环境属性 
//	}

	public static void main(String[] args) {
		// 如果想要使用kafka发送消息，需要定义一些环境属性
		Properties prop = new Properties();

//		prop.setProperty(SaslConfigs.SASL_MECHANISM, "PLAIN");
//		prop.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
		prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVERS);
		// Kafka之中是以key和value的形式进行消息的发送处理， 所以为了保证Kafka的性能，专门提供有统一类型
		// props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
		// "org.apache.kafka.common.serialization.StringSerializer");
		prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
		long start = System.currentTimeMillis();
		Producer<String, Integer> producer = new KafkaProducer<>(prop);
		for (int i = 0; i < 10; i++) {
			producer.send(new ProducerRecord<String, Integer>(TOPIC, "mldn-" + i, i));
		}
		long end = System.currentTimeMillis();
		System.out.println("花费时间: " + (end - start));
		producer.close();
	} 
}

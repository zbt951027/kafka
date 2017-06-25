package cn.mldn.springkafka.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.springkafka.producer.service.IMessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-kafka-producer.xml")
public class TestSpringKafkaProducer {
	@Resource
	private IMessageService messageService;
	
	@Test
	public void testProducer() {
		for(int i = 0; i < 10; i++) {
			this.messageService.sendMessage(i); 
		}
	}
}

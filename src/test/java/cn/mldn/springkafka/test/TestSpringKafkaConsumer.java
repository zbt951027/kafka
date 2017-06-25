package cn.mldn.springkafka.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-kafka-consumer.xml")
public class TestSpringKafkaConsumer {
	@Test
	public void testConsumer() throws Exception {
		Thread.sleep(Long.MAX_VALUE); 
	}
}

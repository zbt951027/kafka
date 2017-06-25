package cn.mldn.springkafka.producer.service;

import javax.annotation.Resource; 

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {
	@Resource
	private KafkaTemplate<String, Integer> template;
	
	@Override
	public void sendMessage(Integer value) {
		this.template.sendDefault("mldn-key", value);
	}
}

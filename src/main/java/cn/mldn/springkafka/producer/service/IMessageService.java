package cn.mldn.springkafka.producer.service;

public interface IMessageService {
	/** 
	 * 进行消息的发送，发送消息的key统一设置为“mldn-key” 
	 * @param value 由用户设置要发送消息的具体内容 
	 */
	void sendMessage(Integer value);
}

package com.xzhang.activemq.consumer.queue;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("consumerService")
public class ConsumerService implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("ConsumerService接收到消息:"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	
	

}

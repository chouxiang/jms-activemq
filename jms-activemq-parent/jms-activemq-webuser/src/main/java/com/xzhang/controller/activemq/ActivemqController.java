package com.xzhang.controller.activemq;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xzhang.activemq.producer.queue.ProducerService;
import com.xzhang.activemq.producer.topic.TopicSender;
import com.xzhang.string.StringUtil;

@Controller
@RequestMapping("/activemqController")
public class ActivemqController {
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private TopicSender topicSender;
	
	
	/**
	 * 测试点对点发送消息
	 * @param request
	 * @param response
	 */
	@RequestMapping("queueSender.do")
	public void queueSender(HttpServletRequest request,HttpServletResponse response){
		String message = "test.queue点对点的消息发送...";
		producerService.send("test.queue", message);
		
		String message2 = "test.queue2点对点的消息发送...";
		producerService.send("test.queue2", message2);
		
		String str = "";
		for(int i=0;i<3;i++){
			str = String.valueOf(i);
			producerService.send("test.queue2", str);
		}
	}
	
	/**
	 * 测试发布/订阅消息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/topicSender.do")
	public void topicSender(HttpServletRequest request,HttpServletResponse response){
		
		String message = "test.topic点对点的消息发送...";
		for(int i=0;i<3;i++){
			topicSender.send("test.topic", "第"+(i+1)+"次发送:"+message);
		}
		
	}
	

}

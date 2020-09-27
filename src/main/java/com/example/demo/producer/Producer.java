package com.example.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

import com.example.demo.domain.Pedido;

@EnableBinding(Source.class)
public class Producer {
	@Autowired
	private Source mySource;
	
	public Producer(Source mySource) {
		super();
		this.mySource = mySource;
	}
	
	public void producer(Pedido obj) {
		mySource.output().send(MessageBuilder.withPayload(obj).build());
	}
	
	public void producer(Integer id) {
		mySource.output().send(MessageBuilder.withPayload(id).build());
	}
}

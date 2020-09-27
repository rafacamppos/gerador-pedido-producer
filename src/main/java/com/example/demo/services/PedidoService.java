package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Pedido;
import com.example.demo.producer.Producer;
import com.example.demo.repository.PedidoRepository;

import javassist.tools.rmi.ObjectNotFoundException;



@Service
public class PedidoService {
	
private Producer producer;
	
	public PedidoService(Producer producer) {
	super();
	this.producer = producer;
	}
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
	public Pedido insert(Pedido obj) {
		//obj.setId(null);
		producer.producer(obj);
		return repo.save(obj);
	}

}

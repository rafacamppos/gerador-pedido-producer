package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Pedido;
import com.example.demo.producer.Producer;
import com.example.demo.repository.PedidoRepository;

@SpringBootApplication
public class GerarPedidoApplication implements CommandLineRunner{
	
	@Autowired
	private PedidoRepository pedidoRepository;

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(GerarPedidoApplication.class, args);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm");
//		Producer producer = new Producer();
//		
//		Pedido ped1 = new Pedido(null, sdf.parse("10/10/2017 10:30"), "caderno", 20.50);
//		producer.kafkaProducer(ped1);
		
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("10/10/2017 10:30"), "caderno", 20.50);
		Pedido ped2 = new Pedido(null, sdf.parse("12/10/2017 10:30"), "caneta", 2.50);
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
	}

}

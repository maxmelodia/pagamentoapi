package com.pucminas.pagamentoapi.services;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucminas.pagamentoapi.domain.Pagamento;
import com.pucminas.pagamentoapi.repository.PagamentoRepository;

@Service
public class PagamentoServices {

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public List<Pagamento> listar(){
		return pagamentoRepository.findAll();
	}
	
	public Pagamento salvar(Pagamento pagamento) {
		pagamento.setId(null);
		pagamento.setData(new Date());
		
		Random num = new Random(10);
		pagamento.setStatusTransacao("REPROVADO");		
		if (num.nextInt() % 2 == 0){
			pagamento.setStatusTransacao("APROVADO");
		}
		return pagamentoRepository.save(pagamento);
	}
}

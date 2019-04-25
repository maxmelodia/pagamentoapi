package com.pucminas.pagamentoapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pucminas.pagamentoapi.domain.Pagamento;
import com.pucminas.pagamentoapi.services.PagamentoServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pagamento")
@Api(value="API REST - Pagamento")
public class PagamentoResources {

	@Autowired
	PagamentoServices pagamentoServices;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Lista pagamentos solicitado")	
	public ResponseEntity<List<Pagamento>> listar(){
		List<Pagamento> a = pagamentoServices.listar();
		return ResponseEntity.status(HttpStatus.OK).body(a); 
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Salva solicitação de pagamento e retorna se foi aprovado ou não")	
	public ResponseEntity<Pagamento> salvar(@RequestBody Pagamento pagamento) {
		Pagamento p = pagamentoServices.salvar(pagamento); 
		return ResponseEntity.status(HttpStatus.OK).body(pagamentoServices.salvar(p));
	}	
}

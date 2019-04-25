package com.pucminas.pagamentoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucminas.pagamentoapi.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}

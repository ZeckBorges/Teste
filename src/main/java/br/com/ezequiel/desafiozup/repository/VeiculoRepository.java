package br.com.ezequiel.desafiozup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ezequiel.desafiozup.model.ModelVeiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<ModelVeiculo, Long>{

}

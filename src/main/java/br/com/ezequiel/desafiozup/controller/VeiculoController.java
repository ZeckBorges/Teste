package br.com.ezequiel.desafiozup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ezequiel.desafiozup.feign.FeignVeiculo;
import br.com.ezequiel.desafiozup.model.ModelVeiculo;
import br.com.ezequiel.desafiozup.repository.VeiculoRepository;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private FeignVeiculo feignVeiculo;
	
	@PostMapping(value = "/salvar")
	public String salvaVeiculo(@RequestBody @Valid ModelVeiculo modelVeiculo) {
		
		veiculoRepository.save(modelVeiculo);
		 
		return "Veiculo Salvo com Sucesso!";
	}
	
	
	@GetMapping(value = "/{marca}/modelos/{modelo}/anos/{ano}")
	public ResponseEntity<ModelVeiculo> retornaVeiculo(@PathVariable("marca") String marca, 
			@PathVariable("modelo") String modelo,@PathVariable("ano") String ano){
		
		ModelVeiculo modelVeiculo = feignVeiculo.retornaVeiculos(marca, modelo, ano);
		modelVeiculo.setMarca(marca);
		modelVeiculo.setModelo(modelo);
		modelVeiculo.setAno(ano);
		
		veiculoRepository.save(modelVeiculo);
		
		return ResponseEntity.ok(modelVeiculo);
	}
	
	
}

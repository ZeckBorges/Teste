package br.com.ezequiel.desafiozup.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.ezequiel.desafiozup.model.ModelVeiculo;

@FeignClient(name = "veiculo", url = "https://parallelum.com.br/fipe/api/v1/carros/marcas")
public interface FeignVeiculo {
	
	//59/modelos/5940/anos/2014-3
	@GetMapping(value = "/{marca}/modelos/{modelo}/anos/{ano}")
	ModelVeiculo retornaVeiculos(@PathVariable("marca") String marca, 
			@PathVariable("modelo") String modelo,@PathVariable("ano") String ano);	

}

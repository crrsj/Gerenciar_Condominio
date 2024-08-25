package br.com.sistema.condominio.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sistema.condominio.dto.LazerDto;
import br.com.sistema.condominio.dto.MoradorDto;
import br.com.sistema.condominio.dto.MoradoresDto;
import br.com.sistema.condominio.dto.OcorrenciaDto;
import br.com.sistema.condominio.servico.CondominioServico;


@RestController
@RequestMapping("condominio")
public class CondominioControle {

	@Autowired
	private CondominioServico condominioServico;
	
	@PostMapping
	public ResponseEntity<MoradorDto>cadastrarMorador(@RequestBody MoradorDto morador){
		var cadastro = condominioServico.cadastrarMorador(morador);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(cadastro.getId()).toUri();
		return ResponseEntity.created(uri).body(new MoradorDto(cadastro));
	}
	@PostMapping("ocorrencia/{moradorId}")
	public ResponseEntity<OcorrenciaDto>cadastrarOcorrencia(@RequestBody OcorrenciaDto ocorrenciadto,@PathVariable("moradorId") 
	     Long moradorId){
		
		var ocorrencia = condominioServico.cadastrarOcorrencia( ocorrenciadto, moradorId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(ocorrencia.getId()).toUri();
		return ResponseEntity.created(uri).body(new OcorrenciaDto(ocorrencia));
			
				
	}
	
	@PostMapping("lazer/{moradorId}")
	public ResponseEntity<LazerDto>alugarEspaco(@RequestBody LazerDto lazerDto,@PathVariable("moradorId")
	
			Long moradorId){
		
		var alugar = condominioServico.alugarEspaco(lazerDto, moradorId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
		.buildAndExpand(alugar.getId()).toUri();
		return ResponseEntity.created(uri).body(new LazerDto(alugar));
	}
	
	@GetMapping
	public ResponseEntity<List<MoradoresDto>>listarMoradores(){
		var listar = condominioServico.listarTodos();
		return ResponseEntity.ok(listar);
	}
	
	@GetMapping("area")
	public ResponseEntity<LazerDto>buscarAreaReservada(){
		var buscarArea = condominioServico.buscarAreaReservada();
		return ResponseEntity.ok().body(new LazerDto(buscarArea));
	}
	
	@PutMapping
	public ResponseEntity<MoradoresDto>atualizarMorador(@RequestBody MoradoresDto moradoresDto,@PathVariable Long id ){
		var atualizar = condominioServico.AtualizarMorador(moradoresDto, id);
		return ResponseEntity.ok().body(new MoradoresDto(atualizar));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<MoradoresDto>buscarMoradorPorId(@PathVariable Long id){
		var buscaPorId = condominioServico.buscarPorId(id);
		return ResponseEntity.ok().body(new MoradoresDto(buscaPorId));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void>excluir(@PathVariable Long id){
		condominioServico.excluir(id);
		return ResponseEntity.noContent().build();
	}
}

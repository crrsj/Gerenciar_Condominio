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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sistema.condominio.dto.LazerDto;
import br.com.sistema.condominio.dto.MoradorDto;
import br.com.sistema.condominio.dto.MoradoresDto;
import br.com.sistema.condominio.dto.OcorrenciaDto;
import br.com.sistema.condominio.dto.VisitanteDto;
import br.com.sistema.condominio.servico.CondominioServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;


@RestController
@RequestMapping("condominio")
public class CondominioControle {

	@Autowired
	private CondominioServico condominioServico;
	
	@PostMapping
	@Operation(summary = "Rota responsável pelo cadastro de moradores.") 
    @ApiResponse(responseCode = "201",description = "Morador cadastrado com sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<MoradorDto>cadastrarMorador(@RequestBody @Valid MoradorDto morador){
		var cadastro = condominioServico.cadastrarMorador(morador);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(cadastro.getId()).toUri();
		return ResponseEntity.created(uri).body(new MoradorDto(cadastro));
	}
	
	
	@PostMapping("ocorrencia/{moradorId}")
	@Operation(summary = "Rota responsável pelo cadastro de ocorrências. ") 
    @ApiResponse(responseCode = "201",description = "Ocorrência cadastrada com sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<OcorrenciaDto>cadastrarOcorrencia(@RequestBody @Valid OcorrenciaDto ocorrenciadto,@PathVariable("moradorId") 
	     Long moradorId){
		
		var ocorrencia = condominioServico.cadastrarOcorrencia( ocorrenciadto, moradorId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(ocorrencia.getId()).toUri();
		return ResponseEntity.created(uri).body(new OcorrenciaDto(ocorrencia));
			
				
	}
	
	@PostMapping("lazer/{moradorId}")
	@Operation(summary = "Rota responsável pelo cadastro de reserva de espaço.") 
    @ApiResponse(responseCode = "201",description = "Espaço alugado com sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<LazerDto>alugarEspaco(@RequestBody @Valid LazerDto lazerDto,@PathVariable("moradorId")
	
			Long moradorId){
		
		var alugar = condominioServico.alugarEspaco(lazerDto, moradorId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
		.buildAndExpand(alugar.getId()).toUri();
		return ResponseEntity.created(uri).body(new LazerDto(alugar));
	}
	
	@GetMapping
	@Operation(summary = "Rota responsável pela busca de todos os moradores.") 
    @ApiResponse(responseCode = "200",description = "Sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<MoradoresDto>>listarMoradores(){
		var listar = condominioServico.listarTodos();
		return ResponseEntity.ok(listar);
	}
	
	@GetMapping("area")
	@Operation(summary = "Rota responsável pela busca de área reservada.") 
    @ApiResponse(responseCode = "200",description = "Sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<LazerDto>buscarAreaReservada(){
		var buscarArea = condominioServico.buscarAreaReservada();
		return ResponseEntity.ok().body(new LazerDto(buscarArea));
	}
	
	@PutMapping
	@Operation(summary = "Rota responsável pela atualização de cadastro de moradores.") 
    @ApiResponse(responseCode = "200",description = "Morador cadastrado com sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<MoradoresDto>atualizarMorador(@RequestBody @Valid MoradoresDto moradoresDto,@PathVariable Long id ){
		var atualizar = condominioServico.AtualizarMorador(moradoresDto, id);
		return ResponseEntity.ok().body(new MoradoresDto(atualizar));
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Rota responsável pela busca de  de morador pelo id.") 
    @ApiResponse(responseCode = "200",description = "Sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<MoradoresDto>buscarMoradorPorId(@PathVariable Long id){
		var buscaPorId = condominioServico.buscarPorId(id);
		return ResponseEntity.ok().body(new MoradoresDto(buscaPorId));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Rota responsável pela exclusão de morador.") 
    @ApiResponse(responseCode = "204",description = "Sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluir(@PathVariable Long id){
		condominioServico.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("visitante/{moradorId}")
	@Operation(summary = "Rota responsável pelo cadastro de visitantes.") 
    @ApiResponse(responseCode = "201",description = "Visitante cadastrado com sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<VisitanteDto>cadastrarVisitante(@RequestBody VisitanteDto visitante,@PathVariable("moradorId")
	 Long moradorId){
		var cadastrar = condominioServico.cadastrarVisitante(visitante, moradorId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(cadastrar.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new VisitanteDto(cadastrar));
	}
	
	@GetMapping("nome")
	@Operation(summary = "Rota responsável pela busca de moradores pelo nome.") 
    @ApiResponse(responseCode = "200",description = "Sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
   		
    })           	
	public ResponseEntity<List<MoradoresDto>>buscarPorNome(@RequestParam(name ="nome") String nome){
		var busca = condominioServico.buscarPorNome(nome).stream().map(MoradoresDto::new).toList();
		return ResponseEntity.ok(busca);
				
	}
}

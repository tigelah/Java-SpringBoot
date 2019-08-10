package br.com.produtos.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.produtos.apirest.models.Produto;
import br.com.produtos.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		return 	produtoRepository.findAll();
		
	}
	
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	
	@GetMapping("/produto/{id}")
	public Produto listaProduto(@PathVariable(value="id") long id){
		return 	produtoRepository.findById(id);
		
	}
	
	@DeleteMapping("/produto")
	public void deletaProduto(@RequestBody Produto produto){
			produtoRepository.delete(produto);
		
	}
	
	@PutMapping("/produto")
	public Produto atualizaProduto(@RequestBody Produto produto){
			return produtoRepository.save(produto);
		
	}
	
}

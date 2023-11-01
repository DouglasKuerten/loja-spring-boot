package com.atividadeLoja.atividadeLoja.resource;

import com.atividadeLoja.atividadeLoja.model.Produto;
import com.atividadeLoja.atividadeLoja.service.NotFoundException;
import com.atividadeLoja.atividadeLoja.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController extends AbstractController{
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Produto entity) {
        Produto save = produtoService.salvar(entity);
        return ResponseEntity.created(URI.create("/api/produtos/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter) {
        List<Produto> produtos = produtoService.buscarTodos(filter);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Produto produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        produtoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Produto entity) {
        try {
            Produto alterado = produtoService.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        } catch (NotFoundException nfe) {
            return ResponseEntity.noContent().build();
        }
    }

}

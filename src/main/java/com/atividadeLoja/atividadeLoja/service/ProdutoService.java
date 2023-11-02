package com.atividadeLoja.atividadeLoja.service;

import com.atividadeLoja.atividadeLoja.model.Produto;
import com.atividadeLoja.atividadeLoja.model.QProduto;
import com.atividadeLoja.atividadeLoja.model.Status;
import com.atividadeLoja.atividadeLoja.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto entity){
        if(entity.getValorUnitario() < entity.getPrecoCompra()){
            throw new ValidationException("O valor unitario não pode ser menor que o preço de compra do produto!");
        }
        if(!produtoRepository.findAll(QProduto.produto.descricao.eq(entity.getDescricao())).isEmpty()){
            throw new ValidationException("Já existe um produto com essa descrição cadastrado!");
        }
        return produtoRepository.save(entity);
    }
    public List<Produto> buscarTodos(String filter){
        return produtoRepository.findAll(filter, Produto.class);
    }
    public Page<Produto> buscarTodos(String filter, Pageable pageable){
        return produtoRepository.findAll(filter, Produto.class, pageable);
    }
    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).orElse(null);
    }
    public Produto alterar(Long id, Produto entity){
        Optional<Produto> existingProdutoOptional = produtoRepository.findById(id);
        if(existingProdutoOptional.isEmpty()){
            throw new NotFoundException("Produto não encontrado");
        }
        Produto existingProduto = existingProdutoOptional.get();
        modelMapper.map(entity, existingProduto);
        return produtoRepository.save(existingProduto);
    }
    public void remover(Long id){
        produtoRepository.deleteById(id);
    }


}

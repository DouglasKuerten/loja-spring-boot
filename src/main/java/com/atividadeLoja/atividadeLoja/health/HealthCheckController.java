package com.atividadeLoja.atividadeLoja.health;

import com.atividadeLoja.atividadeLoja.model.*;
import com.atividadeLoja.atividadeLoja.repository.ClienteRepository;
import com.atividadeLoja.atividadeLoja.repository.ProdutoRepository;
import com.atividadeLoja.atividadeLoja.repository.ServicoRepository;
import com.atividadeLoja.atividadeLoja.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HealthCheckController {
    @GetMapping("/health")
        public String healthCheck(){
        return "OK";
    }

    @Autowired
    public ProdutoRepository produtoRepository;

    @Autowired
    public ServicoRepository servicoRepository;

    @Autowired
    public ClienteRepository clienteRepository;

    @Autowired
    public VendaRepository vendaRepository;
    @GetMapping("/produtooo")
        public String healthCheck2(){
        Produto produto = new Produto();
        produto.setDescricao("Rtx 4080ti");
        produto.setNome("Placa de Video");
        produto.setValorUnitario(1800.00);
        produto.setDataPrazo(LocalDate.now());
        produto.setDataValidade(LocalDate.now());
        produto.setPrecoCompra(2800.00);
        produto.setStatus(Status.DISPONIVEL);
        produto.setEstocavel(Boolean.TRUE);
        produtoRepository.save(produto);

        Servico servico = new Servico();
        servico.setQuantidadeHoras(20.00);
        servico.setDescricao("Instalação Office");
        servico.setEstocavel(Boolean.TRUE);
        servico.setValorUnitario(150.00);

        servico = servicoRepository.save(servico);

        Cliente cliente = new Cliente();
        cliente.setCpf("1234566516");
        cliente.setRg("25552");
        cliente.setNome("Douglas");
        cliente.setEmail("email@gmail.com");
        cliente.setEndereco("Rua alguma coisa");
        cliente.setTelefone("999999999");

        cliente = clienteRepository.save(cliente);

        Venda venda =  new Venda();
        venda.setCliente(cliente);
        venda.setDataVenda(LocalDate.now());
        venda.setObservacao("Observacao");
        venda.setFormaPagamento(FormaPagamento.PIX);

        ItemVenda itemVenda = new ItemVenda(produto, 2800.00, 1.0, 10.00);
        ItemVenda itemVenda2 = new ItemVenda(servico, 100.00, 1.0, 10.00);

        venda.addItemVenda(itemVenda);
        venda.addItemVenda(itemVenda2);

        vendaRepository.save(venda);

        return "Comando executado!" + produto.getId();
    }

}

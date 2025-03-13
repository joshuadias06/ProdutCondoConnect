package com.ccondoproduct.connect.config;

import com.ccondoproduct.connect.model.Produto;
import com.ccondoproduct.connect.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(ProdutoRepository produtoRepository) {
        return args -> {

            Produto produto1 = new Produto();
            produto1.setNome("Televisão");
            produto1.setDescricao("Tv Samsung 52 Polegadas, OLed - 3D - 144hz");
            produto1.setImg("https://images.unsplash.com/photo-1461151304267-38535e780c79?q=80&w=1633&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
            produto1.setProprietario("Janivaldo");
            produto1.setTelefone("123456789");

            Produto produto2 = new Produto();
            produto2.setNome("Bicicleta Caloi");
            produto2.setDescricao("Bicicleta Caloi - Aro 24 - Freio a ");
            produto2.setDescricao("Bicicleta Caloi - Aro 24 - Freio a Disco - Cubo roletado");
            produto2.setImg("https://images.unsplash.com/photo-1485965120184-e220f721d03e?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
            produto2.setProprietario("Proprietário B");
            produto2.setTelefone("987654321");

            Produto produto3 = new Produto();
            produto3.setNome("Notebook Dell");
            produto3.setDescricao("Notebook Dell - 17p - 16gb RAM");
            produto3.setImg("https://images.unsplash.com/photo-1498050108023-c5249f4df085?q=80&w=1472&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
            produto3.setProprietario("Proprietário C");
            produto3.setTelefone("555555555");

            Produto produto4 = new Produto();
            produto4.setNome("Notebook Dell");
            produto4.setDescricao("Notebook Dell - 17p - 16gb RAM");
            produto4.setImg("https://images.unsplash.com/photo-1498050108023-c5249f4df085?q=80&w=1472&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
            produto4.setProprietario("Proprietário C");
            produto4.setTelefone("555555555");

            produtoRepository.save(produto1);
            produtoRepository.save(produto2);
            produtoRepository.save(produto3);
            produtoRepository.save(produto4);
        };
    }
}

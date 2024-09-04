package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class Produto {
    private final long id;

    @NonNull
    private final String titulo;

    private String descricao;
    private String marca;
    private String modelo;
    private int estoque = 0;

    @NonNull
    private final double preco;

    @NonNull
    private final LocalDate dataCadastro;

    @NonNull
    private final LocalDate dataUltimaAtualizacao;

    private String urlFoto;

    @NonNull
    private final String categoria;

    private double peso;
    private double altura;
    private double largura;
    private double profundidade;

    // Validações
    public static class ProdutoBuilder {
        public Produto build() {
            if (this.dataCadastro.isBefore(LocalDate.now()) || this.dataUltimaAtualizacao.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("As datas não podem ser menores que a data atual.");
            }
            if (this.preco <= 0) {
                throw new IllegalArgumentException("O preço deve ser maior que zero.");
            }
            if (this.marca == null && this.modelo != null) {
                throw new IllegalArgumentException("O modelo só pode ser atribuído se a marca também for.");
            }
            return new Produto(this);
        }
    }

    private Produto(ProdutoBuilder builder) {
        this.id = builder.id;
        this.titulo = builder.titulo;
        this.descricao = builder.descricao;
        this.marca = builder.marca;
        this.modelo = builder.modelo;
        this.estoque = builder.estoque;
        this.preco = builder.preco;
        this.dataCadastro = builder.dataCadastro;
        this.dataUltimaAtualizacao = builder.dataUltimaAtualizacao;
        this.urlFoto = builder.urlFoto;
        this.categoria = builder.categoria;
        this.peso = builder.peso;
        this.altura = builder.altura;
        this.largura = builder.largura;
        this.profundidade = builder.profundidade;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Titulo: " + titulo + "\n" +
                "Descrição: " + descricao + "\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Estoque: " + estoque + "\n" +
                "Preço: " + preco + "\n" +
                "Data de Cadastro: " + dataCadastro + "\n" +
                "Data de Última Atualização: " + dataUltimaAtualizacao + "\n" +
                "URL da Foto: " + urlFoto + "\n" +
                "Categoria: " + categoria + "\n" +
                "Peso: " + peso + "\n" +
                "Altura: " + altura + "\n" +
                "Largura: " + largura + "\n" +
                "Profundidade: " + profundidade;
    }
}

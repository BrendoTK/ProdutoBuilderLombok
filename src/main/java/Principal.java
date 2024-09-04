import org.example.Produto;

import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        try {
            Produto produto = Produto.builder()
                    .id(1)
                    .titulo("Bananão")
                    .preco(100.0)
                    .dataCadastro(LocalDate.now())
                    .dataUltimaAtualizacao(LocalDate.now())
                    .categoria("Fruta")
                    .descricao("Super Banana Nanica")
                    .marca("Seu Zé")
                    .modelo("Modelo Z")
                    .urlFoto("http://banana.com/foto.jpg")
                    .peso(1.0)
                    .altura(10.0)
                    .largura(5.0)
                    .profundidade(3.0)
                    .build();

            System.out.println(produto);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}


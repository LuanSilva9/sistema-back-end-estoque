package com.sistemas.luan.Estoque.domain.model.Produto;

import com.sistemas.luan.Estoque.domain.model.Empresa.Empresa;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name="produto")
@Table(name="produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String descricao;
    private String sku;

    @ManyToOne
    @JoinColumn(name = "categoriaId", referencedColumnName = "id")
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="empresaId", referencedColumnName = "id")
    private Empresa empresa;

    private Double precoCusto;
    private Double precoVenda;

    private ZonedDateTime createdAt;

    public Produto(String nome, String descricao, String sku, Categoria categoria, Empresa empresa, Double precoCusto, Double precoVenda) {
        this.nome = nome;
        this.descricao = descricao;
        this.sku = sku;
        this.categoria = categoria;
        this.empresa = empresa;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.createdAt = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }
}

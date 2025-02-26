package com.sistemas.luan.Estoque.domain.model.Estoque;

import com.sistemas.luan.Estoque.domain.model.Produto.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name = "produtoEstoque")
@Table(name="produtoEstoque")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProdutoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "estoqueId", referencedColumnName = "id")
    private Estoque estoque;

    @ManyToOne
    @JoinColumn(name = "produtoId", referencedColumnName = "id")
    private Produto produto;

    private ZonedDateTime createdAt;
}

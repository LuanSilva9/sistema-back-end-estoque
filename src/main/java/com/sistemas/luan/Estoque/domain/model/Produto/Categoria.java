package com.sistemas.luan.Estoque.domain.model.Produto;

import com.sistemas.luan.Estoque.domain.model.Empresa.Empresa;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name="categoria")
@Table(name="categoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "empresaId", referencedColumnName = "id")
    private Empresa empresa;

    private ZonedDateTime createdAt;

    public Categoria(String nome, Empresa empresa) {
        this.nome = nome;
        this.empresa = empresa;
        this.createdAt = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }
}

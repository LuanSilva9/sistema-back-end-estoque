package com.sistemas.luan.Estoque.domain.model.Estoque;


import jakarta.persistence.*;
import lombok.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name = "estoque")
@Table(name = "estoque")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Long quantidade;
    private String localizacao;
    private ZonedDateTime createdAt;

    public Estoque(Long quantidade, String localizacao) {
        this.quantidade = quantidade;
        this.localizacao = localizacao;
        this.createdAt = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }
}

package com.sistemas.luan.Estoque.domain.model.Usuario;

import com.sistemas.luan.Estoque.domain.model.Empresa.Empresa;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Entity(name="usuario")
@Table(name="usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String email;
    private String senha;
    private PerfilUsuario perfil;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empresaId", referencedColumnName = "id")
    private Empresa empresa;

    private ZonedDateTime createdAt;

    public Usuario(String nome, String email, String senha, PerfilUsuario perfil, Empresa empresa) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.empresa = empresa;
        this.createdAt = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }
}

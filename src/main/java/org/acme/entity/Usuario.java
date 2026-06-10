package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.acme.enums.PerfilUsuario;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class Usuario extends PanacheEntity {

    @Column(nullable = false, length = 120)
    public String nome;

    @Column(unique = true, nullable = false)
    public String email;

    @Column(nullable = false)
    public String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public PerfilUsuario perfil;

    @Column(nullable = false)
    public Boolean ativo = true;

    @CreationTimestamp
    @Column(nullable = false , updatable = false)
    public LocalDateTime dataCriacao ;

    @UpdateTimestamp
    @Column(nullable = false)
    public LocalDateTime dataAtualizacao;
}

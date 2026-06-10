package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.acme.enums.TipoLancamento;

import java.time.LocalDateTime;

@Entity
@Table(name = "categoria")
public class Categoria extends PanacheEntity {

    public String nome;

    @Enumerated(EnumType.STRING)
    public TipoLancamento tipo;

    public Boolean ativo = true;

    public LocalDateTime dataCriacao ;

    public LocalDateTime dataAtualizacao;

    public String cor;
}

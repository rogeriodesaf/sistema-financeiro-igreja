package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.acme.enums.FormaMovimentacao;
import org.acme.enums.TipoLancamento;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "lancamento_financeiro")
public class LancamentoFinanceiro extends PanacheEntity {

    @Column(nullable = false)
    public LocalDate dataLancamento;

   @Enumerated(EnumType.STRING)
   @Column(nullable = false)
    public FormaMovimentacao origem;

    @Column(nullable = false, precision = 15, scale = 2)
    public BigDecimal valor;

    @Column(nullable = false, length = 200)
    public String descricao;

    @Column(length = 100)
    public String numeroDocumento;

    @Column(length = 255)
    public String observacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public TipoLancamento tipo;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    public Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    public Usuario usuarioCadastro;

    @CreationTimestamp
    @Column(nullable = false , updatable = false)
    public LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(nullable = false)
    public LocalDateTime dataAtualizacao;

    //novo campo para indicar se o lançamento foi conciliado ou não
    public boolean conciliado = false;

    @Column(nullable = false)
    public Boolean cancelado = false;
}




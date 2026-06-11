package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.LancamentoFinanceiro;

@ApplicationScoped
public class LancamentoFinanceiroRepository implements PanacheRepository<LancamentoFinanceiro> {
}

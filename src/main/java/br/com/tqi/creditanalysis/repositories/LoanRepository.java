package br.com.tqi.creditanalysis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.tqi.creditanalysis.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}

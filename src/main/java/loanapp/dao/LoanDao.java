package loanapp.dao;

import loanapp.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoanDao extends JpaRepository<Loan, Integer> {
}
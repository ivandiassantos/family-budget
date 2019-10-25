package br.com.familybudget.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.familybudget.model.Income;

public interface IncomeRepository extends JpaRepository<Income, Long>{

	Optional<Income> findByName(String name);

}

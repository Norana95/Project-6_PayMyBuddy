package com.Openclassrooms.PayMyBuddy.repository;

import com.Openclassrooms.PayMyBuddy.model.Solde;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldeRepository extends CrudRepository<Solde, Long> {
}

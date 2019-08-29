package com.sepro.customerservice.repository;

import com.sepro.customerservice.entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AdresseRepository extends JpaRepository<Adresse,Long> {
}

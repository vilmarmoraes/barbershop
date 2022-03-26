package com.vjssolution.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vjssolution.barbershop.models.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long>  {

}

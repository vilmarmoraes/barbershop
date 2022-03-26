package com.vjssolution.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vjssolution.barbershop.models.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

}

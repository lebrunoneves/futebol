package com.bruno.futebol.repository;

import com.bruno.futebol.model.Clube;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ClubeRepository extends CrudRepository<Clube, UUID> {

}

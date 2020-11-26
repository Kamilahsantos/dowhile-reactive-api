package com.rocketseat.projeto.repository;

import com.rocketseat.projeto.model.Devs;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevsRepository extends ReactiveMongoRepository <Devs, String> {
}

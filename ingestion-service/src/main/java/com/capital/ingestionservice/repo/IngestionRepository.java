package com.capital.ingestionservice.repo;

import com.capital.ingestionservice.entity.IngestionRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngestionRepository extends CrudRepository<IngestionRequest, Long> {
}

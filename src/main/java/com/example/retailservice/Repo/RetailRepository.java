package com.example.retailservice.Repo;

import com.example.retailservice.Entity.RetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailRepository extends JpaRepository<RetailEntity,Long> {
}

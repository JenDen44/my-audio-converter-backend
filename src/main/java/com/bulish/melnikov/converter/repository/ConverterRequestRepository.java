package com.bulish.melnikov.converter.repository;

import com.bulish.melnikov.converter.model.ConvertRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConverterRequestRepository extends JpaRepository<ConvertRequest, String> {
}

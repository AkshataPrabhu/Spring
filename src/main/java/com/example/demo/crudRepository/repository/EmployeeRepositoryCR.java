package com.example.demo.crudRepository.repository;

import com.example.demo.crudRepository.model.EmployeeModelCR;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepositoryCR extends CrudRepository<EmployeeModelCR, Integer> {

  public EmployeeModelCR findByName(String name);

  @Query("select emp from EmployeeModelCR emp where sambol>=?1 and sambol <=?2")
  public List<EmployeeModelCR> findbyRange(int from, int to);

  @Query("select emp from EmployeeModelCR emp where sambol>=?1 and sambol <=?2")
  public List<EmployeeModelCR> findbyRangePageable(int from, int to, Pageable p);
}

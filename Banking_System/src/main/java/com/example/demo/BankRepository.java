package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface BankRepository extends JpaRepository<Bank, Integer>{

}

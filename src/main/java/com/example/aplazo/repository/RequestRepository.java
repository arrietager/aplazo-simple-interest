package com.example.aplazo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aplazo.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {

}

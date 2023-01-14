package com.example.aplazo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aplazo.model.Response;

public interface ResponseRepository extends JpaRepository<Response, Long>{

	List<Response> findByRequestId(int requestId);
}

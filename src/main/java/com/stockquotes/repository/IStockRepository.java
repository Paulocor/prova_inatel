package com.stockquotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockquotes.models.Stock;

public interface IStockRepository extends JpaRepository<Stock, String> {

	Stock findStockById(String id);
}

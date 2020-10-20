package com.stockquotes.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.stockquotes.models.Stock;
import com.stockquotes.repository.IStockRepository;

@RestController
@RequestMapping(value = "/")
public class StockResource {

	@Autowired
	IStockRepository repository;

	@GetMapping("/stocks")
	public List<Stock> getAllStocks() {
		List<Stock> listStocks = repository.findAll();
		return listStocks;
	}

	@GetMapping("/stock/{id}")
	public Stock getStocks(@PathVariable(value = "id") String id) {
		Stock stock = repository.findStockById(id);
		return stock;
	}

	@PostMapping("/stock")
	public Stock setStock(@RequestBody Stock stock) {
		Stock stockObj = repository.save(stock);
		return stockObj;
	}

	@DeleteMapping("/stock/")
	public void revome(@RequestBody Stock stock) {
		repository.delete(stock);
	}

	@PutMapping("/stock/")
	public Stock updateStock(@RequestBody Stock stock) {
		Stock stockObj = repository.save(stock);
		return stockObj;

	}

}

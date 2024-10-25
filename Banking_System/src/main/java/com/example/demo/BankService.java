
package com.example.demo;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BankService {
	private BankRepository repository;

	public BankService(BankRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Bank> retrieveAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public void savebank(Bank bank) {
		// TODO Auto-generated method stub
		repository.save(bank);
		
	}

	public void deleteBank(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	public Bank retrieveById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();

	}


}
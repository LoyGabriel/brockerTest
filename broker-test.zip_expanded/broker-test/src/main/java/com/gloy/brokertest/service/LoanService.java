package com.gloy.brokertest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gloy.brokertest.dto.LoanDTO;
import com.gloy.brokertest.repository.LoanRepository;

@Service
public class LoanService {
	@Autowired
	LoanRepository loanRepository;

	public Page<LoanDTO> findLoansByUserId(int page, int size, int userId) {
		Pageable pagination= PageRequest.of(page, size);
		return loanRepository.findByUserId(userId,pagination);
	}

	public Page<LoanDTO> findLoans(int page, int size) {
		Pageable pagination= PageRequest.of(page, size);
		return loanRepository.findAll(pagination);
	}

	public LoanDTO createLoan(LoanDTO loanDTO) {
		return loanRepository.save(loanDTO);
	}

	public void deleteLoanById(int loanId) {
		loanRepository.deleteById(loanId);
	}
	
	public List<LoanDTO> addAll(List<LoanDTO>loansDTO){
		return (List<LoanDTO>) loanRepository.saveAll(loansDTO);
	}

}

package com.gloy.brokertest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.gloy.brokertest.dto.LoanDTO;

public interface LoanRepository extends PagingAndSortingRepository<LoanDTO, Integer>{
	Page<LoanDTO> findByUserId(int userId, Pageable pageable);
}

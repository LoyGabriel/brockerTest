package com.gloy.brokertest.resource;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gloy.brokertest.dto.LoanDTO;
import com.gloy.brokertest.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
	@Autowired
	LoanService loanService;

	@GetMapping(value = "")
	public List<LoanDTO> getLoans(
			@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "size", required = true) int size,
			@RequestParam(value = "user-id", required = false) Integer userId) {
		if(Objects.isNull(userId)) {
			return loanService.findLoans(page, size).getContent();
		}else {
			return loanService.findLoansByUserId(page, size, userId.intValue()).getContent();
		}

	}

	@PostMapping(value = "", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public LoanDTO addLoan(@RequestBody LoanDTO loanDTO) {
		return loanService.createLoan(loanDTO);
	}

	@DeleteMapping(value = "/{loanId}")
	public void deleteLoan(@PathVariable(value = "loanId") int loanId) {
		loanService.deleteLoan(loanId);
	}
}

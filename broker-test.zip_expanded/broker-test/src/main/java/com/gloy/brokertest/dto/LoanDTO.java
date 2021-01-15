package com.gloy.brokertest.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name="LOAN")
public class LoanDTO {
	@Id
	@GeneratedValue
	private int loanId;
	private double total;
	private int userId;
}

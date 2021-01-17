package com.gloy.brokertest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@Column(name="loan_id")
	private int id;
	private double total;
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private int userId;
	
	public LoanDTO(double total, int userId) {
		this.total=total;
		this.userId=userId;
	}
}

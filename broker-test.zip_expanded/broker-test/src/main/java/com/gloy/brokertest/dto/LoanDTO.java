package com.gloy.brokertest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name="LOAN")
@NoArgsConstructor
public class LoanDTO {
	@Id
	@GeneratedValue
	@Column(name="loan_id")
	private int id;
	private double total;
	@Column(name="user_id")
	private int userId;
	
	public LoanDTO(int id, double total, int userId) {
		this.id=id;
		this.total=total;
		this.userId=userId;
	}
}

package com.gloy.brokertest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter
@Entity
@Table(name="USER")
public class UserDTO {
	@Id
	@GeneratedValue
	@Column(name="userId")
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	@OneToMany(targetEntity = LoanDTO.class, orphanRemoval = true, cascade = CascadeType.ALL)
	private List<LoanDTO> loans;
	
	public UserDTO(String email, String firstName, String lastName) {
		this.email=email;
		this.firstName= firstName;
		this.lastName= lastName;
	}
}

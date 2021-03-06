package com.learning.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.learning.enums.EnabledStatus;
import com.learning.enums.RoleName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Entity
public class Customer extends User {

	public Customer() {
		super();
		this.setRoles(new HashSet<Role>());
	}
	private String phone;
	
	private String pan;
	
	private String panImage;
	
	private String aadhar;
	
	private String aadharImage;
	
	private String secretQuestion;

	private String secretAnswer;
	
	private LocalDate createdDate;
	
	private EnabledStatus status = EnabledStatus.ENABLED;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Account> accounts = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Beneficiary> beneficiaries = new HashSet<>();
}

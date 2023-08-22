package com.rangga.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "birthDate")
	private Date birthDate;
	
	@Column(name = "positionId")
	private int positionId;
	
	@Column(name = "idNumber")
	private int idNumber;
	
	@Column(name = "gender")
	private int gender;
	
	@Column(name = "isDeleted")
	private int isDeteled;

}

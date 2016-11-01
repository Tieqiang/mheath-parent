package com.mheath.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * RoleDict entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role_dict", catalog = "mheath")
public class RoleDict implements java.io.Serializable {

	// Fields

	private String id;
	private String roleName;
	private Integer dataScope;

	// Constructors

	/** default constructor */
	public RoleDict() {

	}

	/** full constructor */
	public RoleDict(String roleName, Integer dataScope) {
		this.roleName = roleName;
		this.dataScope = dataScope;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 64)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "role_name", length = 100)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "data_scope")
	public Integer getDataScope() {
		return this.dataScope;
	}

	public void setDataScope(Integer dataScope) {
		this.dataScope = dataScope;
	}

}
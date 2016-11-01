package com.mheath.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * PermissionDict entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "permission_dict", catalog = "mheath")
public class PermissionDict implements java.io.Serializable {

	// Fields

	private String id;
	private String permission;
	private String description;
	private Integer useFlag;

	// Constructors

	/** default constructor */
	public PermissionDict() {
	}

	/** full constructor */
	public PermissionDict(String permission, String description, Integer useFlag) {
		this.permission = permission;
		this.description = description;
		this.useFlag = useFlag;
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

	@Column(name = "permission", length = 100)
	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "use_flag")
	public Integer getUseFlag() {
		return this.useFlag;
	}

	public void setUseFlag(Integer useFlag) {
		this.useFlag = useFlag;
	}

}
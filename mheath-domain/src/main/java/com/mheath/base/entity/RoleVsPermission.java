package com.mheath.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * RoleVsPermission entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role_vs_permission", catalog = "mheath")
public class RoleVsPermission implements java.io.Serializable {

	// Fields

	private String id;
	private String roleId;
	private String permissionId;

	// Constructors

	/** default constructor */
	public RoleVsPermission() {
	}

	/** full constructor */
	public RoleVsPermission(String roleId, String permissionId) {
		this.roleId = roleId;
		this.permissionId = permissionId;
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

	@Column(name = "role_id", length = 64)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "permission_id", length = 64)
	public String getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

}
package com.mheath.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * RoleVsMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role_vs_menu", catalog = "mheath")
public class RoleVsMenu implements java.io.Serializable {

	// Fields

	private String id;
	private String roleId;
	private String menuId;

	// Constructors

	/** default constructor */
	public RoleVsMenu() {
	}

	/** full constructor */
	public RoleVsMenu(String roleId, String menuId) {
		this.roleId = roleId;
		this.menuId = menuId;
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

	@Column(name = "menu_id", length = 64)
	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

}
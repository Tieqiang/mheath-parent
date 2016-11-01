package com.mheath.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * MenuDict entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "menu_dict", catalog = "mheath")
public class MenuDict implements java.io.Serializable {

	// Fields

	private String id;
	private String menuName;
	private String menuHref;
	private Integer sort;
	private String icon;
	private String permission;
    private String parentId ;

	// Constructors

	/** default constructor */
	public MenuDict() {
	}

	/** full constructor */
	public MenuDict(String menuName, String menuHref, Integer sort,
                    String icon, String permission, String parentId) {
		this.menuName = menuName;
		this.menuHref = menuHref;
		this.sort = sort;
		this.icon = icon;
		this.permission = permission;
        this.parentId = parentId;
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

	@Column(name = "menu_name", length = 50)
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "menu_href", length = 200)
	public String getMenuHref() {
		return this.menuHref;
	}

	public void setMenuHref(String menuHref) {
		this.menuHref = menuHref;
	}

	@Column(name = "sort")
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Column(name = "ICON", length = 100)
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "PERMISSION", length = 200)
	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}


    @Column(name="parent_id")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


}
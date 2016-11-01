package com.mheath.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * OrgDict entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "org_dict", catalog = "mheath")
public class OrgDict implements java.io.Serializable {

	// Fields

	private String id;
	private String orgName;
	private String zipCode;
	private String address;
	private String phoneNo;

	// Constructors

	/** default constructor */
	public OrgDict() {
	}

	/** full constructor */
	public OrgDict(String orgName, String zipCode, String address,
			String phoneNo) {
		this.orgName = orgName;
		this.zipCode = zipCode;
		this.address = address;
		this.phoneNo = phoneNo;
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

	@Column(name = "org_name", length = 200)
	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(name = "zip_code", length = 6)
	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone_no", length = 100)
	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
package com.mheath.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * UserDict entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_dict", catalog = "mheath")
public class UserDict implements java.io.Serializable {

	// Fields

	private String id;
	private String userName;
	private String password;
	private String name;
	private String sex;
	private String orgId;
    private String salt ;

	// Constructors

	/** default constructor */
	public UserDict() {
	}

	/** full constructor */
	public UserDict(String userName, String password, String name, String sex,
                    String orgId, String salt) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.orgId = orgId;
        this.salt = salt;
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

	@Column(name = "user_name", length = 200)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", length = 200)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sex", length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "org_id", length = 64)
	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

    @Column(name="salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
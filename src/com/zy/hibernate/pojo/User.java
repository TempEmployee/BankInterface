package com.zy.hibernate.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "bankinterface", uniqueConstraints = @UniqueConstraint(columnNames = "utel"))
public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String utel;
	private Float balance;
	private String upwd;
	private String upaypwd;
	private Set<Input> inputsForSourceUid = new HashSet<Input>(0);
	private Set<Output> outputsForTargetUid = new HashSet<Output>(0);
	private Set<Output> outputsForUid = new HashSet<Output>(0);
	private Set<Input> inputsForUid = new HashSet<Input>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String uname, String utel, Float balance, String upwd,
			String upaypwd) {
		this.uname = uname;
		this.utel = utel;
		this.balance = balance;
		this.upwd = upwd;
		this.upaypwd = upaypwd;
	}

	/** full constructor */
	public User(String uname, String utel, Float balance, String upwd,
			String upaypwd, Set<Input> inputsForSourceUid,
			Set<Output> outputsForTargetUid, Set<Output> outputsForUid,
			Set<Input> inputsForUid) {
		this.uname = uname;
		this.utel = utel;
		this.balance = balance;
		this.upwd = upwd;
		this.upaypwd = upaypwd;
		this.inputsForSourceUid = inputsForSourceUid;
		this.outputsForTargetUid = outputsForTargetUid;
		this.outputsForUid = outputsForUid;
		this.inputsForUid = inputsForUid;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "uid", unique = true, nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "uname", nullable = false, length = 45)
	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Column(name = "utel", unique = true, nullable = false, length = 20)
	public String getUtel() {
		return this.utel;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}

	@Column(name = "balance", nullable = false, precision = 12, scale = 0)
	public Float getBalance() {
		return this.balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	@Column(name = "upwd", nullable = false, length = 45)
	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	@Column(name = "upaypwd", nullable = false, length = 45)
	public String getUpaypwd() {
		return this.upaypwd;
	}

	public void setUpaypwd(String upaypwd) {
		this.upaypwd = upaypwd;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userBySourceUid")
	public Set<Input> getInputsForSourceUid() {
		return this.inputsForSourceUid;
	}

	public void setInputsForSourceUid(Set<Input> inputsForSourceUid) {
		this.inputsForSourceUid = inputsForSourceUid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByTargetUid")
	public Set<Output> getOutputsForTargetUid() {
		return this.outputsForTargetUid;
	}

	public void setOutputsForTargetUid(Set<Output> outputsForTargetUid) {
		this.outputsForTargetUid = outputsForTargetUid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUid")
	public Set<Output> getOutputsForUid() {
		return this.outputsForUid;
	}

	public void setOutputsForUid(Set<Output> outputsForUid) {
		this.outputsForUid = outputsForUid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUid")
	public Set<Input> getInputsForUid() {
		return this.inputsForUid;
	}

	public void setInputsForUid(Set<Input> inputsForUid) {
		this.inputsForUid = inputsForUid;
	}

}
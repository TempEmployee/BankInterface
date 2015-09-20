package com.zy.hibernate.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Output entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "output", catalog = "bankinterface")
public class Output implements java.io.Serializable {

	// Fields

	private Integer opid;
	private User userByTargetUid;
	private User userByUid;
	private Float opMoney;
	private Timestamp opTime;
	private String opState;

	// Constructors

	/** default constructor */
	public Output() {
	}

	/** full constructor */
	public Output(User userByTargetUid, User userByUid, Float opMoney,
			Timestamp opTime, String opState) {
		this.userByTargetUid = userByTargetUid;
		this.userByUid = userByUid;
		this.opMoney = opMoney;
		this.opTime = opTime;
		this.opState = opState;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "opid", unique = true, nullable = false)
	public Integer getOpid() {
		return this.opid;
	}

	public void setOpid(Integer opid) {
		this.opid = opid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "target_uid", nullable = false)
	public User getUserByTargetUid() {
		return this.userByTargetUid;
	}

	public void setUserByTargetUid(User userByTargetUid) {
		this.userByTargetUid = userByTargetUid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid", nullable = false)
	public User getUserByUid() {
		return this.userByUid;
	}

	public void setUserByUid(User userByUid) {
		this.userByUid = userByUid;
	}

	@Column(name = "op_money", nullable = false, precision = 12, scale = 0)
	public Float getOpMoney() {
		return this.opMoney;
	}

	public void setOpMoney(Float opMoney) {
		this.opMoney = opMoney;
	}

	@Column(name = "op_time", nullable = false, length = 19)
	public Timestamp getOpTime() {
		return this.opTime;
	}

	public void setOpTime(Timestamp opTime) {
		this.opTime = opTime;
	}

	@Column(name = "op_state", nullable = false, length = 6)
	public String getOpState() {
		return this.opState;
	}

	public void setOpState(String opState) {
		this.opState = opState;
	}

}
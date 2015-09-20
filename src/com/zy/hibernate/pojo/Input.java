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
 * Input entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "input", catalog = "bankinterface")
public class Input implements java.io.Serializable {

	// Fields

	private Integer ipid;
	private User userBySourceUid;
	private User userByUid;
	private Float ipMoney;
	private Timestamp ipTime;
	private String ipState;

	// Constructors

	/** default constructor */
	public Input() {
	}

	/** full constructor */
	public Input(User userBySourceUid, User userByUid, Float ipMoney,
			Timestamp ipTime, String ipState) {
		this.userBySourceUid = userBySourceUid;
		this.userByUid = userByUid;
		this.ipMoney = ipMoney;
		this.ipTime = ipTime;
		this.ipState = ipState;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ipid", unique = true, nullable = false)
	public Integer getIpid() {
		return this.ipid;
	}

	public void setIpid(Integer ipid) {
		this.ipid = ipid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source_uid", nullable = false)
	public User getUserBySourceUid() {
		return this.userBySourceUid;
	}

	public void setUserBySourceUid(User userBySourceUid) {
		this.userBySourceUid = userBySourceUid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid", nullable = false)
	public User getUserByUid() {
		return this.userByUid;
	}

	public void setUserByUid(User userByUid) {
		this.userByUid = userByUid;
	}

	@Column(name = "ip_money", nullable = false, precision = 12, scale = 0)
	public Float getIpMoney() {
		return this.ipMoney;
	}

	public void setIpMoney(Float ipMoney) {
		this.ipMoney = ipMoney;
	}

	@Column(name = "ip_time", nullable = false, length = 19)
	public Timestamp getIpTime() {
		return this.ipTime;
	}

	public void setIpTime(Timestamp ipTime) {
		this.ipTime = ipTime;
	}

	@Column(name = "ip_state", nullable = false, length = 6)
	public String getIpState() {
		return this.ipState;
	}

	public void setIpState(String ipState) {
		this.ipState = ipState;
	}

}
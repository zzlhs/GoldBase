package com.zzl.es.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cst_customer")
public class Customer implements Serializable{
	
	/**
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) 主键生成策略
	 * 
	 * IDENTITY 
	 * TABLE
	 * SEQUENCE
	 * AUTO
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id", length = 32)
	private Long custId;
	@Column(name = "cust_name", length = 32)
	private String custName;
	@Column(name = "cust_source", length = 32)
	private String custSource;
	@Column(name = "cust_industry", length = 32)
	private String custIndustry;
	@Column(name = "cust_level", length = 32)
	private String custLevel;
	@Column(name = "cust_address", length = 32)
	private String custAddress;
	@Column(name = "cust_phone", length = 32)
	private String custPhone;
	
	
	
	public Customer() {
		super();
	}
	
	public Customer(String custName, String custSource, String custIndustry, String custLevel,
			String custAddress, String custPhone) {
		super();
		this.custName = custName;
		this.custSource = custSource;
		this.custIndustry = custIndustry;
		this.custLevel = custLevel;
		this.custAddress = custAddress;
		this.custPhone = custPhone;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custSource=" + custSource
				+ ", custIndustry=" + custIndustry + ", custLevel=" + custLevel + ", custAddress=" + custAddress
				+ ", custPhone=" + custPhone + "]";
	}
	
}

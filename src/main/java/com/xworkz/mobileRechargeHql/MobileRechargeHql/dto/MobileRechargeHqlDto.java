package com.xworkz.mobileRechargeHql.MobileRechargeHql.dto;

import javax.persistence.*;

import com.xworkz.mobileRechargeHql.MobileRechargeHql.enums.RechargeType;
import com.xworkz.mobileRechargeHql.MobileRechargeHql.enums.ServiceProvider;

@Entity
@Table(name = "mobile_recharge", schema= "hibernate")
public class MobileRechargeHqlDto {

	@Id
	@Column(name = "id")
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "serviceProvider")
	private ServiceProvider serviceProvider;
	
	@Column(name = "number")
	private long number;
	
	@Column(name = "plan")
	private double plan;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "rechargeType")
	private RechargeType type;

	public MobileRechargeHqlDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MobileRechargeHqlDto(int id, ServiceProvider serviceProvider, long number, double plan, RechargeType type) {
		super();
		this.id = id;
		this.serviceProvider = serviceProvider;
		this.number = number;
		this.plan = plan;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public double getPlan() {
		return plan;
	}

	public void setPlan(double plan) {
		this.plan = plan;
	}

	public RechargeType getType() {
		return type;
	}

	public void setType(RechargeType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "MobileRechargeHqlDto [id=" + id + ", serviceProvider=" + serviceProvider + ", number=" + number
				+ ", plan=" + plan + ", type=" + type + "]";
	}
}

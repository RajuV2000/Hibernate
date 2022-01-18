package com.xworkz.xworkzapp.MobileRecharge.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xworkz.xworkzapp.MobileRecharge.enums.RechargeType;
import com.xworkz.xworkzapp.MobileRecharge.enums.SeviceProvider;

@Entity
@Table(name="mobile_recharge", schema="hibernate")
public class MobileRechargeDto {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "serviceProvider")
	@Enumerated(EnumType.STRING)
	private SeviceProvider serviceProvider;
	
	@Column(name = "number")
	private long number;
	
	@Column(name = "plan")
	private double plan;
	
	@Column(name = "rechargeType")
	@Enumerated(EnumType.STRING)
	private RechargeType rechargeType;
	
	public MobileRechargeDto()
	{
		super();
	}

	public MobileRechargeDto(int id, SeviceProvider serviceProvider, long number, double plan,
			RechargeType rechargeType) {
		super();
		this.id = id;
		this.serviceProvider = serviceProvider;
		this.number = number;
		this.plan = plan;
		this.rechargeType = rechargeType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SeviceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(SeviceProvider serviceProvider) {
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

	public RechargeType getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(RechargeType rechargeType) {
		this.rechargeType = rechargeType;
	}

	@Override
	public String toString() {
		return "MobileRechargeDto [id=" + id + ", serviceProvider=" + serviceProvider + ", number=" + number + ", plan="
				+ plan + ", rechargeType=" + rechargeType + "]";
	}
}

package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class InjuryCentre {
	@Id
	@GeneratedValue
	
	private int injuryId;
	@NotNull
	@Size(min=3,max=20)
	private String personName;
	
	
    @Size(min=3,max=400)
	private  String personAddress;
	
    @Size(min=3,max=400)
	private  String report;
	
	@Size(min=10,max=11)
	private String mobile;
	public InjuryCentre() {
		super();
	}

	public int getInjuryId() {
		return injuryId;
	}

	public void setInjuryId(int injuryId) {
		this.injuryId = injuryId;
	}

	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonAddress() {
		return personAddress;
	}
	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}


}

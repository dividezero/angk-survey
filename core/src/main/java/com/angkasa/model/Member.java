package com.angkasa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * @author <a href="mailto:hazlan@gmail.com">Hazlan Rozaimi</a>
 */
@Entity
@Table(name = "member")
@Indexed
@XmlRootElement
public class Member extends BaseObject implements Serializable {
	private static final long serialVersionUID = 3832626162173359516L;

	private Long id;
	private String name;
	private String description;
	private Address address = new Address();

	private String phoneNo;
	private Long coopId;
	private Coop coop;
	private String gender; // Constants.GENDER_MALE or Constants.GENDER_FEMALE
	private String icNumber;
	private String membershipNo;
	private Integer version;
	private boolean enabled = true;

	public Member() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 50)
	@Field
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = true, length = 200)
	@Field
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Embedded
	@IndexedEmbedded
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "phoneNo", nullable = false, length = 12)
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "coop_id", nullable = true)
	public Long getCoopId() {
		return coopId;
	}

	public void setCoopId(Long coopId) {
		this.coopId = coopId;
	}

	@ManyToOne
    @JoinColumn(name = "coop_id", referencedColumnName = "id", insertable = false, updatable = false)
	public Coop getCoop() {
		return coop;
	}

	public void setCoop(Coop coop) {
		this.coop = coop;
	}

	@Column(name = "gender", nullable = false, length = 1)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "icNumber", nullable = false, length = 12)
	public String getIcNumber() {
		return icNumber;
	}

	public void setIcNumber(String icNumber) {
		this.icNumber = icNumber;
	}

	@Column(name = "membershipNo", nullable = false, length = 15)
	public String getMembershipNo() {
		return membershipNo;
	}

	public void setMembershipNo(String membershipNo) {
		this.membershipNo = membershipNo;
	}

	@Version
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name = "enabled")
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((coop == null) ? 0 : coop.hashCode());
		result = prime * result + ((coopId == null) ? 0 : coopId.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result
				+ ((icNumber == null) ? 0 : icNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((membershipNo == null) ? 0 : membershipNo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (coop == null) {
			if (other.coop != null)
				return false;
		} else if (!coop.equals(other.coop))
			return false;
		if (coopId == null) {
			if (other.coopId != null)
				return false;
		} else if (!coopId.equals(other.coopId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enabled != other.enabled)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (icNumber == null) {
			if (other.icNumber != null)
				return false;
		} else if (!icNumber.equals(other.icNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (membershipNo == null) {
			if (other.membershipNo != null)
				return false;
		} else if (!membershipNo.equals(other.membershipNo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", description="
				+ description + ", address=" + address + ", phoneNo=" + phoneNo
				+ ", coopId=" + coopId + ", coop=" + coop + ", gender="
				+ gender + ", icNumber=" + icNumber + ", membershipNo="
				+ membershipNo + ", version=" + version + ", enabled="
				+ enabled + "]";
	}

}

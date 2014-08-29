package com.angkasa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * @author <a href="mailto:hazlan@gmail.com">Hazlan Rozaimi</a>
 */
@Entity
@Table(name = "coop")
@Indexed
@XmlRootElement
public class Coop extends BaseObject implements Serializable {
	private static final long serialVersionUID = 3832626162173359416L;

	private Long id;
	private String name;
	private String description;
	private Address address = new Address();
	private Set<ContactPerson> contactPersons;

	private String phoneNo;
	private String phoneNo2;
	private String phoneNo3;

	private String coopCode;
	private Set<CoopBusinessType> coopBusinessTypes;

	private Date incorporatedDate;
	private Integer version;
	private boolean enabled;

	public Coop() {

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

	@OneToMany(targetEntity = ContactPerson.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "contactPerson_id", updatable = false)
	public Set<ContactPerson> getContactPersons() {
		return contactPersons;
	}

	public void setContactPersons(Set<ContactPerson> contactPersons) {
		this.contactPersons = contactPersons;
	}

	@Column(name = "phoneNo", nullable = false, length = 12)
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "phoneNo2", nullable = true, length = 12)
	public String getPhoneNo2() {
		return phoneNo2;
	}

	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}

	@Column(name = "phoneNo3", nullable = true, length = 12)
	public String getPhoneNo3() {
		return phoneNo3;
	}

	public void setPhoneNo3(String phoneNo3) {
		this.phoneNo3 = phoneNo3;
	}

	@Column(name = "coopCode", nullable = false, unique = true, length = 3)
	@Field
	public String getCoopCode() {
		return coopCode;
	}

	public void setCoopId(String coopCode) {
		this.coopCode = coopCode;
	}

	@OneToMany(targetEntity = CoopBusinessType.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "coopBusinessType_id", updatable = false)
	public Set<CoopBusinessType> getCoopBusinessTypes() {
		return coopBusinessTypes;
	}

	public void setCoopBusinessTypes(Set<CoopBusinessType> coopBusinessTypes) {
		this.coopBusinessTypes = coopBusinessTypes;
	}

	@Column(name = "incorporatedDate", nullable = true)
	@Temporal(javax.persistence.TemporalType.DATE)
	public Date getIncorporatedDate() {
		return incorporatedDate;
	}

	public void setIncorporatedDate(Date incorporatedDate) {
		this.incorporatedDate = incorporatedDate;
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
		result = prime * result
				+ ((contactPersons == null) ? 0 : contactPersons.hashCode());
		result = prime
				* result
				+ ((coopBusinessTypes == null) ? 0 : coopBusinessTypes
						.hashCode());
		result = prime * result + ((coopCode == null) ? 0 : coopCode.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((incorporatedDate == null) ? 0 : incorporatedDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		result = prime * result
				+ ((phoneNo2 == null) ? 0 : phoneNo2.hashCode());
		result = prime * result
				+ ((phoneNo3 == null) ? 0 : phoneNo3.hashCode());
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
		Coop other = (Coop) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (contactPersons == null) {
			if (other.contactPersons != null)
				return false;
		} else if (!contactPersons.equals(other.contactPersons))
			return false;
		if (coopBusinessTypes == null) {
			if (other.coopBusinessTypes != null)
				return false;
		} else if (!coopBusinessTypes.equals(other.coopBusinessTypes))
			return false;
		if (coopCode == null) {
			if (other.coopCode != null)
				return false;
		} else if (!coopCode.equals(other.coopCode))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enabled != other.enabled)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (incorporatedDate == null) {
			if (other.incorporatedDate != null)
				return false;
		} else if (!incorporatedDate.equals(other.incorporatedDate))
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
		if (phoneNo2 == null) {
			if (other.phoneNo2 != null)
				return false;
		} else if (!phoneNo2.equals(other.phoneNo2))
			return false;
		if (phoneNo3 == null) {
			if (other.phoneNo3 != null)
				return false;
		} else if (!phoneNo3.equals(other.phoneNo3))
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
		return "Coop [id=" + id + ", name=" + name + ", description="
				+ description + ", address=" + address + ", contactPersons="
				+ contactPersons + ", phoneNo=" + phoneNo + ", phoneNo2="
				+ phoneNo2 + ", phoneNo3=" + phoneNo3 + ", coopId=" + coopCode
				+ ", coopBusinessTypes=" + coopBusinessTypes
				+ ", incorporatedDate=" + incorporatedDate + ", version="
				+ version + ", enabled=" + enabled + "]";
	}

}

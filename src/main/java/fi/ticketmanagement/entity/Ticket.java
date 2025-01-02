package fi.ticketmanagement.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tickettable")
public class Ticket {
	
	@Id
	@Column(name="ticketid")
	int ticketId;
	
	@Column(name="registeredphone")
	String registeredPhone;
	
	@Column(name="category")
	@Enumerated(EnumType.STRING)
	categoryEnum category;
	
	@Column(name="issuedetails")
	String issueDetails;
	
	@Column(name="resolutiondetails")
	String resolutionDetails;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	statusEnum status;
	
	@Column(name="createdate")
	Date createDate;
	
	@Column(name="resolutiondate")
	Date resolutionDate;
	

	public Ticket() {
		super();
	}

	public Ticket(int ticketId, String registeredPhone, categoryEnum category, String issueDetails,
			String resolutionDetails, statusEnum status, Date createDate, Date resolutionDate) {
		super();
		this.ticketId = ticketId;
		this.registeredPhone = registeredPhone;
		this.category = category;
		this.issueDetails = issueDetails;
		this.resolutionDetails = resolutionDetails;
		this.status = status;
		this.createDate = createDate;
		this.resolutionDate = resolutionDate;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getRegisteredPhone() {
		return registeredPhone;
	}

	public void setRegisteredPhone(String registeredPhone) {
		this.registeredPhone = registeredPhone;
	}

	public categoryEnum getCategory() {
		return category;
	}

	public void setCategory(categoryEnum category) {
		this.category = category;
	}

	public String getIssueDetails() {
		return issueDetails;
	}

	public void setIssueDetails(String issueDetails) {
		this.issueDetails = issueDetails;
	}

	public String getResolutionDetails() {
		return resolutionDetails;
	}

	public void setResolutionDetails(String resolutionDetails) {
		this.resolutionDetails = resolutionDetails;
	}

	public statusEnum getStatus() {
		return status;
	}

	public void setStatus(statusEnum status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getResolutionDate() {
		return resolutionDate;
	}

	public void setResolutionDate(Date resolutionDate) {
		this.resolutionDate = resolutionDate;
	}
}

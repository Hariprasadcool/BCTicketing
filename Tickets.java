package com.hp.bc.tickets.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tickets")
public class Tickets implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long defectID; 
	
	@Column(name="ieTickets")
	private Integer ieTickets;
	
	@Column(name="serviceID")
	private String serviceID;
	
	@Column(name="pmtTime")
	private String pmtTime;
	
	@Column(name="qcID")
	private Integer qcID;
	
	@Column(name="tdpID")
	private Integer tdpID;
	
	@Column(name="summaryID")
	private String summaryID;
	
	@Column(name="openDateID")
	private String openDateID;
	
	@Column(name="estDateID")
	private String estDateID;
	
	@Column(name="ownerID")
	private String ownerID;
	
	@Column(name="priorityID")
	private String priorityID;
	
	@Column(name="statusID")
	private String statusID;
	
	@Column(name="issuetypeID")
	private String issuetypeID;
	
	@Column(name="categoryID")
	private String categoryID;
	
	@Column(name="commentsID")
	private String commentsID;
	
	@Column(name="workstreamID")
	private String workstreamID;
	
	@Column(name="macdID")
	private String macdID;
	
	@Column(name="pocID")
	private String pocID;
	
	@Column(name="ageID")
	private Integer ageID;
	
	@Column(name="flag")
	private boolean flag;


	/**
	 * @return the defectID
	 */
	public long getDefectID() {
		return defectID;
	}

	/**
	 * @param defectID the defectID to set
	 */
	public void setDefectID(long defectID) {
		this.defectID = defectID;
	}

	/**
	 * @return the ieTickets
	 */
	public Integer getIeTickets() {
		return ieTickets;
	}

	/**
	 * @param ieTickets the ieTickets to set
	 */
	public void setIeTickets(Integer ieTickets) {
		this.ieTickets = ieTickets;
	}

	/**
	 * @return the serviceID
	 */
	public String getServiceID() {
		return serviceID;
	}

	/**
	 * @param serviceID the serviceID to set
	 */
	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}


	/**
	 * @return the pmtTime
	 */
	public String getPmtTime() {
		return pmtTime;
	}

	/**
	 * @param pmtTime the pmtTime to set
	 */
	public void setPmtTime(String pmtTime) {
		this.pmtTime = pmtTime;
	}

	/**
	 * @return the qcID
	 */
	public Integer getQcID() {
		return qcID;
	}

	/**
	 * @param qcID the qcID to set
	 */
	public void setQcID(Integer qcID) {
		this.qcID = qcID;
	}

	/**
	 * @return the tdpID
	 */
	public Integer getTdpID() {
		return tdpID;
	}

	/**
	 * @param tdpID the tdpID to set
	 */
	public void setTdpID(Integer tdpID) {
		this.tdpID = tdpID;
	}

	/**
	 * @return the summaryID
	 */
	public String getSummaryID() {
		return summaryID;
	}

	/**
	 * @param summaryID the summaryID to set
	 */
	public void setSummaryID(String summaryID) {
		this.summaryID = summaryID;
	}

	/**
	 * @return the openDateID
	 */
	public String getOpenDateID() {
		return openDateID;
	}

	/**
	 * @param openDateID the openDateID to set
	 */
	public void setOpenDateID(String openDateID) {
		this.openDateID = openDateID;
	}

	/**
	 * @return the estDateID
	 */
	public String getEstDateID() {
		return estDateID;
	}

	/**
	 * @param estDateID the estDateID to set
	 */
	public void setEstDateID(String estDateID) {
		this.estDateID = estDateID;
	}

	/**
	 * @return the ownerID
	 */
	public String getOwnerID() {
		return ownerID;
	}

	/**
	 * @param ownerID the ownerID to set
	 */
	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}

	/**
	 * @return the priorityID
	 */
	public String getPriorityID() {
		return priorityID;
	}

	/**
	 * @param priorityID the priorityID to set
	 */
	public void setPriorityID(String priorityID) {
		this.priorityID = priorityID;
	}

	/**
	 * @return the statusID
	 */
	public String getStatusID() {
		return statusID;
	}

	/**
	 * @param statusID the statusID to set
	 */
	public void setStatusID(String statusID) {
		this.statusID = statusID;
	}

	/**
	 * @return the issuetypeID
	 */
	public String getIssuetypeID() {
		return issuetypeID;
	}

	/**
	 * @param issuetypeID the issuetypeID to set
	 */
	public void setIssuetypeID(String issuetypeID) {
		this.issuetypeID = issuetypeID;
	}

	/**
	 * @return the categoryID
	 */
	public String getCategoryID() {
		return categoryID;
	}

	/**
	 * @param categoryID the categoryID to set
	 */
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	/**
	 * @return the commentsID
	 */
	public String getCommentsID() {
		return commentsID;
	}

	/**
	 * @param commentsID the commentsID to set
	 */
	public void setCommentsID(String commentsID) {
		this.commentsID = commentsID;
	}

	/**
	 * @return the workstreamID
	 */
	public String getWorkstreamID() {
		return workstreamID;
	}

	/**
	 * @param workstreamID the workstreamID to set
	 */
	public void setWorkstreamID(String workstreamID) {
		this.workstreamID = workstreamID;
	}

	/**
	 * @return the macdID
	 */
	public String getMacdID() {
		return macdID;
	}

	/**
	 * @param macdID the macdID to set
	 */
	public void setMacdID(String macdID) {
		this.macdID = macdID;
	}

	/**
	 * @return the pocID
	 */
	public String getPocID() {
		return pocID;
	}

	/**
	 * @param pocID the pocID to set
	 */
	public void setPocID(String pocID) {
		this.pocID = pocID;
	}

	/**
	 * @return the ageID
	 */
	public Integer getAgeID() {
		return ageID;
	}

	/**
	 * @param ageID the ageID to set
	 */
	public void setAgeID(Integer ageID) {
		this.ageID = ageID;
	}

	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	
	
	public Object isActive() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setActive(Object active) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tickets [defectID=" + defectID + ", " + (ieTickets != null ? "ieTickets=" + ieTickets + ", " : "")
				+ (serviceID != null ? "serviceID=" + serviceID + ", " : "")
				+ (pmtTime != null ? "pmtTime=" + pmtTime + ", " : "") + (qcID != null ? "qcID=" + qcID + ", " : "")
				+ (tdpID != null ? "tdpID=" + tdpID + ", " : "")
				+ (summaryID != null ? "summaryID=" + summaryID + ", " : "")
				+ (openDateID != null ? "openDateID=" + openDateID + ", " : "")
				+ (estDateID != null ? "estDateID=" + estDateID + ", " : "")
				+ (ownerID != null ? "ownerID=" + ownerID + ", " : "")
				+ (priorityID != null ? "priorityID=" + priorityID + ", " : "")
				+ (statusID != null ? "statusID=" + statusID + ", " : "")
				+ (issuetypeID != null ? "issuetypeID=" + issuetypeID + ", " : "")
				+ (categoryID != null ? "categoryID=" + categoryID + ", " : "")
				+ (commentsID != null ? "commentsID=" + commentsID + ", " : "")
				+ (workstreamID != null ? "workstreamID=" + workstreamID + ", " : "")
				+ (macdID != null ? "macdID=" + macdID + ", " : "") + (pocID != null ? "pocID=" + pocID + ", " : "")
				+ (ageID != null ? "ageID=" + ageID + ", " : "") + "flag=" + flag + "]";
	}

	
}

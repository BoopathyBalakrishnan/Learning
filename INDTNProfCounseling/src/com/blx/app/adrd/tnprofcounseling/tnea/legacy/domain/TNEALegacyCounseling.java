package com.blx.app.adrd.tnprofcounseling.tnea.legacy.domain;

public class TNEALegacyCounseling {
	private int collegeRank;
	private int collegeCode;
	private String collegeName;
	private String department;
	private float cutOffMark;
	private long yearRank;

	public int getCollegeRank() {
		return collegeRank;
	}

	public void setCollegeRank(int collegeRank) {
		this.collegeRank = collegeRank;
	}

	public int getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(int collegeCode) {
		this.collegeCode = collegeCode;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public float getCutOffMark() {
		return cutOffMark;
	}

	public void setCutOffMark(float cutOffMark) {
		this.cutOffMark = cutOffMark;
	}

	public long getYearRank() {
		return yearRank;
	}

	public void setYearRank(long yearRank) {
		this.yearRank = yearRank;
	}

}

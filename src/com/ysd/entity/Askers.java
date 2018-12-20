package com.ysd.entity;

public class Askers {
	private String AskerId;
	private String AskerName;
	private String CheckState;
	private String CheckInTime;
	private String ChangeState;
	private int  Weight;
	private String RoleName;
	private String BakContent;
	public String getAskerId() {
		return AskerId;
	}
	public void setAskerId(String askerId) {
		AskerId = askerId;
	}
	public String getAskerName() {
		return AskerName;
	}
	public void setAskerName(String askerName) {
		AskerName = askerName;
	}
	public String getCheckState() {
		return CheckState;
	}
	public void setCheckState(String checkState) {
		CheckState = checkState;
	}
	public String getCheckInTime() {
		return CheckInTime;
	}
	public void setCheckInTime(String checkInTime) {
		CheckInTime = checkInTime;
	}
	public String getChangeState() {
		return ChangeState;
	}
	public void setChangeState(String changeState) {
		ChangeState = changeState;
	}
	public int getWeight() {
		return Weight;
	}
	public void setWeight(int weight) {
		Weight = weight;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	public String getBakContent() {
		return BakContent;
	}
	public void setBakContent(String bakContent) {
		BakContent = bakContent;
	}
	@Override
	public String toString() {
		return "askers [AskerId=" + AskerId + ", AskerName=" + AskerName
				+ ", CheckState=" + CheckState + ", CheckInTime=" + CheckInTime
				+ ", ChangeState=" + ChangeState + ", Weight=" + Weight
				+ ", RoleName=" + RoleName + ", BakContent=" + BakContent + "]";
	}
	
	
	
	
	

}

package project1;

public class meetingVO {

	int meetID;
	String memID;
	String meetName;
	int personnel;
	String meetInter;
	
	public meetingVO(int meetID, String memID, String meetName, int personnel, String meetInter) {
		this.meetID = meetID;
		this.memID = memID;
		this.meetName = meetName;
		this.personnel = personnel;
		this.meetInter = meetInter;
	}
	
	public meetingVO(String meetName, int personnel, String meetInter) {
		this.meetName = meetName;
		this.personnel = personnel;
		this.meetInter = meetInter;
	}




	public int getMeetID() {
		return meetID;
	}

	public void setMeetID(int meetID) {
		this.meetID = meetID;
	}

	public String getMemID() {
		return memID;
	}

	public void setMemID(String memID) {
		this.memID = memID;
	}

	public String getMeetName() {
		return meetName;
	}

	public void setMeetName(String meetName) {
		this.meetName = meetName;
	}

	public int getPersonnel() {
		return personnel;
	}

	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}

	public String getMeetInter() {
		return meetInter;
	}

	public void setMeetInter(String meetInter) {
		this.meetInter = meetInter;
	}
	
	
	
	
}

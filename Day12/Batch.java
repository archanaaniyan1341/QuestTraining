
public class Batch {
private int batchID;
private String batchName;
private String courses;
private int facultyID;
private int feeDetails;

public int getBatchID() {
	return batchID;
}
public void setBatchID(int batchID) {
	this.batchID = batchID;
}
public String getBatchName() {
	return batchName;
}
public void setBatchName(String batchName) {
	this.batchName = batchName;
}
public String getCourses() {
	return courses;
}
public void setCourses(String courses) {
	this.courses = courses;
}
public int getFacultyID() {
	return facultyID;
}
public void setFacultyID(int facultyID) {
	this.facultyID = facultyID;
}
public int getFeeDetails() {
	return feeDetails;
}
public void setFeeDetails(int feeDetails) {
	this.feeDetails = feeDetails;
}
public String toString() {
	return this.getBatchID()+" "+this.getBatchName()+" "+this.getCourses()+" "+this.getFacultyID()+" "+this.getFeeDetails();
}

}

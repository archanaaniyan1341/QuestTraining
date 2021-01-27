
public class Teacher {
private int facultyID;
private String facultyName;
private String designation;
private int contact;
private String email;

public int getFacultyID() {
	return facultyID;
}
public void setFacultyID(int facultyID) {
	this.facultyID = facultyID;
}
public String getFacultyName() {
	return facultyName;
}
public void setFacultyName(String facultyName) {
	this.facultyName = facultyName;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public int getContact() {
	return contact;
}
public void setContact(int contact) {
	this.contact = contact;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String toString() {
	return this.getFacultyID()+" "+this.getFacultyName()+" "+this.getDesignation()+" "+this.getContact()+" "+this.getEmail();
}
}

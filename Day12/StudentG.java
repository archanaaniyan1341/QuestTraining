
public class StudentG {
private int studentID;
private String name;
private int batchID;
private int phone;
private String email;
private String paymentStatus;

public int getStudentID() {
	return studentID;
}
public void setStudentID(int studentID) {
	this.studentID = studentID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getBatchID() {
	return batchID;
}
public void setBatchID(int batchID) {
	this.batchID = batchID;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPaymentStatus() {
	return paymentStatus;
}
public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}
public String toString() {
	return this.getStudentID()+" "+this.getName()+" "+this.getBatchID()+" "+this.getPhone()+" "+this.getEmail()+" "+this.getPaymentStatus();
}
}

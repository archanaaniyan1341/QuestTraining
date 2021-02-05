package managementdao;

public class Batch {
private int batchID;
private String batchName;
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
public int getFeeDetails() {
	return feeDetails;
}
public void setFeeDetails(int feeDetails) {
	this.feeDetails = feeDetails;
}
public String toString() {
	return this.getBatchID()+" "+this.getBatchName()+" "+this.getFeeDetails();
}

}


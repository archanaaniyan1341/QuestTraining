
public class Student {
	private int id;
	private String name;
	private String gender;
	private String stream;
	private int marks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
public String toString() {
	return "id:"+this.getId() +", name:"+ this.getName()+", gender:" + this.getGender()+", stream:"+this.getStream()+", marks:"+this.getMarks();
}	

}

package managementdao;

public class Teacher {
	private String teacher_id;
	private String name;
	private String designation;
	private int batch_id;

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}

	public String toString() {
		return this.getTeacher_id() + " " + this.getName() + " " + this.getDesignation() + " " + this.getBatch_id();
	}
}

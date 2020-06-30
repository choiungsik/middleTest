package firstproject;

public class MaleVO {

	private String id;
	private String sex;
	private int age;
	private String meet_id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMeet_id() {
		return meet_id;
	}

	public void setMeet_id(String meet_id) {
		this.meet_id = meet_id;
	}

	public MaleVO(String id, String sex, int age, String meet_id) {
		this.id = id;
		this.sex = sex;
		this.age = age;
		this.meet_id = meet_id;
	}

}

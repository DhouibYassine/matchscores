package tn.iit.flashScoreTn.response;

public class PlayerResponse {

	private Long id;
	private String name;
	private int age;
	private String position;
	private String nationality;

	@Override
	public String toString() {
		return "PlayerResponse{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", position='" + position + '\'' +
				", nationality='" + nationality + '\'' +
				'}';
	}

	public PlayerResponse() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}

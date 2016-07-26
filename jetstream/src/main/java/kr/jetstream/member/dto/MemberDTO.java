package kr.jetstream.member.dto;


public class MemberDTO{
	
	private String memberid_pk;
	private String email;
	private String password;
	private String name;
	private String grade_st;
	private String photo;
	
	public MemberDTO(){}

	public MemberDTO(String email, String password, String name) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;

	}
	
	public MemberDTO(String memberid_pk, String email, String password, String name, String grade_st, String photo) {
		super();
		this.memberid_pk = memberid_pk;
		this.email = email;
		this.password = password;
		this.name = name;
		this.grade_st = grade_st;
		this.photo = photo;
	}

	public String getMemberid_pk() {
		return memberid_pk;
	}

	public void setMemberid_pk(String memberid_pk) {
		this.memberid_pk = memberid_pk;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGrade_st() {
		return grade_st;
	}

	public void setGrade_st(String grade_st) {
		this.grade_st = grade_st;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberid_pk=" + memberid_pk + ", email=" + email + ", name=" + name + ", password="
				+ password + ", grade_st=" + grade_st + ", photo=" + photo + "]";
	}

	
	
}



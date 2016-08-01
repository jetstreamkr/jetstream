package kr.jetstream.member.dto;


public class MemberDTO{
	
	private String member_id;
	private String member_st;
	private String email;
	private String password;
	private String member_nm;
	private String photo;
	private String member_dt;
	private String member_init;
	
	public MemberDTO(){}
	
	public MemberDTO(String email, String password, String member_nm, String member_init) {
		this.email = email;
		this.password = password;
		this.member_nm = member_nm;
		this.member_init=member_init;
	}
	
	public MemberDTO(String member_nm, String password, String photo, String email,String member_init){
		this.email = email;
		this.photo = photo;
		this.password = password;
		this.member_nm = member_nm;
		this.member_init=member_init;
	}

	public MemberDTO(String member_id, String member_st, String email, String password, String member_nm, String photo,
			String member_dt) {
		super();
		this.member_id = member_id;
		this.member_st = member_st;
		this.email = email;
		this.password = password;
		this.member_nm = member_nm;
		this.photo = photo;
		this.member_dt = member_dt;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_st() {
		return member_st;
	}

	public void setMember_st(String member_st) {
		this.member_st = member_st;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMember_nm() {
		return member_nm;
	}

	public void setMember_nm(String member_nm) {
		this.member_nm = member_nm;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMember_dt() {
		return member_dt;
	}

	public void setMember_dt(String member_dt) {
		this.member_dt = member_dt;
	}

	public String getMember_init() {
		return member_init;
	}

	public void setMember_init(String member_init) {
		this.member_init = member_init;
	}

	@Override
	public String toString() {
		return "MemberDTO [member_id=" + member_id + ", member_st=" + member_st + ", email=" + email + ", password="
				+ password + ", member_nm=" + member_nm + ", photo=" + photo + ", member_dt=" + member_dt
				+ ", member_init=" + member_init + "]";
	}

}



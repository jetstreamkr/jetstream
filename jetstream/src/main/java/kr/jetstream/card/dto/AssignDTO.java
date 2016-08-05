package kr.jetstream.card.dto;

public class AssignDTO {
	private String card_id;
	private String member_id;
	private String assign_chk;
	private String member_nm;
	private String email;
	private String photo;
	private String member_init;
	private String member_permit;
	
	public AssignDTO(){}
	
	public AssignDTO(String card_id, String member_id, String assign_chk) {
		super();
		this.card_id = card_id;
		this.member_id = member_id;
		this.assign_chk = assign_chk;
	}

	public AssignDTO(String card_id, String member_id, String assign_chk,
			String member_nm, String email, String photo, String member_init, String member_permit) {
		super();
		this.card_id = card_id;
		this.member_id = member_id;
		this.assign_chk = assign_chk;
		this.member_nm = member_nm;
		this.email = email;
		this.photo = photo;
		this.member_init = member_init;
		this.member_permit = member_permit;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getAssign_chk() {
		return assign_chk;
	}

	public void setAssign_chk(String assign_chk) {
		this.assign_chk = assign_chk;
	}

	public String getMember_nm() {
		return member_nm;
	}

	public void setMember_nm(String member_nm) {
		this.member_nm = member_nm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMember_init() {
		return member_init;
	}

	public void setMember_init(String member_init) {
		this.member_init = member_init;
	}

	public String getMember_permit() {
		return member_permit;
	}

	public void setMember_permit(String member_permit) {
		this.member_permit = member_permit;
	}

	@Override
	public String toString() {
		return "AssignDTO [card_id=" + card_id + ", member_id="
				+ member_id + ", assign_chk=" + assign_chk + ", member_nm=" + member_nm + ", email=" + email
				+ ", photo=" + photo + ", member_init=" + member_init + ", member_permit=" + member_permit + "]";
	}

	


}

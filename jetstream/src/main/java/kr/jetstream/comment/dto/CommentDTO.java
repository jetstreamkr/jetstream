package kr.jetstream.comment.dto;

public class CommentDTO {
	private String comment_id;
	private String board_id;
	private String list_id;
	private String card_id;
	private String member_id;
	private String comment_txt;
	private String comment_dt;
	private String comment_st;
	private String member_nm;
	private String photo;
	private String member_init;
	

	public CommentDTO(){}


	public CommentDTO(String comment_id, String board_id, String list_id, String card_id, String member_id,
			String comment_txt, String comment_dt, String comment_st, String member_nm, String photo,
			String member_init) {
		super();
		this.comment_id = comment_id;
		this.board_id = board_id;
		this.list_id = list_id;
		this.card_id = card_id;
		this.member_id = member_id;
		this.comment_txt = comment_txt;
		this.comment_dt = comment_dt;
		this.comment_st = comment_st;
		this.member_nm = member_nm;
		this.photo = photo;
		this.member_init = member_init;
	}


	public String getComment_id() {
		return comment_id;
	}


	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}


	public String getBoard_id() {
		return board_id;
	}


	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}


	public String getList_id() {
		return list_id;
	}


	public void setList_id(String list_id) {
		this.list_id = list_id;
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


	public String getComment_txt() {
		return comment_txt;
	}


	public void setComment_txt(String comment_txt) {
		this.comment_txt = comment_txt;
	}


	public String getComment_dt() {
		return comment_dt;
	}


	public void setComment_dt(String comment_dt) {
		this.comment_dt = comment_dt;
	}


	public String getComment_st() {
		return comment_st;
	}


	public void setComment_st(String comment_st) {
		this.comment_st = comment_st;
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


	public String getMember_init() {
		return member_init;
	}


	public void setMember_init(String member_init) {
		this.member_init = member_init;
	}


	@Override
	public String toString() {
		return "CommentDTO [comment_id=" + comment_id + ", board_id=" + board_id + ", list_id=" + list_id + ", card_id="
				+ card_id + ", member_id=" + member_id + ", comment_txt=" + comment_txt + ", comment_dt=" + comment_dt
				+ ", comment_st=" + comment_st + ", member_nm=" + member_nm + ", photo=" + photo + ", member_init="
				+ member_init + "]";
	}
	
}

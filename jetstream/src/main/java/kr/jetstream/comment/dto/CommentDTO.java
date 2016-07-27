package kr.jetstream.comment.dto;

public class CommentDTO {
	String comment_id;
	String board_id;
	String list_id;
	String card_id;
	String member_id;
	String comment_txt;
	String comment_DT;
	String comment_ST;

	public CommentDTO(){
	
	}

	public CommentDTO(String comment_id, String board_id, String list_id, String card_id, String member_id,
			String comment_txt, String comment_DT, String comment_ST) {
		super();
		this.comment_id = comment_id;
		this.board_id = board_id;
		this.list_id = list_id;
		this.card_id = card_id;
		this.member_id = member_id;
		this.comment_txt = comment_txt;
		this.comment_DT = comment_DT;
		this.comment_ST = comment_ST;
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

	public String getComment_DT() {
		return comment_DT;
	}

	public void setComment_DT(String comment_DT) {
		this.comment_DT = comment_DT;
	}

	public String getComment_ST() {
		return comment_ST;
	}

	public void setComment_ST(String comment_ST) {
		this.comment_ST = comment_ST;
	}
	
	
	
}

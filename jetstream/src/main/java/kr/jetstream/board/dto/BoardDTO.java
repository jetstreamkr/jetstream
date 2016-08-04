package kr.jetstream.board.dto;

public class BoardDTO {
	private String board_id;
	private String member_id;
	private String board_nm;
	private String board_uri;
	private String board_permit;
	private String board_st;
	private String board_start;
	private String board_due;
	private int board_prog;
	private String member_permit;
	private String board_fav;
	private String board_dt;
	
	public BoardDTO(){}

	// board_set.do 보드 소속 멤버 조회용
	public BoardDTO(String board_id, String member_id, String member_permit, String board_fav) {
		super();
		this.board_id = board_id;
		this.member_id = member_id;
		this.member_permit = member_permit;
		this.board_fav = board_fav;
	}

	public BoardDTO(String board_id, String member_id, String board_nm, String board_uri, String board_permit,
			String board_st, String board_start, String board_due, int board_prog, String member_permit,
			String board_fav) {
		super();
		this.board_id = board_id;
		this.member_id = member_id;
		this.board_nm = board_nm;
		this.board_uri = board_uri;
		this.board_permit = board_permit;
		this.board_st = board_st;
		this.board_start = board_start;
		this.board_due = board_due;
		this.board_prog = board_prog;
		this.member_permit = member_permit;
		this.board_fav = board_fav;
	}
	

	public BoardDTO(String board_id, String member_id, String board_nm, String board_uri, String board_permit,
			String board_st, String board_start, String board_due, int board_prog, String member_permit,
			String board_fav, String board_dt) {
		super();
		this.board_id = board_id;
		this.member_id = member_id;
		this.board_nm = board_nm;
		this.board_uri = board_uri;
		this.board_permit = board_permit;
		this.board_st = board_st;
		this.board_start = board_start;
		this.board_due = board_due;
		this.board_prog = board_prog;
		this.member_permit = member_permit;
		this.board_fav = board_fav;
		this.board_dt = board_dt;
	}

	public String getBoard_id() {
		return board_id;
	}

	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getBoard_nm() {
		return board_nm;
	}

	public void setBoard_nm(String board_nm) {
		this.board_nm = board_nm;
	}

	public String getBoard_uri() {
		return board_uri;
	}

	public void setBoard_uri(String board_uri) {
		this.board_uri = board_uri;
	}

	public String getBoard_permit() {
		return board_permit;
	}

	public void setBoard_permit(String board_permit) {
		this.board_permit = board_permit;
	}

	public String getBoard_st() {
		return board_st;
	}

	public void setBoard_st(String board_st) {
		this.board_st = board_st;
	}

	public String getBoard_start() {
		return board_start;
	}

	public void setBoard_start(String board_start) {
		this.board_start = board_start;
	}

	public String getBoard_due() {
		return board_due;
	}

	public void setBoard_due(String board_due) {
		this.board_due = board_due;
	}

	public int getBoard_prog() {
		return board_prog;
	}

	public void setBoard_prog(int board_prog) {
		this.board_prog = board_prog;
	}

	public String getMember_permit() {
		return member_permit;
	}

	public void setMember_permit(String member_permit) {
		this.member_permit = member_permit;
	}

	public String getBoard_fav() {
		return board_fav;
	}

	public void setBoard_fav(String board_fav) {
		this.board_fav = board_fav;
	}
	
	

	public String getBoard_dt() {
		return board_dt;
	}

	public void setBoard_dt(String board_dt) {
		this.board_dt = board_dt;
	}

	@Override
	public String toString() {
		return "BoardDTO [board_id=" + board_id + ", member_id=" + member_id + ", board_nm=" + board_nm + ", board_uri="
				+ board_uri + ", board_permit=" + board_permit + ", board_st=" + board_st + ", board_start="
				+ board_start + ", board_due=" + board_due + ", board_prog=" + board_prog + ", member_permit="
				+ member_permit + ", board_fav=" + board_fav + ", board_dt=" + board_dt + "]";
	}
	
	


}

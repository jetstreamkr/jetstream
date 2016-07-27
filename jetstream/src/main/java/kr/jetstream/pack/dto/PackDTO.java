package kr.jetstream.pack.dto;

public class PackDTO {
	private String board_id;
	private String list_id;
	private String list_nm;
	private int list_loc;
	private String list_st;
	
	public PackDTO(){
		
	}

	public PackDTO(String board_id, String list_id, String list_nm, int list_loc, String list_st) {
		super();
		this.board_id = board_id;
		this.list_id = list_id;
		this.list_nm = list_nm;
		this.list_loc = list_loc;
		this.list_st = list_st;
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

	public String getList_nm() {
		return list_nm;
	}

	public void setList_nm(String list_nm) {
		this.list_nm = list_nm;
	}

	public int getList_loc() {
		return list_loc;
	}

	public void setList_loc(int list_loc) {
		this.list_loc = list_loc;
	}

	public String getList_st() {
		return list_st;
	}

	public void setList_st(String list_st) {
		this.list_st = list_st;
	}

	@Override
	public String toString() {
		return "ListDTO [board_id=" + board_id + ", list_id=" + list_id + ", list_nm=" + list_nm + ", list_loc="
				+ list_loc + ", list_st=" + list_st + "]";
	}
	
}

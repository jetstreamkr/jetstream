package kr.jetstream.board.dto;

public class ProgressDTO {
	private String list_id;
	private String list_nm;
	private String done;
	private String total;
	
	public ProgressDTO(){}

	public ProgressDTO(String list_id, String list_nm, String done, String total) {
		super();
		this.list_id = list_id;
		this.list_nm = list_nm;
		this.done = done;
		this.total = total;
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

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ProgressDTO [list_id=" + list_id + ", list_nm=" + list_nm + ", done=" + done + ", total=" + total + "]";
	}
	


}

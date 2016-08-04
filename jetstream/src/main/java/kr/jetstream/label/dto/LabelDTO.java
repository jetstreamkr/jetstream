package kr.jetstream.label.dto;

public class LabelDTO {
	private String board_id;
	private String label_id;
	private String label_nm;
	private String label_color;
	private String label_order;
	public LabelDTO(){
	}
	
	public LabelDTO(String board_id, String label_id, String label_nm, String label_color, String label_order) {
		super();
		this.board_id = board_id;
		this.label_id = label_id;
		this.label_nm = label_nm;
		this.label_color = label_color;
		this.label_order = label_order;
	}

	public String getBoard_id() {
		return board_id;
	}

	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}

	public String getLabel_id() {
		return label_id;
	}

	public void setLabel_id(String label_id) {
		this.label_id = label_id;
	}

	public String getLabel_nm() {
		return label_nm;
	}

	public void setLabel_nm(String label_nm) {
		this.label_nm = label_nm;
	}

	public String getLabel_color() {
		return label_color;
	}

	public void setLabel_color(String label_color) {
		this.label_color = label_color;
	}

	public String getLabel_order() {
		return label_order;
	}

	public void setLabel_order(String label_order) {
		this.label_order = label_order;
	}

	@Override
	public String toString() {
		return "LableDTO [board_id=" + board_id + ", label_id=" + label_id + ", label_nm=" + label_nm + ", label_color="
				+ label_color + ", label_order=" + label_order + "]";
	}
	
	
	
	
}

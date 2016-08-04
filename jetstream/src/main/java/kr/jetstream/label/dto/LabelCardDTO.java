package kr.jetstream.label.dto;

public class LabelCardDTO {
	private String board_id;
	private String label_id;
	private String card_id;
	private String list_id;
	


	public LabelCardDTO() {
		super();
		
	}
	
	public LabelCardDTO(String board_id, String card_id, String list_id) {
		super();
		this.board_id = board_id;
		this.card_id = card_id;
		this.list_id = list_id;
	}
	
	public LabelCardDTO(String board_id, String label_id, String card_id, String list_id) {
		super();
		this.board_id = board_id;
		this.label_id = label_id;
		this.card_id = card_id;
		this.list_id = list_id;
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

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getList_id() {
		return list_id;
	}

	public void setList_id(String list_id) {
		this.list_id = list_id;
	}

	@Override
	public String toString() {
		return "LabelCardDTO [board_id=" + board_id + ", label_id=" + label_id + ", card_id=" + card_id + ", list_id="
				+ list_id + "]";
	}
	
	

}

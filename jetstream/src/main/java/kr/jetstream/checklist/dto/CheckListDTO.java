package kr.jetstream.checklist.dto;

public class CheckListDTO {
	private String board_id;
	private String list_id;
	private String card_id;
	private String chklist_id;
	private String chklist_txt;
	private String chklist_st;
	
	public CheckListDTO(){}

	public CheckListDTO(String card_id, String chklist_id){
		this.card_id = card_id;
		this.chklist_id = chklist_id;
	}
	
	public CheckListDTO(String board_id,String list_id,String card_id, String chklist_txt){
		this.board_id = board_id;
		this.list_id = list_id;
		this.card_id = card_id;
		this.chklist_txt = chklist_txt;
	}
	
	public CheckListDTO(String board_id, String list_id, String card_id, String chklist_id, String chklist_txt,
			String chklist_st) {
		super();
		this.board_id = board_id;
		this.list_id = list_id;
		this.card_id = card_id;
		this.chklist_id = chklist_id;
		this.chklist_txt = chklist_txt;
		this.chklist_st = chklist_st;
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

	public String getChklist_id() {
		return chklist_id;
	}

	public void setChklist_id(String chklist_id) {
		this.chklist_id = chklist_id;
	}

	public String getChklist_txt() {
		return chklist_txt;
	}

	public void setChklist_txt(String chklist_txt) {
		this.chklist_txt = chklist_txt;
	}

	public String getChklist_st() {
		return chklist_st;
	}

	public void setChklist_st(String chklist_st) {
		this.chklist_st = chklist_st;
	}

	@Override
	public String toString() {
		return "CheckListDTO [board_id=" + board_id + ", list_id=" + list_id + ", card_id=" + card_id + ", chklist_id="
				+ chklist_id + ", chklist_txt=" + chklist_txt + ", chklist_st=" + chklist_st + "]";
	}

}

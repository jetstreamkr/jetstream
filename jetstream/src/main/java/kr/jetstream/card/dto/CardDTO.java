package kr.jetstream.card.dto;

public class CardDTO {
	private String board_id;
	private String list_id;
	private String card_id;
	private String member_id;
	private int card_loc;
	private String card_st;
	private String card_txt;
	private String card_start;
	private String card_due;
	private String card_attach;
	private String card_order;
	private String card_nm;
	private String list_nm;

	public CardDTO() {

	}

	public CardDTO(String card_start, String card_due, String card_nm) {
		super();
		this.card_start = card_start;
		this.card_due = card_due;
		this.card_nm = card_nm;
	}

	public CardDTO(String board_id, String list_id, String card_id, String member_id, int card_loc, String card_st,
			String card_txt, String card_start, String card_due, String card_attach, String card_order,
			String card_nm) {
		super();
		this.board_id = board_id;
		this.list_id = list_id;
		this.card_id = card_id;
		this.member_id = member_id;
		this.card_loc = card_loc;
		this.card_st = card_st;
		this.card_txt = card_txt;
		this.card_start = card_start;
		this.card_due = card_due;
		this.card_attach = card_attach;
		this.card_order = card_order;
		this.card_nm = card_nm;
	}

	public CardDTO(String board_id, String list_id, String card_id, String member_id, int card_loc, String card_st,
			String card_txt, String card_start, String card_due, String card_attach, String card_order, String card_nm,
			String list_nm) {
		super();
		this.board_id = board_id;
		this.list_id = list_id;
		this.card_id = card_id;
		this.member_id = member_id;
		this.card_loc = card_loc;
		this.card_st = card_st;
		this.card_txt = card_txt;
		this.card_start = card_start;
		this.card_due = card_due;
		this.card_attach = card_attach;
		this.card_order = card_order;
		this.card_nm = card_nm;
		this.list_nm = list_nm;
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

	public int getCard_loc() {
		return card_loc;
	}

	public void setCard_loc(int card_loc) {
		this.card_loc = card_loc;
	}

	public String getCard_st() {
		return card_st;
	}

	public void setCard_st(String card_st) {
		this.card_st = card_st;
	}

	public String getCard_txt() {
		return card_txt;
	}

	public void setCard_txt(String card_txt) {
		this.card_txt = card_txt;
	}

	public String getCard_start() {
		return card_start;
	}

	public void setCard_start(String card_start) {
		this.card_start = card_start;
	}

	public String getCard_due() {
		return card_due;
	}

	public void setCard_due(String card_due) {
		this.card_due = card_due;
	}

	public String getCard_attach() {
		return card_attach;
	}

	public void setCard_attach(String card_attach) {
		this.card_attach = card_attach;
	}

	public String getCard_order() {
		return card_order;
	}

	public void setCard_order(String card_order) {
		this.card_order = card_order;
	}

	public String getCard_nm() {
		return card_nm;
	}

	public void setCard_nm(String card_nm) {
		this.card_nm = card_nm;
	}

	public String getList_nm() {
		return list_nm;
	}

	public void setList_nm(String list_nm) {
		this.list_nm = list_nm;
	}

	@Override
	public String toString() {
		return "CardDTO [board_id=" + board_id + ", list_id=" + list_id + ", card_id=" + card_id + ", member_id="
				+ member_id + ", card_loc=" + card_loc + ", card_st=" + card_st + ", card_txt=" + card_txt
				+ ", card_start=" + card_start + ", card_due=" + card_due + ", card_attach=" + card_attach
				+ ", card_order=" + card_order + ", card_nm=" + card_nm + ", list_nm=" + list_nm + "]";
	}

	
	
}

package kr.jetstream.admin.dto;

public class ChartDTO {
	String chart_day;
	int board_cn;
	int member_cn;
	
	public ChartDTO(){
		
	}

	public ChartDTO(String chart_day, int board_cn, int member_cn) {
		super();
		this.chart_day = chart_day;
		this.board_cn = board_cn;
		this.member_cn = member_cn;
	}

	public String getChart_day() {
		return chart_day;
	}

	public void setChart_day(String chart_day) {
		this.chart_day = chart_day;
	}

	public int getBoard_cn() {
		return board_cn;
	}

	public void setBoard_cn(int board_cn) {
		this.board_cn = board_cn;
	}

	public int getMember_cn() {
		return member_cn;
	}

	public void setMember_cn(int member_cn) {
		this.member_cn = member_cn;
	}

	@Override
	public String toString() {
		return "chartDTO [chart_day=" + chart_day + ", board_cn=" + board_cn + ", member_cn=" + member_cn + "]";
	}

	
}

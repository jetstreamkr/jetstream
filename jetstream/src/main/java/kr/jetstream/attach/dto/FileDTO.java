package kr.jetstream.attach.dto;

public class FileDTO {
	
	private String board_id;
	private String card_id;
	private String file_path;
	private String file_nm;
	
	public FileDTO(){}
	
	public FileDTO(String card_id, String file_path){
		this.card_id = card_id;
		this.file_path = file_path;
	}

	public FileDTO(String board_id, String card_id, String file_path, String file_nm) {
		super();
		this.board_id = board_id;
		this.card_id = card_id;
		this.file_path = file_path;
		this.file_nm = file_nm;
	}



	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getFile_nm() {
		return file_nm;
	}

	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}

	@Override
	public String toString() {
		return "FileDTO [card_id=" + card_id + ", file_path=" + file_path + ", file_nm=" + file_nm + "]";
	}

}

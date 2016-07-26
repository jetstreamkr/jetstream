package kr.jetstream.board.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="board")
public class BoardDTO {
	@Id
	String _id;
	String boardID;
	String boardName;
	String boardURL;
	String boardPermission;
	String boardStart;
	String boardDue;
	String boardClosed;
	
	public BoardDTO(){
		
	}

	public BoardDTO(String _id, String boardID, String boardName, String boardURL, String boardPermission,
			String boardStart, String boardDue, String boardClosed) {
		super();
		this._id = _id;
		this.boardID = boardID;
		this.boardName = boardName;
		this.boardURL = boardURL;
		this.boardPermission = boardPermission;
		this.boardStart = boardStart;
		this.boardDue = boardDue;
		this.boardClosed = boardClosed;
	}

	@Override
	public String toString() {
		return "BoardDTO [_id=" + _id + ", boardID=" + boardID + ", boardName=" + boardName + ", boardURL=" + boardURL
				+ ", boardPermission=" + boardPermission + ", boardStart=" + boardStart + ", boardDue=" + boardDue
				+ ", boardClosed=" + boardClosed + "]";
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getBoardID() {
		return boardID;
	}

	public void setBoardID(String boardID) {
		this.boardID = boardID;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getBoardURL() {
		return boardURL;
	}

	public void setBoardURL(String boardURL) {
		this.boardURL = boardURL;
	}

	public String getBoardPermission() {
		return boardPermission;
	}

	public void setBoardPermission(String boardPermission) {
		this.boardPermission = boardPermission;
	}

	public String getBoardStart() {
		return boardStart;
	}

	public void setBoardStart(String boardStart) {
		this.boardStart = boardStart;
	}

	public String getBoardDue() {
		return boardDue;
	}

	public void setBoardDue(String boardDue) {
		this.boardDue = boardDue;
	}

	public String getBoardClosed() {
		return boardClosed;
	}

	public void setBoardClosed(String boardClosed) {
		this.boardClosed = boardClosed;
	}
}

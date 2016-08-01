package kr.jetstream.card.attach.dto;

import org.springframework.web.multipart.MultipartFile;

public class PhotoDTO {

	MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}

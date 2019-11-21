package com.rest.doc.vo;

public class DocumentVo {
	private String documentId;
	private String content;
	
	public DocumentVo() {
		super();
	}
	public DocumentVo(String documentId, String content) {
		super();
		this.documentId = documentId;
		this.content = content;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", content=" + content + "]";
	}
	
	
}

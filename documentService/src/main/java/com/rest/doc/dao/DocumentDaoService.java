package com.rest.doc.dao;

import org.springframework.stereotype.Component;

import com.rest.doc.vo.DocumentVo;


public interface DocumentDaoService {
	public DocumentVo findDocumentById(String documentId);
	public DocumentVo saveDocument(DocumentVo doc);
	public DocumentVo updateDocumentById(DocumentVo doc);
	public DocumentVo deleteDocumentById(String documentId);
}

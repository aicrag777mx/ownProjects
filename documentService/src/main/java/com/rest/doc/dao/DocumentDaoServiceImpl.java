package com.rest.doc.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.doc.util.Commons;
import com.rest.doc.vo.DocumentVo;

@Component
public class DocumentDaoServiceImpl implements DocumentDaoService {
	private static List<DocumentVo> documents = new ArrayList<>();
	@Autowired
	private Commons commons;
	@Override
	public DocumentVo findDocumentById(String documentId) {
		for(DocumentVo doc : documents){
			if(doc.getDocumentId().equals(documentId))
				return doc;
		}
		return null;
	}

	@Override
	public DocumentVo saveDocument(DocumentVo doc) {
		if(doc.getDocumentId()==null){
			doc.setDocumentId(commons.getId20(doc.getContent()));
		}
		documents.add(doc);
		return doc;
	}

	@Override
	public DocumentVo updateDocumentById(DocumentVo doc) {
		for(DocumentVo doc2Update : documents){
			if(doc2Update.getDocumentId().equals(doc.getDocumentId())){
				doc2Update.setContent(doc.getContent());
				return doc;
			}
		}
		return null;
	}

	@Override
	public DocumentVo deleteDocumentById(String documentId) {
		Iterator<DocumentVo> iterator = documents.iterator();
		while(iterator.hasNext()){
			DocumentVo doc2delete = iterator.next();
			if(doc2delete.getDocumentId().equals(documentId)){
				iterator.remove();
				return doc2delete;
			}
		}
		return null;
	}

}

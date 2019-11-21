package com.rest.doc.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.doc.dao.DocumentDaoService;
import com.rest.doc.exeption.DocumentNotFoundException;
import com.rest.doc.vo.DocumentVo;

@RestController
@RequestMapping("/storage/documents/")
public class DocumentController {
	
	@Autowired
	private DocumentDaoService service;
	
	@GetMapping(path = "/test")
	public String testController(){
		return "Artur";
	}
	
	@GetMapping(path = "/{documentId}")
	public DocumentVo retrieveDocument(@PathVariable String documentId){
		DocumentVo savedDoc = service.findDocumentById(documentId);
		if(savedDoc==null)
			throw new DocumentNotFoundException("documentId - " + documentId);
		return savedDoc;
	}
	
	@PostMapping
	public ResponseEntity<Object> createDocument(@RequestBody DocumentVo doc){
		DocumentVo savedDoc = service.saveDocument(doc);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{documentId}").buildAndExpand(savedDoc.getDocumentId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/{documentId}")
	public ResponseEntity<Object> deleteDocument(@PathVariable String documentId){
		DocumentVo savedDoc = service.deleteDocumentById(documentId);
		if(savedDoc==null)
			throw new DocumentNotFoundException("documentId - " + documentId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Object> updateDocument(@RequestBody DocumentVo doc){
		DocumentVo savedDoc = service.updateDocumentById(doc);
		if(savedDoc==null)
			throw new DocumentNotFoundException("documentId - " + doc.getDocumentId());
		return ResponseEntity.noContent().build();
	}
		
}

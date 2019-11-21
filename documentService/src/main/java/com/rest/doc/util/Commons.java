package com.rest.doc.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Commons {

	
	private Commons() {
		super();
	}

	public static String getId20(String content) {
		String sha1 = "";
		Date current = new Date();
		System.out.println(current.toString());
		if(content!=null){
			content+=current;
		}
		else
			content = current.toString();
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(content.getBytes("utf8"));
	        sha1 = String.format("%020x", new BigInteger(1, digest.digest()));
	        System.out.println(sha1);
		} catch (Exception e){
			e.printStackTrace();
		}
		return sha1.substring(20);
	}

}

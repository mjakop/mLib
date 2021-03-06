package com.mjakop.lib.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Adler32;

public class SimpleHash {

	/*private static String convertToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			int halfbyte = (data[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}*/
	private static String convertToHex(byte[] data) {
		StringBuffer result = new StringBuffer();
		for (byte b:data) {
		    result.append(String.format("%02X", b));
		}
		return result.toString();
	}

	public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] sha1hash = new byte[40];
		md.update(text.getBytes("UTF-8"), 0, text.length());
		sha1hash = md.digest();
		return convertToHex(sha1hash);
	}
	
	public static long CRC32(String text) throws UnsupportedEncodingException {
		Adler32 adler = new Adler32();
		adler.update(text.getBytes("UTF-8"), 0, text.length());
		return adler.getValue();
	}
	
	public static String SHA256(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] sha1hash = new byte[40];
		md.update(text.getBytes("UTF-8"), 0, text.length());
		sha1hash = md.digest();
		return convertToHex(sha1hash);
	}
}

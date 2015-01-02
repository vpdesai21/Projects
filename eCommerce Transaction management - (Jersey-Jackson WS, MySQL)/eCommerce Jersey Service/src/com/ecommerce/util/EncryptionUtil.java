package com.ecommerce.util;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptionUtil {

	public static String sha256Hex(String stringText) {
		String sha256hex = DigestUtils.sha256Hex(stringText);
		return sha256hex;
	}
}
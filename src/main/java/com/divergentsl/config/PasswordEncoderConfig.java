package com.divergentsl.config;

import java.security.MessageDigest;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderConfig implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(rawPassword.toString().getBytes());
			byte messageDigest[] = digest.digest();
			
			StringBuffer hexString = new StringBuffer();
			for(int i = 0; i < messageDigest.length; i++)
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			return hexString.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.toString().equals(encodedPassword);
	}

}

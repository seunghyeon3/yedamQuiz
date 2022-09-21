package com.yedam.quiz;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptTest {
	@Test
	public void test() {
		BCryptPasswordEncoder enco = new BCryptPasswordEncoder(10);
		String result = enco.encode("2460");
		System.out.println(result);
	}
}

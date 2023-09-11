package org.example.util;

import org.junit.Assert;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordTest {

    @Test
    public void testPasswordValid() {
        String plainPassword = "123456";

        // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
        String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());

        System.out.println(hashedPassword);

        // So sánh mật khẩu đã mã hóa
        boolean isValid = BCrypt.checkpw(plainPassword, hashedPassword);
        Assert.assertTrue(isValid);
    }

    @Test
    public void testPasswordInvalid() {
        String plainPassword = "123456";
        String invalidPassword = "654321";

        // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
        String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());

        // So sánh mật khẩu đã mã hóa
        boolean isValid = BCrypt.checkpw(invalidPassword, hashedPassword);
        Assert.assertFalse(isValid);
    }

}

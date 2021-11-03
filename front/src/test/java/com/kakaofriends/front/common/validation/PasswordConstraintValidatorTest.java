package com.kakaofriends.front.common.validation;

import org.junit.Test;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
@RestController
public class PasswordConstraintValidatorTest {





    @Test
    public void testPasswordStrength() {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                // length between 8 and 16 characters
                new LengthRule(8, 16)
                // no whitespace
                //new WhitespaceRule())
        ));

//final char[] password = System.console().readPassword("Password: ");
        String pass = "bonjour";
        RuleResult result = validator.validate(new PasswordData(pass));
//    System.out.println(result.getDetails());
        System.out.println("pass 1");
        System.out.println(result);
        assertFalse(result.isValid());

        pass = "Bonj0ur Monde";
        result = validator.validate(new PasswordData(pass));
        System.out.println("pass 2");
        System.out.println(result);
        assertFalse(result.isValid());

        pass = "1234568";
        result = validator.validate(new PasswordData(pass));
        System.out.println("pass 3");
        System.out.println(result);
        assertTrue(result.isValid());

        pass = "Éonj0ur?mélnde";
        result = validator.validate(new PasswordData(pass));
        System.out.println("pass 4");
        System.out.println(result);
        assertTrue(result.isValid());

        pass = "écôutë pÈt1t!";
        result = validator.validate(new PasswordData(pass));
        System.out.println("pass 5");
        System.out.println(result);
        assertTrue(result.isValid());

    /*if (result.isValid()) {
      System.out.println("Password is valid");
    } else {
      System.out.println("Invalid password:");
      for (String msg : validator.getMessages(result)) {
        System.out.println(msg);
      }
    }*/
    }



}
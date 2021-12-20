package org.owasp.webgoat.users;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author nbaars
 * @since 3/19/17.
 */
@Component
public class UserValidator implements Validator {
    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserForm.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserForm userForm = (UserForm) o;
        if (userRepository.findByUsername(userForm.getUsername()) != null) {
            errors.rejectValue("username", "username.duplicate");
        }
        if (!userForm.getMatchingPassword().equals(userForm.getPassword())) {
            errors.rejectValue("matchingPassword", "password.diff");
        }
    }

    public UserValidator(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

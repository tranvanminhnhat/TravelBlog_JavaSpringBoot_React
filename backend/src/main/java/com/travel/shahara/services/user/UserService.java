package com.travel.shahara.services.user;

import com.travel.shahara.entities.MailTemplate;
import com.travel.shahara.entities.Users;
import com.travel.shahara.models.serviceInputDto.UserServiceInputDto;
import com.travel.shahara.models.serviceOutputDto.UserServiceOutputDto;
import com.travel.shahara.repositories.MailTemplateRepository;
import com.travel.shahara.repositories.UserRepository;
import com.travel.shahara.services.mail.MailService;
import org.hibernate.validator.internal.constraintvalidators.bv.NotNullValidator;
import org.hibernate.validator.internal.constraintvalidators.bv.NullValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailTemplateRepository mailTemplateRepository;

    @Autowired
    private MailService mailService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    // Subject mail when registering new account successfully
    private final static String SUBJECT_MAIL_REGISTRATION_SUCCESS = "[Shahara] Notice of successful shahara account registration";

    // Template mail ID for registering successfully
    private final static String REGISTRATION_SUCCESS_MAIL_TEMPLATE_ID = "MTP001";

    /**
     * Register new User
     * @param userServiceInputDto Input DTO of service
     * @return Username
     */
    public UserServiceOutputDto registerUser(UserServiceInputDto userServiceInputDto) {
        // DTO store User
        Users user = new Users();

        BeanUtils.copyProperties(userServiceInputDto, user, "id");

        if (isExistUser(user)){
            return null;
        }
        user.setPassword(encoder.encode(user.getPassword()));

        Users registeredUser = userRepository.save(user);

        sendMail(registeredUser);

        return UserServiceOutputDto.builder().username(user.getUsername()).build();
    }

    /**
     * Send mail to User
     * @param registeredUser Registered User
     */
    public void sendMail(Users registeredUser){
        if (Objects.nonNull(registeredUser)) {
            MailTemplate mailTemplate = mailTemplateRepository.findById(REGISTRATION_SUCCESS_MAIL_TEMPLATE_ID).orElse(null);
            mailService.sendMail(registeredUser.getEmail(), SUBJECT_MAIL_REGISTRATION_SUCCESS, mailTemplate.getMailBody());
        }
    }

    /**
     *
     * @param user User
     * @return true if exist User - false if not exist User
     */
    public boolean isExistUser(Users user) {

        return  (Objects.nonNull(userRepository.findUsersByEmail(user.getEmail()))
                || Objects.nonNull(userRepository.findUsersByUsername(user.getUsername()))
        );
    }
}

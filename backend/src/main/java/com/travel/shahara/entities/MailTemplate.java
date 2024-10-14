package com.travel.shahara.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MailTemplate {

    /**
     * Mail template ID
     */
    @Id
    private String mailTemplateId;

    /**
     * Mail body
     */
    private String mailBody;

    /**
     * Getter mail template ID
     * @return Mail template ID
     */
    public String getMailTemplateId() {
        return mailTemplateId;
    }

    /**
     * Setter mail template ID
     * @param mailTemplateId Mail template ID
     */
    public void setMailTemplateId(String mailTemplateId) {
        this.mailTemplateId = mailTemplateId;
    }

    /**
     * Getter Mail body
     * @return Mail body
     */
    public String getMailBody() {
        return mailBody;
    }

    /**
     * Setter mail body
     * @param mailBody Mail body
     */
    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }
}

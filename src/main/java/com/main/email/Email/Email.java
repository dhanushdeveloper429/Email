
package com.main.email.Email;


public class Email {

    private String subject;
    private String content;

    public Email() {
    }

    public Email(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Mail{" +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}


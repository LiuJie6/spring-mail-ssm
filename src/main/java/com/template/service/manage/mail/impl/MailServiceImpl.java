package com.template.service.manage.mail.impl;

import com.template.service.manage.mail.api.IMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

/**
 * Project Name:spring-mail-ssm
 * File Name:MailServiceImpl
 * Package Name:com.template.service.manage.mail.impl
 * Date:2019/3/1
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Service("mailService")
public class MailServiceImpl implements IMailService{

    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Resource(name = "mailSender")
    private JavaMailSenderImpl mailSender;

    @Value("${mail.smtp.from}")
    private String from;

    @Value("${mail.smtp.from.name}")
    private String fromName;

    /**
     * 发送邮件
     *
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param to      接收方
     */
    @Override
    public void sendMail(String subject, String content, String to) throws Exception{
        System.getProperties().setProperty("mail.mime.splitlongparameters", "false");
        MimeMessage mailMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true, "utf-8");

        // 设置发件人信息
        helper.setFrom(this.from, this.fromName);
        // 设置收件人
        helper.setTo(to);
        // 设置主题
        helper.setSubject(subject);
        // 邮件内容
        helper.setText(content);

        // 发送邮件
        try {
            logger.info("发送邮件中...");
            this.mailSender.send(mailMessage);
            logger.info("发送邮件完成");
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}

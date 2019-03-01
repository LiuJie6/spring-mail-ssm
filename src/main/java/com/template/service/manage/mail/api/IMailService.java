package com.template.service.manage.mail.api;

/**
 * Project Name:spring-mail-ssm
 * File Name:IMailService
 * Package Name:com.template.service.manage.mail
 * Date:2019/3/1
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IMailService {

    /**
     * 发送邮件
     *
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param to      接收方
     */
    void sendMail(String subject, String content, String to) throws Exception;
}

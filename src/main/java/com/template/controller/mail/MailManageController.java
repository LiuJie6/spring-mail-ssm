package com.template.controller.mail;

import com.template.model.response.ResponseResult;
import com.template.model.state.State;
import com.template.service.manage.mail.api.IMailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project Name:spring-mail-ssm
 * File Name:MailManageController
 * Package Name:com.template.controller.mail
 * Date:2019/3/1
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@RestController("mailManageController")
@RequestMapping("api/mail")
public class MailManageController {

    @Resource(name = "mailService")
    private IMailService mailService;

    public Object sendMailTest(String subject, String content, String to) throws Exception {
        this.mailService.sendMail(subject, content, to);
        return new ResponseResult(true, State.SUCCESS.getCode(), "");
    }
}

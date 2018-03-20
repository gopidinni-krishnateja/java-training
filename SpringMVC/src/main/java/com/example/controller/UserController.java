package com.example.controller;

import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class UserController extends AbstractWizardFormController {


    public UserController(){
        setCommandName("userForm");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request)
            throws Exception {

        return new User();

    }
    @Override
    protected ModelAndView processFinish(HttpServletRequest request,
                                         HttpServletResponse response, Object command, BindException errors)
            throws Exception {

        //Get the data from command object
        User user = (User)command;
        System.out.println(user);

        //where is the finish page?
        return new ModelAndView("view", "user", user);

    }
}

package com.techcourse.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import webmvc.org.springframework.web.servlet.ModelAndView;
import webmvc.org.springframework.web.servlet.view.JspView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RegisterControllerTest {

    private final RegisterController registerController = new RegisterController();

    @Test
    void 회원가입을_하면_인덱스를_반환한다() {
        //given
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("account")).thenReturn("ocean");
        when(request.getParameter("password")).thenReturn("ocean");
        when(request.getParameter("email")).thenReturn("ocean@ocean");

        //when
        final ModelAndView modelAndView = registerController.save(request, response);

        //then
        assertThat(modelAndView)
                .usingRecursiveComparison()
                .isEqualTo(new ModelAndView(new JspView("/index.jsp")));
    }
}

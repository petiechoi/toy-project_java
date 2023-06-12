package com.modim.newtech.toyproject.controller;

import com.modim.newtech.toyproject.community.member.controller.MemberRestController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = MemberRestController.class)
public class MemberControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void hi리턴한다() throws Exception{
        String ret = "hi";
        mvc.perform(
                        MockMvcRequestBuilders.get("/hi"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(ret));
    }
}

package com.ensat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.junit.jupiter.*;
import org.springframework.test.context.web.*;

@ExtendWith(MockitoExtension.class)
@WebAppConfiguration
public class WebAppApplicationTests {

    @Test
    public void contextLoads() {
    }
}

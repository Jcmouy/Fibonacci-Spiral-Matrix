package com.fibospiralmatrix;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FiboAppController {

    @RequestMapping({"/"})
    public String loadUI() {
        log.info("loading UIssdd");
        return "forward:/index.html";
    }
}

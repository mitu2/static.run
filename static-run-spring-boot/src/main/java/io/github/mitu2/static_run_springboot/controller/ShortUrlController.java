package io.github.mitu2.static_run_springboot.controller;

import io.github.mitu2.static_run_springboot.pojo.vo.GenerateShortUrlInfoVO;
import io.github.mitu2.static_run_springboot.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenmoand
 * @date 2023/7/18 20:29
 */
@Controller
@Validated
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @PostMapping(path = "short-url/generate")
    @ResponseBody
    public String doGenerate(@RequestBody GenerateShortUrlInfoVO info) {
        return null;
    }

    @PostMapping(path = "short-url/verification")
    public boolean verification(@RequestBody GenerateShortUrlInfoVO info) {
        return shortUrlService.existsByBindDomainAndRouter(info.getBindDomain(), info.getCustomPath());
    }

}

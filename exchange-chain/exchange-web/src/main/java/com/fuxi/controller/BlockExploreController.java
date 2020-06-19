package com.fuxi.controller;

import com.fuxi.dto.MessageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;

/**
 * @Auther: Laker
 * @Date: 2020/5/25 14:38
 * @Description: Blockchain browser
 */
@RestController
@Slf4j
public class BlockExploreController extends BaseController{


    /**
     *  首页区块详情
     * @param param
     * @return
     */
    @RequestMapping(value = "/home/explore")
    @ResponseBody
    public MessageResult homeForList(@RequestParam String param) {
        return MessageResult.success();
    }

}

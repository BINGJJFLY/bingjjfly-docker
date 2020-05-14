package com.wjz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ComposeController {

	@Autowired
    RedisTemplate<Object, Object> redisTemplate;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("result", "Redis count is " + redisTemplate.opsForValue().increment("count"));
		return "index";
	}
}

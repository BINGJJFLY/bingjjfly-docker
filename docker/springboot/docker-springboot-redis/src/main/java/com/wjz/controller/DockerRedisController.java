package com.wjz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerRedisController {

	@Autowired
    RedisTemplate<Object, Object> redisTemplate;
	
	@RequestMapping("/index")
	public String index() {
		return "Redis count is " + redisTemplate.opsForValue().increment("count");
	}
}

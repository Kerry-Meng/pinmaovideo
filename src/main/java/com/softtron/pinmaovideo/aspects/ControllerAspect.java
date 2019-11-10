package com.softtron.pinmaovideo.aspects;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAspect {
	
	@Around(value = "within(com.softtron.pinmaovideo.controllers.*)")
	public Object around(ProceedingJoinPoint jPoint) {
		// 返回信息
		HashMap resultMap = new HashMap();
		try {
			Object object = jPoint.proceed();
			resultMap.put("code", 200);
			resultMap.put("message", "操作成功!");
			if (object instanceof Map) {
				resultMap.putAll((Map) object);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			resultMap.put("code", 500);
			resultMap.put("message", "操作失败!");
		}
		return resultMap;
	}
	
}

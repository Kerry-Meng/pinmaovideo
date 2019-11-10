package com.softtron.pinmaovideo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtron.pinmaovideo.domains.TVideo;
import com.softtron.pinmaovideo.services.VideoService;

@RestController
public class RouterController {
	
	@Autowired
	VideoService videoService;
	
	@RequestMapping(path = "index")
	public String get() {
		return "hello wordls!";
	}
	
	/**
	 * 在插入成功时， 将主键id给放入map中，进行返回
	 * 
	 * @param map
	 * @return
	 */
	// 以json的格式进行传参,通过map来获取，转成TVideo对象
	@RequestMapping(path = "savevideo")
	public Map saveVideo(@RequestBody Map map) {
		Map resultMap = new HashMap();
		Map video = (Map) map.get("video");
		// 如果等于-1，则进行插入
		if (Integer.parseInt(String.valueOf(video.get("videoId"))) == -1) {
			videoService.saveVideo(video);
			resultMap.put("videoId", video.get("videoId"));
		} else {
			videoService.updateVideo(video);
		}
		return resultMap;
	}
	
	@RequestMapping(path = "/findallvideos/{page}/{count}.do")
	public Map findAllVideos(@PathVariable(name = "page") int page, @PathVariable(name = "count") int count) {
		// 返回信息
		Map resultMap = new HashMap();
		Map map = new HashMap();// 将拿到的page和count放入map中
		map.put("start", (page - 1) * count);
		map.put("count", count);
		// 获取分页数据
		resultMap.put("videos", videoService.findAllVideos(map));
		// 获取总数
		resultMap.put("total", videoService.findAllVideo2());
		return resultMap;
	}
	
	/**
	 * 执行删除操作，将videoId放入map集合中。进行返回
	 * @param videoId
	 * @return
	 */
	@RequestMapping(path = "/deletevideo/{videoId}.do")
	public Map deleteVideo(@PathVariable int videoId) {
		Map resultMap = new HashMap();
		resultMap.put("videoId", videoService.deleteVideo(videoId));
		return resultMap;
	}
}

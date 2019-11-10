package com.softtron.pinmaovideo.services;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtron.pinmaovideo.daos.VideoDao;
import com.softtron.pinmaovideo.domains.TVideo;

@Service
public class VideoService {
	
	@Autowired
	VideoDao videoDao;
	
	//插入
	public int saveVideo(Map video) {
		return videoDao.saveVideo(video);
	}
	
	//更新
	public int updateVideo(Map video) {
		return videoDao.updateVideo(video);
	}
	
	//查询
	public Set<TVideo> findAllVideos(Map map){
		return videoDao.findAllVideos(map);
	}
	
	//获取总数
	public int findAllVideo2() {
		return videoDao.findAllVideos2();
	}
	
	//删除
	public int deleteVideo(int videoId) {
		return videoDao.deleteVideo(videoId);
	}
}

package com.softtron.pinmaovideo.daos;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.softtron.pinmaovideo.domains.TVideo;

public interface VideoDao {
	
	//执行插入操作,成功之后返回一个int类型的id
	public int saveVideo(Map video);
	
	//执行更新操作，成功之后返回一个int类型的id
	public int updateVideo(Map video);
	
	//执行查询操作，执行成功之后，返回一个lingedHashSet集合
	public LinkedHashSet<TVideo> findAllVideos(Map map);
	
	public int findAllVideos2();
	
	//执行删除操作，执行成功之后，返回一个int类型的id
	public int deleteVideo(int videoId);
}

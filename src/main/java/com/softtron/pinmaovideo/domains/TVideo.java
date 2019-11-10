package com.softtron.pinmaovideo.domains;

public class TVideo {
	
	private int videoId;
	private String videoTitle;
	private String videoUrl;
	
	public int getVideoId() {
		return videoId;
	}
	
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	
	public String getVideoTitle() {
		return videoTitle;
	}
	
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	
	public String getVideoUrl() {
		return videoUrl;
	}
	
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	
	@Override
	public String toString() {
		return "TVideo [videoId=" + videoId + ", videoTitle=" + videoTitle + ", videoUrl=" + videoUrl + "]";
	}
	
}

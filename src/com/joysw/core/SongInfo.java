package com.joysw.core;

public class SongInfo {

	private final String TAG = "TAG"; // 文件头1-3

	private String songName; // 歌曲名4-33

	private String artist; // 歌手名34-63

	private String album; // 专辑名61-93

	private String year; // 年94-97

	private String comment; // 备注98-125
	
	private String test;//126-158

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	private boolean valid; // 是否合法

	public transient String fileName; // 此歌曲对应的文件名,没有封装

	public SongInfo(byte[] data) {
		/*
		 * if (data.length != 128) { throw new RuntimeException("数据长度不合法:" +
		 * data.length); }
		 */
		String tag = new String(data, 0, 3);
		// 只有前三个字节是TAG才处理后面的字节

		if (tag.equalsIgnoreCase("TAG")) {
			valid = true;
			songName = new String(data, 3, 30).trim();
			artist = new String(data, 33, 30).trim();
			album = new String(data, 63, 30).trim();
			year = new String(data, 93, 4).trim();
			comment = new String(data, 97, 28).trim();
			test = new String(data, 125, 33).trim();
		} else {
			valid = false;
		}
	}

	public SongInfo() {
	}

	/**
	 * 返回是否合法
	 * 
	 * @return 是否
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * 得到此对象的128个字节的表示形式
	 * 
	 * @return
	 */
	public byte[] getBytes() {
		byte[] data = new byte[158];
		
		System.arraycopy(TAG.getBytes(), 0, data, 0, 3);
		
		byte[] temp = songName.getBytes();
		System.arraycopy(temp, 0, data, 3, temp.length > 30 ? 30 : temp.length);
		temp = artist.getBytes();
		System
				.arraycopy(temp, 0, data, 33, temp.length > 30 ? 30
						: temp.length);
		temp = album.getBytes();
		System
				.arraycopy(temp, 0, data, 63, temp.length > 30 ? 30
						: temp.length);
		temp = year.getBytes();
		System.arraycopy(temp, 0, data, 93, temp.length > 4 ? 4 : temp.length);
		temp = comment.getBytes();
		System
				.arraycopy(temp, 0, data, 97, temp.length > 28 ? 28
						: temp.length);
		
		temp = test.getBytes();
		System
				.arraycopy(temp, 0, data, 125, temp.length > 33 ? 33
						: temp.length);
		return data;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String authorName) {
		this.artist = authorName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		if (songName == null) {
			throw new NullPointerException("歌名不能是null!");
		}
		valid = true;
		this.songName = songName;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String specialName) {
		this.album = specialName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}

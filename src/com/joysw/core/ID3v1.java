package com.joysw.core;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ID3v1 {
	private String _header;
	public String title;
	public String artist;
	public String album;
	public String year;
	public String comment;
	public byte trackNumberFlag;
	public byte trackNumber;
	public byte genre;
	private File _mp3File;
	private RandomAccessFile rf;

	public ID3v1(String mp3File) {
		_mp3File = new File(mp3File);
	}

	public Boolean getTagInfo() {
		Boolean hasTag = false;
		byte[] b = new byte[128];
		try {
			rf = new RandomAccessFile(_mp3File, "r");
			rf.seek(rf.length() - 128);
			rf.read(b);
			_header = new String(b, 0, 3);
			if (_header.compareTo("TAG") == 0) {
				title = new String(b, 3, 30);
				artist = new String(b, 33, 30);
				album = new String(b, 63, 30);
				year = new String(b, 93, 4);
				trackNumberFlag = b[125];
				if (trackNumberFlag == 0) {
					comment = new String(b, 97, 28);
					trackNumber = b[126];
				} else {
					comment = new String(b, 97, 30);
					trackNumber = 0;
				}
				genre = b[127];
				hasTag = true;
			}
			rf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hasTag;
	}

	public static void main(String[] args) {
		ID3v1 tags = new ID3v1(
				"D:\\apache-tomcat-6-videomonitor\\webapps\\musicsys\\upload\\tempmusic\\2012-12-25\\Kalimba.mp3");
		boolean hasTag = tags.getTagInfo();
		if (hasTag) {
			System.out.println("Title:" + tags.title);
			System.out.println("Artist:" + tags.artist);
			System.out.println("Album:" + tags.album);
			System.out.println("Year:" + tags.year);
			System.out.println("Comment:" + tags.comment);
			System.out.println("No." + tags.trackNumber);
		} else {
			System.out.println("Sorry!");
		}
	}
}

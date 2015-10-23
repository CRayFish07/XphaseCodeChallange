package org.xphase.Bean;

import com.mysql.jdbc.Blob;

public class ImageBean 
{
	private Blob userImage ;

	public Blob getUserImage() {
		return userImage;
	}

	public void setUserImage(Blob userImage) {
		this.userImage = userImage;
	}
}

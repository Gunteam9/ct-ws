package v1.model;

import java.net.URL;
import java.util.UUID;

public class Image {

	private UUID id;
	private URL url;
	private String desc;
	
	public Image() {
		this.id = UUID.randomUUID();
	}
	
	public Image(URL url, String desc) {
		super();
		this.id = UUID.randomUUID();
		this.url = url;
		this.desc = desc;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}

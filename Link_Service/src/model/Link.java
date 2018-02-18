package model;

public class Link {
	private int link_id;
	private String link, title, details;
	
	public Link() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Link(int link_id, String link, String title, String details) {
		super();
		this.link_id = link_id;
		this.link = link;
		this.title = title;
		this.details = details;
	}
	public int getLink_id() {
		return link_id;
	}
	public void setLink_id(int link_id) {
		this.link_id = link_id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "Links [link_id=" + link_id + ", link=" + link + ", title=" + title + ", details=" + details + "]";
	}
}

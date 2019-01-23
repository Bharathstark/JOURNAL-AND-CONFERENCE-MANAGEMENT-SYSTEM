package application;

public class ctablemodel {
	public ctablemodel(String id, String ad, String type, String coauthor, String toc, String top, String venue,
			String date, String pgno) {
		super();
		this.id = id;
		this.ad = ad;
		this.type = type;
		this.coauthor = coauthor;
		this.toc = toc;
		this.top = top;
		this.venue = venue;
		this.date = date;
		this.pgno = pgno;
	}

	String id,ad,type,coauthor,toc,top,venue,date,pgno;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCoauthor() {
		return coauthor;
	}

	public void setCoauthor(String coauthor) {
		this.coauthor = coauthor;
	}

	public String getToc() {
		return toc;
	}

	public void setToc(String toc) {
		this.toc = toc;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPgno() {
		return pgno;
	}

	public void setPgno(String pgno) {
		this.pgno = pgno;
	}
	
}

package project1;

public class ReviewVO {

	int review_id;
	String mem_id;
	int meet_id;
	int review_star;
	String review_title;
	String review_cont;
	
	public ReviewVO(int review_star, String review_title, String review_cont) {
		this.review_star = review_star;
		this.review_title = review_title;
		this.review_cont = review_cont;
	}
	
	
	
	public ReviewVO(int review_id, String mem_id, int meet_id, int review_star, String review_title,
			String review_cont) {
		this.review_id = review_id;
		this.mem_id = mem_id;
		this.meet_id = meet_id;
		this.review_star = review_star;
		this.review_title = review_title;
		this.review_cont = review_cont;
	}



	public ReviewVO(int review_id, String mem_id) {
		this.review_id = review_id;
		this.mem_id = mem_id;
	}



	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getMeet_id() {
		return meet_id;
	}

	public void setMeet_id(int meet_id) {
		this.meet_id = meet_id;
	}

	public int getReview_star() {
		return review_star;
	}

	public void setReview_star(int review_star) {
		this.review_star = review_star;
	}

	public String getReview_title() {
		return review_title;
	}

	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}

	public String getReview_cont() {
		return review_cont;
	}

	public void setReview_cont(String review_cont) {
		this.review_cont = review_cont;
	}
	
	
	
	
	
}

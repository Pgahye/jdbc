package jdbc;

public class BookVo {
	
	
	private Long no;
	private String title;
	private int price;
	private int author_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAuthor_no() {
		return author_no;
	}
	public void setAuthor_no(int author_no) {
		this.author_no = author_no;
	}
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", price=" + price + ", author_no=" + author_no + "]";
	}
	
	

}

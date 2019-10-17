package spring_hibernate.dao;

public interface Bookshop {
	//獲取書籍價格
	public int getPrice(Integer id);
	//買書
	public void updateBookStock(Integer id);
	//操作帳號餘額
	public void updateAccount(String username,Integer price);
	
}

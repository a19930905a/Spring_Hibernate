package spring_hibernate.dao;

public interface Bookshop {
	//������y����
	public int getPrice(Integer id);
	//�R��
	public void updateBookStock(Integer id);
	//�ާ@�b���l�B
	public void updateAccount(String username,Integer price);
	
}

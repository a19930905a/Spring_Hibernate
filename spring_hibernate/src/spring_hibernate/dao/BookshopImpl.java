package spring_hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_hibernate.exception.AccountException;
import spring_hibernate.exception.StockException;
@Repository
public class BookshopImpl implements Bookshop {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public int getPrice(Integer id) {
		String hql = "Select b.price From Book b Where b.id = ?";
		Query query = getSession().createQuery(hql).setInteger(0, id);
		return (int) query.uniqueResult();
	}

	@Override
	public void updateBookStock(Integer id) {
		
		//檢查庫存數量
		String check_hql = "Select b.stock From Book b Where b.id=?";
		int check = (int) getSession().createQuery(check_hql).setInteger(0, id).uniqueResult();
		if(check==0) {
			throw new StockException("庫存不足");
		}

		String hql = "Update Book b Set b.stock = b.stock-1 Where b.id=?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	
	}

	@Override
	public void updateAccount(String username, Integer price) {
		//檢查餘額
		String check_hql = "Select a.balance From Account a Where a.username=?";
		int left = (int) getSession().createQuery(check_hql).setString(0, username).uniqueResult();
		if(left<price) {
			throw new AccountException("餘額不足");
		}
		
		String hql = "Update Account a Set a.balance = a.balance - ? Where a.username=?";
		
		getSession().createQuery(hql).setInteger(0, price).setString(1, username).executeUpdate();
		
	}

}

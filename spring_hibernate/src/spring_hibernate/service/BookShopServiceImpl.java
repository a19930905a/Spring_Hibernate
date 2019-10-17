package spring_hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_hibernate.dao.Bookshop;


@Service
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private Bookshop bookshop;
	
	@Override
	public void purchase(String username, Integer id) {
		int price = bookshop.getPrice(id);
		bookshop.updateBookStock(id);
		bookshop.updateAccount(username, price);
	}

	@Override
	public void multipleBuy(String username, List<Integer> id) {
		for(Integer ids:id) {
			purchase(username, ids);
		}
		
	}
	

}

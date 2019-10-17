package spring_hibernate.service;

import java.util.List;

public interface BookShopService {
	//單次購買
	public void purchase(String username,Integer id);
	//批量購買
	public void multipleBuy(String username ,List<Integer>id);
}

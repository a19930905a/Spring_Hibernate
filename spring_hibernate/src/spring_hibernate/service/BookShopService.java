package spring_hibernate.service;

import java.util.List;

public interface BookShopService {
	//�榸�ʶR
	public void purchase(String username,Integer id);
	//��q�ʶR
	public void multipleBuy(String username ,List<Integer>id);
}

package poly.ass.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import poly.ass.repo.OrderDetailRepo;
import poly.ass.repo.ProductDAO;
import poly.ass.repo.ShoppingCartDAO;
import poly.ass.entity.CartItem;

@SessionScope
@Service
public class ShoppingCartService implements ShoppingCartDAO {
	Map<Integer, CartItem> map = new HashMap<>();
	
	@Autowired
    OrderDetailRepo dao;
	
	@Autowired
	ProductDAO daoP;
	
	@Override
	public Collection<CartItem> getItems() {
		// TODO Auto-generated method stub
		return map.values();
	}
	
	@Override
	public void add(CartItem item) {
		// them san pham vao gio hang dua vao ID
		CartItem cartItem = map.get(item.getProductId());
		if (cartItem == null) {
			map.put(item.getProductId(), item);
		} else {
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		}

	}

	@Override
	public void remove(Integer id) {
		// Xoa san pham trong gio hang theo ID
		map.remove(id);
	}

	@Override
	public CartItem update(Integer id, int qty) {
		// Cap nhat so luong theo ID
		CartItem item = map.get(id);
		item.setQuantity(qty);
		return item;
	}

	@Override
	public void clear() {
		// Clear gio hang
		map.clear();
	}

	@Override
	public int getCount() {
		// Tong so luong trong gio hang
		return map.values().stream().mapToInt(item -> item.getQuantity()).sum();
	}

	@Override
	public double getAmount() {
		// Tong gia tien cua gio hang
		return map.values().stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
	}

}

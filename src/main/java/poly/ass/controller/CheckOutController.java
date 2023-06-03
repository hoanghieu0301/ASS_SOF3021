package poly.ass.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import poly.ass.repo.CategoryRepo;
import poly.ass.repo.OrderRepo;
import poly.ass.repo.OrderDetailRepo;
import poly.ass.repo.ProductDAO;
import poly.ass.entity.CartItem;
import poly.ass.entity.Category;
import poly.ass.entity.Order;
import poly.ass.entity.OrderDetail;
import poly.ass.entity.Product;
import poly.ass.service.MailerServiceImpl;
import poly.ass.service.SessionService;
import poly.ass.service.ShoppingCartService;

@Controller
public class CheckOutController {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	OrderRepo daoOrder;
	
	@Autowired
	OrderDetailRepo daoOrderDetail;
	
	@Autowired
	CategoryRepo daoCategory;
	
	@Autowired
	ProductDAO daoProduct;

	@Autowired
	ShoppingCartService cart;

	@Autowired
	SessionService session;
	
	@Autowired 
	MailerServiceImpl mailer;
	
	@GetMapping("/cart/checkout")
	public String checkout(
			Model model
			) {
		model.addAttribute("TitlePage", "CheckOut Details");
		model.addAttribute("view", "/views/user/checkoutDetails.jsp");
		
		List<Category> categories = daoCategory.findAll();
		model.addAttribute("categories", categories);
		
		model.addAttribute("cartItems", cart.getItems());
		model.addAttribute("Count", cart.getCount());
		model.addAttribute("Amount", cart.getAmount());
		
		Order order = new Order();
		model.addAttribute("order", order);
		
		return "index";
	}
	
	@PostMapping("/cart/checkout")
	public String postCheckOut(
			Model model,
			@Validated @ModelAttribute("order") Order order, 
			BindingResult result
			) {
		model.addAttribute("TitlePage", "CheckOut Details");
		model.addAttribute("view", "/views/user/checkoutDetails.jsp");
		
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			
			System.out.println("message err: " + errors.get(0).getDefaultMessage());
			
			model.addAttribute("errors", errors);

			return "redirect:/cart/checkout";
		}else {
			try {
				daoOrder.save(order);
				for (CartItem item : cart.getItems()) {
//					System.out.println("Save orderDtails: " + item);
					Order o = daoOrder.getById(order.getId());
					Product product = daoProduct.getById(item.getProductId());

					daoOrderDetail.save(new OrderDetail(item.getPrice(), item.getQuantity(), product, o));
				}

				//gửi gmail cho người đặt
				mailer.send(
						"hoangxuanhieu0301@gmail.com",
						"Thông báo đặt hàng Thành Công từ ASS_SOF3021", 
						"<h3>Chúc mừng bạn đã đặt hàng thành công từ ABC Shop ASS_SOF3021</h3> <br>"
						+ "Xem chi tiết Order: "
						+ "<a href='http://localhost:6901/myAcc/historyOrder/"+ order.getAccount().getUsername() +"'>tại đây</a>" );
				
				//xóa tất cả sản phẩm trong giỏ hàng

				cart.getItems().clear();
				return "redirect:/";
			} catch (Exception e) {
				// TODO: handle exception
				return "redirect:/cart/checkout";
			}
				
							
		}
		
	}

}

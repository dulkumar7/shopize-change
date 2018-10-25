/*package com.shoppingcart.shoppingservice.services;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.business.repositories.shoppingcart.ShoppingCartRepository;
import com.salesmanager.core.business.rest.model.ShoppingCartResponse;
import com.salesmanager.core.business.services.shoppingcart.ShoppingCartServiceImpl;
import com.salesmanager.core.model.customer.Customer;
import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.shoppingcart.ShoppingCart;
import com.salesmanager.core.model.shoppingcart.ShoppingCartItem;
import com.salesmanager.shop.shoppingcart.requests.objects.CartRequest;
import com.salesmanager.shop.shoppingcart.requests.objects.CustomerRequest;
import com.salesmanager.shop.shoppingcart.requests.objects.MerchantRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShopCartService2 {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Autowired
	private ShoppingCartServiceImpl shoppingCartService;

	
	 * public ShoppingCartResponse getById(int merchantId, String id) { if
	 * (StringUtils.isNotBlank(id)) { return
	 * parseShoppingCartResp(shoppingCartRepository.findById(merchantId,
	 * Long.valueOf(id))); } return null; }
	 

	
	 * //getByCustomer public ShoppingCartResponse getShoppingcartByCustomer(String
	 * id) { ShoppingCart shoppingCart = null; if (StringUtils.isNotBlank(id) &&
	 * !StringUtils.isNumeric(id)) { Customer customer = new Customer();
	 * customer.setId(Long.valueOf(id)); try { shoppingCart =
	 * shoppingCartService.getByCustomer(customer); } catch (ServiceException e) { }
	 * 
	 * } return parseShoppingCartResp(shoppingCart);
	 

	// }

	public ShoppingCartResponse getByCode(String code, int merchantId) {
		ShoppingCart cart = null;
		MerchantStore store = new MerchantStore();
		store.setId(Integer.valueOf(merchantId));
		try {
			cart = shoppingCartService.getByCode(code, store);
		} catch (ServiceException e) {
		}
		return parseShoppingCartResp(cart);
	}

	
	 * public ShoppingCartResponse getShoppingcartByCode(String code) {
	 * 
	 * return parseShoppingCartResp(shoppingCartRepository.findByCode(code)); }
	 * 
	 

	
	 * public ShoppingCartResponse getShoppingcartByOne(String id) { if
	 * (StringUtils.isNotBlank(id)) { return
	 * parseShoppingCartResp(shoppingCartRepository.findOne(Long.valueOf(id))); }
	 * 
	 * return null; }
	 
	*//**
	 * Converted to post
	 * 
	 * @param id
	 * @return
	 *//*
	
	 * public ShoppingCartResponse getByShoppingCartId(CartRequest id) { return
	 * parseShoppingCartResp(shoppingCartRepository.findOne(Long.valueOf(id.
	 * getCartId())));
	 * 
	 * }
	 

	public ShoppingCartResponse getShoppingcartByCustomer(String id) {
			ShoppingCart shoppingCart = shoppingCartRepository.findByCustomer(customer.getId());
			if (shoppingCart == null) {
				return null;
			}
			shoppingCartService.getPopulatedShoppingCart(shoppingCart);
				
	}

	
	 * public ShoppingCartResponse getByShoppingCartMerchantId(MerchantRequest
	 * merchantRequest) {
	 * 
	 * ShoppingCart shoppingCart =
	 * shoppingCartRepository.findById(merchantRequest.getMerchantId(),
	 * Long.valueOf(merchantRequest.getCartId()));
	 * 
	 * // (shoppingCartService.getPopulatedShoppingCart(shoppingCart) return
	 * parseShoppingCartResp(shoppingCart); }
	 

	public ShoppingCartResponse getShoppingcartByCode(int id, String code) {
		ShoppingCart shoppingCart = shoppingCartRepository.findByCode(id, code);
		if (shoppingCart == null) {
			return null;
		}
		try {
			shoppingCartService.getPopulatedShoppingCart(shoppingCart);
		} catch (Exception e) {
					}

		if (shoppingCart.isObsolete()) {
			shoppingCartRepository.delete(shoppingCart);
			return null;

		}
		return parseShoppingCartResp(shoppingCart);
	}

	private ShoppingCartResponse parseShoppingCartResp(ShoppingCart cart) {
		ShoppingCartResponse response = null;
		Set<ShoppingCartItem> lineItems = new HashSet<ShoppingCartItem>();
		if (null != cart) {
			response = new ShoppingCartResponse();
			response.setId(cart.getId());

			response.setAuditSection(cart.getAuditSection());
			response.setCustomerId(cart.getCustomerId());
			lineItems = cart.getLineItems();
			response.setLineItems(lineItems);
			response.setMerchantStore(cart.getMerchantStore());
			response.setShoppingCartCode(cart.getShoppingCartCode());
		}

		return response;
	}

}
*/
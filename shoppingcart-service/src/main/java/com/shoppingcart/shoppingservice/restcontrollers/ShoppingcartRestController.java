package com.shoppingcart.shoppingservice.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.salesmanager.core.business.rest.model.ShoppingCartResponse;
import com.salesmanager.shop.shoppingcart.requests.objects.CartRequest;
import com.salesmanager.shop.shoppingcart.requests.objects.CustomerRequest;
import com.salesmanager.shop.shoppingcart.requests.objects.MerchantRequest;
import com.shoppingcart.shoppingservice.services.ShopCartService;

@RestController
@RequestMapping
public class ShoppingcartRestController {

	Logger logger = LoggerFactory.getLogger(ShoppingcartRestController.class);
	
	  @Autowired ObjectMapper objectMapper;
	 

	@Autowired
	private ShopCartService shopCartService;

	@RequestMapping(value = "/{id}/{code}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getShoppingCartByCode")
	public ShoppingCartResponse getShoppingCartByCode(@PathVariable(value = "id") int id,
			@PathVariable(value = "code") String code) {
		return shopCartService.getByCode(code, id);
	}

	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	@HystrixCommand(fallbackMethod = "getShoppingcartByCartId")
	public ShoppingCartResponse getShoppingcartByCartId(@Valid @RequestBody CartRequest cartId) {
		return shopCartService.getByShoppingCartId(cartId);
	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public ShoppingCartResponse getByCustomer(@Valid @RequestBody CustomerRequest merchantRequest) {
		ShoppingCartResponse response = null;
		try {
			response = shopCartService.getShoppingCartByCustomer(merchantRequest);
		} catch (Exception e) {
			logger.error("Exception in ShoppingCartRestController.getCustomer()", e);
		}
		return response;
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getByCustomerId")
	public ShoppingCartResponse getByCustomerId(@RequestParam String customerId) {
		return shopCartService.getShoppingcartByCustomer(customerId);
	}

	@RequestMapping(value = "/merchant", method = RequestMethod.POST)
	@HystrixCommand(fallbackMethod = "getByShoppingCartMerchantId")
	public ShoppingCartResponse getById(@Valid @RequestBody MerchantRequest merchantRequest) {
		return shopCartService.getByShoppingCartMerchantId(merchantRequest);
	}

}
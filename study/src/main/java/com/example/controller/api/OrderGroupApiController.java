package com.example.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.ifs.CrudInterface;
import com.example.model.network.Header;
import com.example.model.network.request.OrderGroupApiRequest;
import com.example.model.network.response.OrderGroupApiResponse;
import com.example.service.OrderGroupApiLogicService;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

	@Autowired
	private OrderGroupApiLogicService orderGroupApiLogicService;
	
	@Override
	@PostMapping("")
	public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> request) {
		
		return orderGroupApiLogicService.create(request);
	}

	@Override
	@GetMapping("{id}")
	public Header<OrderGroupApiResponse> read(@PathVariable Long id) {
		
		return null;
	}

	
	@Override
	@PutMapping("")
	public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> request) {
		
		return null;
	}

	@Override
	@DeleteMapping("{id}")
	public Header delete(@PathVariable Long id) {
		
		return null;
	}
	
	
	

}

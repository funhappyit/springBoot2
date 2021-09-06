package com.example.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.ifs.CrudInterface;
import com.example.model.entity.OrderGroup;
import com.example.model.network.Header;
import com.example.model.network.request.OrderGroupApiRequest;
import com.example.model.network.response.OrderGroupApiResponse;
import com.example.repository.OrderGroupRepository;
import com.example.repository.UserRepository;

@Service
public class OrderGroupApiLogicService implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse>{
	
	@Autowired
	private OrderGroupRepository orderGroupRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
		
		OrderGroupApiRequest body = request.getData();
		System.out.println("body"+body);
		OrderGroup orderGroup = OrderGroup.builder()
				.status(body.getStatus())
				.orderType(body.getOrderType())
				.revAddress(body.getRevAddress())
				.revName(body.getRevName())
				.paymentType(body.getPaymentType())
				.totalPrice(body.getTotalPrice())
				.totalQuantity(body.getTotalQuantity())
				.orderAt(LocalDateTime.now())
				.user(userRepository.getOne(body.getUserId()))
				.build();
		OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
		return response(newOrderGroup);
	}

	@Override
	public Header<OrderGroupApiResponse> read(Long id) {
	
		return null;
	}

	@Override
	public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
	
		return null;
	}

	@Override
	public Header delete(Long id) {
	
		return null;
	}
	
	private Header<OrderGroupApiResponse> response(OrderGroup orderGroup){
		System.out.println("orderGroup"+orderGroup);
		OrderGroupApiResponse body = OrderGroupApiResponse.builder()
				.id(orderGroup.getId())
				.status(orderGroup.getStatus())
				.orderType(orderGroup.getOrderType())
				.revAddress(orderGroup.getRevAddress())
				.revName(orderGroup.getRevName())
				.paymentType(orderGroup.getPaymentType())
				.totalPrice(orderGroup.getTotalPrice())
				.totalQuantity(orderGroup.getTotalQuantity())
				.orderAt(orderGroup.getOrderAt())
				.arrivalDate(orderGroup.getArrivalDate())
				.userId(orderGroup.getUser().getId())
				.build();
		
		return Header.OK(body);
				
	}
	
}

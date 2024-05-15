package com.app.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.request.PassengerInfo;
import com.app.response.TicketInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("this is Air india distributed  Component")
public class AirIndiaRestController {

	@ApiOperation("This is used to book Flight Ticket")
	@PostMapping("/bookFlightTicket")
	public ResponseEntity<TicketInfo> bookTicket(@RequestBody PassengerInfo pinfo){
		//logic to book ticket
		
		//send ticket info
		TicketInfo ticket=new TicketInfo();
		ticket.setName(pinfo.getFname()+" "+pinfo.getLname());
		ticket.setFrom(pinfo.getFrom());
		ticket.setTo(pinfo.getTo());
		ticket.setTicketStatus("CONFORMED");
		ticket.setTicketPrice("4500.00 INR");
		ticket.setJourneyDate(pinfo.getJourneyDate());
		
		return new ResponseEntity<>(ticket,HttpStatus.CREATED);
	}
}

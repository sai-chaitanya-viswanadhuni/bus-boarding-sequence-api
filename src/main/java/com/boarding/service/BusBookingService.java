package com.boarding.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boarding.DTO.BusBookingDTO;
import com.boarding.DTO.TicketsDTO;
import com.boarding.entity.Bus;
import com.boarding.entity.BusBooking;
import com.boarding.entity.BusSeat;
import com.boarding.entity.Passenger;
import com.boarding.entity.Ticket;
import com.boarding.entity.User;
import com.boarding.respository.BusBookingRepository;
import com.boarding.respository.BusRepository;
import com.boarding.respository.BusSeatRepository;
import com.boarding.respository.PassengerRepository;
import com.boarding.respository.TicketRepository;
import com.boarding.respository.UserRepository;

@Service
public class BusBookingService {

	@Autowired
	BusBookingRepository busBookingRepository;

	@Autowired
	BusRepository busRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	BusSeatRepository busSeatRepository;

	@Autowired
	PassengerRepository passengerRepository;

	public Optional<BusBooking> getBusBookingDetailsByBookingID(Long busBookingID) {
		System.out.println(busBookingRepository.findById(busBookingID));
		return busBookingRepository.findById(busBookingID);
	}

	public String bookBusTickets(BusBookingDTO busBookingDetails) {

		BusBooking busBookingData = new BusBooking();

		if (busBookingDetails != null) {

			Long busID = busBookingDetails.getBusID();
			Bus bus = busRepository.findById(busID).orElseThrow();

			Long userID = busBookingDetails.getUserID();
			User user = userRepository.findById(userID).orElseThrow();

			busBookingData.setBus(bus);
			busBookingData.setUser(user);
			busBookingData.setDateOfBooking(busBookingDetails.getDateOfBooking());
			busBookingData.setDateOfJourney(busBookingDetails.getDateOfJourney());
			busBookingData.setFare(busBookingDetails.getFare());

			BusBooking savedBusBooking = busBookingRepository.save(busBookingData);

			List<TicketsDTO> ticketDetails = busBookingDetails.getTicketDetails();

			for (TicketsDTO ticket : ticketDetails) {
				String seatName = ticket.getBusSeat().getSeatName();
				String seatStatus = ticket.getBusSeat().getSeatStatus();
				BusSeat busSeatData = new BusSeat();
				busSeatData.setBus(bus);
				busSeatData.setSeatName(seatName);
				busSeatData.setSeatStatus(seatStatus);
				BusSeat savedBusSeat = busSeatRepository.save(busSeatData);

				String passengerAge = ticket.getPassenger().getPassengerAge();
				String passengerName = ticket.getPassenger().getPassengerName();

				Passenger passengerData = new Passenger();
				passengerData.setPassengerName(passengerName);
				passengerData.setPassengerAge(passengerAge);
				Passenger savedPassenger = passengerRepository.save(passengerData);

				Ticket ticketData = new Ticket();
				ticketData.setBusBooking(savedBusBooking);
				ticketData.setBusSeat(savedBusSeat);
				ticketData.setPassenger(savedPassenger);
				Long ticketFare = ticket.getTicketFare();
				ticketData.setTicketFare(ticketFare);

				ticketRepository.save(ticketData);

			}

			return "Ticket Booked SuccessFully";

		}

		else
			return "Error While Booking Ticket";
	}

	public List<BusBooking> getAllBusBookings() {
		// TODO Auto-generated method stub
		return busBookingRepository.findAll();
	}

	public List<BusBooking> getAllBusBookingsByBusID(Long busID) {
		// TODO Auto-generated method stub
		Bus bus = busRepository.findById(busID).orElseThrow();
		return busBookingRepository.findByBus(bus);
	}
}

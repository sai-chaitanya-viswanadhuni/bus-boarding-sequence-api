package com.boarding.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.boarding.entity.BusBooking;
import com.boarding.entity.Ticket;

@Component
public class BoardingSequenceFinder {

	public BoardingSequenceFinder() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Integer> findSequence(List<BusBooking> busBookingsList) {

		long start = System.nanoTime();

		
		// Booking ID and Booked Seats
		HashMap<Integer, List<String>> bookingsMap = new HashMap<Integer, List<String>>();
		
		// Grid Of Allotted Seats
		HashMap<String, List<Integer>> BusSeatsGrid = new HashMap<String, List<Integer>>();
		
		ArrayList<String> seatRowIndexes = new ArrayList<String>();

		for (int i = 0; i < 26; i++) {
			BusSeatsGrid.put(Character.toString((char) (i + 65)), new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0)));
			seatRowIndexes.add(Character.toString((char) (i + 65)));
		}

		for (BusBooking busBooking : busBookingsList) {
			int busBookingId = busBooking.getBusBookingId().intValue();
			List<String> seatIDs = new ArrayList<String>();
			List<Ticket> ticketsList = busBooking.getTickets();
			for (Ticket ticket : ticketsList) {
				seatIDs.add(ticket.getBusSeat().getSeatName());
			}
			bookingsMap.put(busBookingId, seatIDs);
		}

		System.out.println(bookingsMap);

//		bookingsMap.put(1, new ArrayList<String>(Arrays.asList("A2", "H1", "H4")));
//		bookingsMap.put(2, new ArrayList<String>(Arrays.asList("A1", "H2", "H3")));
//		bookingsMap.put(3, new ArrayList<String>(Arrays.asList("A3", "G1", "G3")));
		// bookingsMap.put(2, new ArrayList<String>(Arrays.asList("A1", "A4", "D3" )));
		// bookingsMap.put(3, new ArrayList<String>(Arrays.asList("G1", "G4" )));
		// bookingsMap.put(4, new ArrayList<String>(Arrays.asList("D1", "D2", "D4")));
		// bookingsMap.put(5, new ArrayList<String>(Arrays.asList("F2", "F3" )));
		// bookingsMap.put(6, new ArrayList<String>(Arrays.asList( "E4", "F4")));
		// bookingsMap.put(7, new ArrayList<String>(Arrays.asList( "B3", "E1")));
		// bookingsMap.put(8, new ArrayList<String>(Arrays.asList("G3", "G2", "H2")));

		
		// Iterating Bookings Map and Updating Seats Booked with 1
		for (Map.Entry row : bookingsMap.entrySet()) {

			ArrayList list = (ArrayList) row.getValue();

			for (int i = 0; i < list.size(); i++) {
				String seat = (String) list.get(i);
				char seatRow = seat.charAt(0);
				ArrayList seatsRowList = (ArrayList) BusSeatsGrid.get(String.valueOf(seatRow));
				int seatIndexNo = Character.getNumericValue(seat.charAt(1));
				seatsRowList.set(seatIndexNo - 1, row.getKey()); // Updating with Booking ID
				BusSeatsGrid.put(String.valueOf(seatRow), seatsRowList);
			}
		}

		for (Map.Entry row : BusSeatsGrid.entrySet()) {
			System.out.println(row.getKey() + " ::: " + row.getValue());
		}

		ArrayList<Integer> bookingsOrdersList = new ArrayList<Integer>();
		ArrayList<Integer> holdList = new ArrayList<Integer>();

		//
		for (int i = seatRowIndexes.size() - 1; i >= 0; i--) {

			ArrayList<Integer> seatsRowList = (ArrayList) BusSeatsGrid.get(seatRowIndexes.get(i));

			boolean onboard = false;

			for (int seatIndex = 0; seatIndex < 4; seatIndex++) {
				int bookingId = (int) seatsRowList.get(seatIndex);

				for (int holdIndex = 0; holdIndex < holdList.size(); holdIndex++) {
					int holdBookingId = (int) holdList.get(holdIndex);
					onboard = BoardingSequenceFinder.canOnboard(holdBookingId, bookingsMap, BusSeatsGrid, holdList);

					if (onboard) {
						BusSeatsGrid = BoardingSequenceFinder.replaceBusSeatBookingWithZero(holdBookingId, bookingsMap,
								BusSeatsGrid);
						holdList.remove(holdIndex);
						bookingsOrdersList.add(holdBookingId);
						break;
					}

				}
				if (bookingId != 0) {
					onboard = BoardingSequenceFinder.canOnboard(bookingId, bookingsMap, BusSeatsGrid, holdList);

					if (onboard) {
						BusSeatsGrid = BoardingSequenceFinder.replaceBusSeatBookingWithZero(bookingId, bookingsMap,
								BusSeatsGrid);
						if (bookingsOrdersList.contains((Integer) bookingId))
							continue;
						bookingsOrdersList.add(bookingId);
					} else {
						if (holdList.contains((Integer) bookingId))
							continue;
						holdList.add(bookingId);
					}
				}
			}
		}
		long end = System.nanoTime();

		long execution = end - start;
		double seconds = (double) execution / 1_000_000_000.0;
		System.out.println("program execution time: " + seconds + " seconds");

		System.out.println("Order of bookingIds");
		System.out.println(bookingsOrdersList);
		System.out.println("Deadlock occured bookingIds");
		System.out.println(holdList);

		bookingsOrdersList.addAll(holdList);

		System.out.println(bookingsOrdersList);

		return bookingsOrdersList;

	}

	public static HashMap<String, List<Integer>> replaceBusSeatBookingWithZero(int bookingId,
			HashMap<Integer, List<String>> bookingsMap, HashMap<String, List<Integer>> BusSeats) {
		ArrayList<String> bookingSeatsList = (ArrayList) bookingsMap.get(bookingId);
		for (int bookingSeatIndex = 0; bookingSeatIndex < bookingSeatsList.size(); bookingSeatIndex++) {
			String bookingSeat = (String) bookingSeatsList.get(bookingSeatIndex);
			char rowIndex = (char) bookingSeat.charAt(0);
			int columnSeat = Character.getNumericValue(bookingSeat.charAt(1));
			int columnSeatIndex = columnSeat - 1;

			ArrayList indexSeatsList = (ArrayList) BusSeats.get(String.valueOf(rowIndex));
			indexSeatsList.set(columnSeatIndex, 0);

			BusSeats.put(String.valueOf(rowIndex), indexSeatsList);
		}
		return BusSeats;
	}

	public static boolean canOnboard(int bookingId, HashMap<Integer, List<String>> bookingsMap,
			HashMap<String, List<Integer>> BusSeats, ArrayList<Integer> holdList) {

		boolean onboard = true;
		ArrayList<String> listOfAllSeatsUnderBookingID = (ArrayList) bookingsMap.get(bookingId);

		for (int bookingSeatIndex = 0; bookingSeatIndex < listOfAllSeatsUnderBookingID.size(); bookingSeatIndex++) {

			String bookingSeat = (String) listOfAllSeatsUnderBookingID.get(bookingSeatIndex);
			char rowIndex = (char) bookingSeat.charAt(0);
			int columnSeat = Character.getNumericValue(bookingSeat.charAt(1));
			int columnSeatIndex = columnSeat - 1;

			ArrayList indexSeatsList = (ArrayList) BusSeats.get(String.valueOf(rowIndex));

			// Checking Windows Seat
			if (columnSeatIndex == 0 || columnSeatIndex == 3)
				continue;

			// Non Windows Left Side
			if (columnSeatIndex == 1 && (int) indexSeatsList.get(0) != 0) {
				if (holdList.contains((Integer) indexSeatsList.get(0))
						&& (Integer) indexSeatsList.get(0) == bookingId) {
					continue;
				}
				onboard = false;
				break;
			}

			// Non Windows Right Side
			if (columnSeatIndex == 2 && (int) indexSeatsList.get(3) != 0) {
				if (holdList.contains((Integer) indexSeatsList.get(3))
						&& (Integer) indexSeatsList.get(3) == bookingId) {
					continue;
				}
				onboard = false;
				break;
			}

		}
		return onboard;
	}
}

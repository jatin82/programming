class City{
  int cityId;
  String cityName;
  String province;
}

class Movie{
  int movieId;
  String movieName;
  MovieMetaData movieInfo;
}

class Cinema {
  int cinemaId;
  Stirng cinemaName;
  City city;
}

class Seat{
  int seatId;
  SeatType type;
  Cinema cinema;
}

class Show {
  int showId;
  String showDescription;
  Cinema cinema;
  Movie movie;
}

class Ticket{
  String ticketId
  TicketStatus status;
  Show show;
  String bookingId;
  String paymentId;
}

// remember this
class ShowSeat {
  int showSeatId;
  Show showId;
  Seat seatId;
  Booking bookingId;
  SeatStatus status;
  Double price;
}

class Booking {
  String bookingId;
  Show showId;
  BookingStatus status;
  User user;
}

class Payment {
  String paymentId;
  Booking bookingId;
  Double price;
  PaymentMethod method;
  TransactionTimestamp timestamp;
}

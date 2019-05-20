package example.formatter;

import example.dto.CustomerView;
import example.dto.RentMovieView;

import java.io.Serializable;

public interface RentalHistoryFormatter<T extends Serializable> {
    T format(CustomerView customerView, RentMovieView rentMovieView);
}

package com.example.rentacarv1.services.dtos.requests.rental;

import com.example.rentacarv1.services.constants.rental.RentalMessages;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = RentalMessages.START_DATE_CANNOT_BE_FURTHER_BACK_THAN_TODAY)
    private LocalDate startDate;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message =RentalMessages.END_DATE_CANNOT_BE_FURTHER_BACK_THAN_TODAY)
    private LocalDate endDate;

    @Min(value = 0,message = RentalMessages.DISCOUNT_CANNOT_BE_LOWER_ZERO)
    private Double discount;

    @Positive(message =RentalMessages.POSITIVE_NUMBER)
    private int carId;

    @Positive(message = RentalMessages.POSITIVE_NUMBER)
    private int customerId;

    @Positive(message = RentalMessages.POSITIVE_NUMBER)
    private int employeeId;



}

package com.car.rental.controller;

import com.car.rental.domain.User;
import com.car.rental.domain.Vehicle;
import com.car.rental.domain.dto.BookingDto;
import com.car.rental.facade.BookingFacade;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingFacade facade;

    private User customers = new User(1L, "username", "test@test.pl", "password", 1, 125489L, null);
    private Vehicle vehicle = new Vehicle(1L, "BMW", "Desc rpiszon", new BigDecimal(150), null);


    @Test
    void shouldFetchBookings() throws Exception {
        //Given
        List<BookingDto> bookingDtoList = new ArrayList<>();
        bookingDtoList.add(new BookingDto(1L, null, null, LocalDate.of(2020, Month.JANUARY, 20), LocalDate.of(2020, Month.JANUARY, 25)));

        when(facade.getBookings()).thenReturn(bookingDtoList);

        //When && Then
        mockMvc.perform(get("/v1/booking/getBookings")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].bookingFromDate", is("2020-01-20")))
                .andExpect(jsonPath("$[0].bookingToDate", is("2020-01-25")));
    }
}
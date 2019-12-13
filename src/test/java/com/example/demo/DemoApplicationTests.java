package com.example.demo;

import com.example.demo.model.Adress;
import com.example.demo.model.Customer;
import com.example.demo.model.MyDate;
import com.example.demo.model.Trip;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldCreateUser() throws Exception {
        Customer customer = createCustomer();
        assertNotNull(createCustomer().getName());
        assertNotNull(createCustomer().getAdress());
        assertNotNull(createCustomer().getId());
        assertNotNull(createCustomer().getTrip().getStart());

    }

    private Customer getTestCustomer() {
        Customer customer = new Customer();
        MyDate start = new MyDate(2019, 11, 7);
        MyDate end = new MyDate(2019, 11, 14);
        customer.setName("Adam Nowak");
        customer.setAdress(new Adress("Kopernika 34", "90-098", "Warszawa"));
        customer.setId(1);
        customer.setTrip(new Trip("Wietnam", start, end, 9909));
        return customer;
    }

    private Customer createCustomer() throws Exception {
        Customer customer = getTestCustomer();
        String postValue = OBJECT_MAPPER.writeValueAsString(customer);
        MvcResult storyResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/POST")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postValue))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        return OBJECT_MAPPER.readValue(storyResult.getResponse().getContentAsString(), Customer.class);
    }


}

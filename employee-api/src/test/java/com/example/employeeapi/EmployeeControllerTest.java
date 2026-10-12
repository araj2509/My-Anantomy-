package com.example.employeeapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getEmployeesReturnsTwoSampleEmployees() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Asha Sharma"));
    }

    @Test
    void validEmployeeReturns201() throws Exception {
        String json = "{\"name\":\"Rahul\",\"email\":\"rahul@example.com\",\"age\":25}";
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Rahul"));
    }

    @Test
    void invalidEmployeeReturns400() throws Exception {
        String json = "{\"name\":\"   \",\"email\":\"wrong-email\",\"age\":15}";
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void blankNameAloneReturns400() throws Exception {
        String json = "{\"name\":\"\",\"email\":\"a@example.com\",\"age\":30}";
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void invalidEmailAloneReturns400() throws Exception {
        String json = "{\"name\":\"Meera\",\"email\":\"abc\",\"age\":30}";
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void ageBelow18Returns400() throws Exception {
        String json = "{\"name\":\"Meera\",\"email\":\"meera@example.com\",\"age\":16}";
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
    }
}

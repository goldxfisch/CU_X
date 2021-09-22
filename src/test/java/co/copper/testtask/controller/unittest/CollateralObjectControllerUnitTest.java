package co.copper.testtask.controller.unittest;

import co.copper.testtask.controller.CollateralObjectController;
import co.copper.testtask.dto.AssetDto;
import co.copper.testtask.dto.Collateral;
import co.copper.testtask.service.CollateralService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CollateralObjectController.class)
class CollateralObjectControllerUnitTest {

    @MockBean
    CollateralService collateralService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testFindById() throws Exception{
      AssetDto assetDto=  new AssetDto(4L, "TEST ASSET 4", "INR", (short) 2023, new BigDecimal(1100000.99));
        List<AssetDto> assetDtoList = Arrays.asList(assetDto);
        Mockito.when(collateralService.getInfo("4")).thenReturn((Collateral) assetDtoList.get(0));

        mockMvc.perform(get("/collaterals/{id}",4))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", Matchers.is("TEST ASSET 4")));
    }

    @Test
    public void testSaveAssset() throws Exception{
        AssetDto assetDto=  new AssetDto(4L, "TEST ASSET 4", "INR", (short) 2023, new BigDecimal(1100000.99));
        List<AssetDto> assetDtoList = Arrays.asList(assetDto);
        Mockito.when(collateralService.saveCollateral(assetDtoList.get(0))).thenReturn(4L);
        mockMvc
        .perform(post("/collaterals")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n    \"type\": \"asset\",\n    \"id\": 4,\n    \"name\": \"TEST 4\",\n    \"currency\": \"INR\",\n    \"year\": 2023,\n    \"value\": 1200000.99\n}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
// Status is 200 instead of 201


    }
}
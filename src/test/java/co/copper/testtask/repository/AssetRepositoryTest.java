package co.copper.testtask.repository;

import co.copper.testtask.model.Asset;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AssetRepositoryTest {

    @Autowired
    AssetRepository assetRepository;

    @Test
    @Order(1)
    public void createAsset(){
        Asset asset = new Asset();
        asset.setName("TEST ASSET");
        asset.setId(1L);
        asset.setValue(new BigDecimal(123.45));
        asset.setYear((short) 2020);
        asset.setCurrency("GBP");

        assetRepository.save(asset);
        assertNotNull(assetRepository.findById(1L).get());
        //log.info("====================> {}", assetRepository.findById(1L).get());

    }

    @Test
    @Order(2)
    public void createAsset2(){
        Asset asset = new Asset();
        asset.setName("TEST ASSET 2");
        asset.setId(2L);
        asset.setValue(new BigDecimal(987.465));
        asset.setYear((short) 2021);
        asset.setCurrency("USD");

        assetRepository.save(asset);
        assertNotNull(assetRepository.findById(2L).get());
        //log.info("====================> {}", assetRepository.findById(1L).get());

    }

    @Test
    @Order(3)
    public void testReadAllAssets () {
        List list = (List) assetRepository.findAll();
        assertThat(list).size().isEqualTo(2);

    }

    @Test
    @Order(4)
    public void testRead () {
        Asset asset = assetRepository.findById(1L).get();
        assertEquals("TEST ASSET", asset.getName());


    }
}
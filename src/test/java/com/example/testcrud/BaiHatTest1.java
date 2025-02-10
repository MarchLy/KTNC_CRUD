package com.example.testcrud;

import com.example.testcrud.entity.BaiHat1;
import com.example.testcrud.service.BaiHatService1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BaiHatTest1 {
    BaiHatService1 service;

    @BeforeEach
    public void setup() {
        service = new BaiHatService1();
    }

    @Test
    public void testAddValid() {
        BaiHat1 bh = new BaiHat1(1, "Em Của Ngày Hôm Qua", "Sơn Tùng MTP", "Pop", 240);
        service.addBaiHat(bh);
        assertEquals(1, service.getAll().size());
    }

    @Test
    public void testUpdateValid() {
        BaiHat1 bh = new BaiHat1(1, "Em Của Ngày Hôm Qua", "Sơn Tùng MTP", "Pop", 240);
        service.addBaiHat(bh);
        BaiHat1 updatedBh = new BaiHat1(1, "Chạy Ngay Đi", "Sơn Tùng MTP", "Pop", 300);
        service.updateBaiHat(updatedBh, 1);
        assertEquals("Chạy Ngay Đi", service.getAll().get(0).getTenBaiHat());
    }

    @Test
    public void testDeleteValid() {
        BaiHat1 bh = new BaiHat1(1, "Em Của Ngày Hôm Qua", "Sơn Tùng MTP", "Pop", 240);
        service.addBaiHat(bh);
        service.deleteBaiHat(1);
        assertEquals(0, service.getAll().size());
    }

    @Test
    public void testSearchValid() {
        BaiHat1 bh = new BaiHat1(1, "Em Của Ngày Hôm Qua", "Sơn Tùng MTP", "Pop", 240);
        service.addBaiHat(bh);
        BaiHat1 foundBh = service.searchBaiHat(1);
        assertNotNull(foundBh);
        assertEquals("Em Của Ngày Hôm Qua", foundBh.getTenBaiHat());
    }

    @Test
    public void testSearchInvalid() {
        BaiHat1 bh = new BaiHat1(1, "Em Của Ngày Hôm Qua", "Sơn Tùng MTP", "Pop", 240);
        service.addBaiHat(bh);
        BaiHat1 foundBh = service.searchBaiHat(2);
        assertNull(foundBh);
    }
}

package com.example.testcrud;

import com.example.testcrud.entity.BaiHat;
import com.example.testcrud.service.BaiHatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BaiHatTest {
    BaiHatService service;

    @BeforeEach
    public void setup() {
        service = new BaiHatService();
    }

    @Test
    public void testAddValid() {
        BaiHat bh = new BaiHat(1, "Em Của Ngày Hôm Qua", "Sơn Tùng MTP", "Pop", 240);
        service.addBaiHat(bh);
        assertEquals(1, service.getAll().size());
    }

    @Test
    public void testUpdateValid() {
        BaiHat bh = new BaiHat(1, "Em Của Ngày Hôm Qua", "Sơn Tùng MTP", "Pop", 240);
        service.addBaiHat(bh);
        BaiHat updatedBh = new BaiHat(1, "Chạy Ngay Đi", "Sơn Tùng MTP", "Pop", 300);
        service.updateBaiHat(updatedBh, 1);
        assertEquals("Chạy Ngay Đi", service.getAll().get(0).getTenBaiHat());
    }

    @Test
    public void testDeleteValid() {
        BaiHat bh = new BaiHat(1, "Em Của Ngày Hôm Qua", "Sơn Tùng MTP", "Pop", 240);
        service.addBaiHat(bh);
        service.deleteBaiHat(1);
        assertEquals(0, service.getAll().size());
    }

    @Test
    public void testSearchValid() {
        BaiHat bh = new BaiHat(1, "Em Của Ngày Hôm Qua", "Sơn Tùng MTP", "Pop", 240);
        service.addBaiHat(bh);
        BaiHat foundBh = service.searchBaiHat(1);
        assertNotNull(foundBh);
        assertEquals("Em Của Ngày Hôm Qua", foundBh.getTenBaiHat());
    }

    @Test
    public void testSearchInvalid() {
        BaiHat bh = new BaiHat(1, "Em Của Ngày Hôm Qua", "Sơn Tùng MTP", "Pop", 240);
        service.addBaiHat(bh);
        BaiHat foundBh = service.searchBaiHat(2);
        assertNull(foundBh);
    }
}

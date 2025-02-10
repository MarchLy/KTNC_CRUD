package com.example.testcrud;

import com.example.testcrud.entity.SinhVien;
import com.example.testcrud.service.SinhVienService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SinhVienTest {

    SinhVienService service;

    @BeforeEach
    public void setup() {
        service = new SinhVienService();
    }

    @Test
    public void testAddValid() {
        SinhVien sv = new SinhVien(1, "Nguyen Van A", "CNTT", "2023");
        service.addSinhVien(sv);
        assertEquals(1, service.getAll().size());
    }

    @Test
    public void testUpdateValid() {
        SinhVien sv = new SinhVien(1, "Nguyen Van A", "CNTT", "2023");
        service.addSinhVien(sv);
        SinhVien updatedSV = new SinhVien(1, "Nguyen Van B", "KT", "2024");
        service.updateSinhVien(updatedSV, 1);
        assertEquals("Nguyen Van B", service.getAll().get(0).getTenSV());
    }

    @Test
    public void testDeleteValid() {
        SinhVien sv = new SinhVien(1, "Nguyen Van A", "CNTT", "2023");
        service.addSinhVien(sv);
        service.deleteSinhVien(1);
        assertEquals(0, service.getAll().size());
    }

    @Test
    public void testSearchValid() {
        SinhVien sv = new SinhVien(1, "Nguyen Van A", "CNTT", "2023");
        service.addSinhVien(sv);
        SinhVien foundSV = service.searchSinhVien(1);
        assertNotNull(foundSV);
    }
}

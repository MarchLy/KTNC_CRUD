package com.example.testcrud;

import com.example.testcrud.entity.XeOTO;
import com.example.testcrud.service.XeOTOService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XeOTOTest {
    XeOTOService service;

    @BeforeEach
    public void setup() {
        service = new XeOTOService();
    }

    @Test
    public void testAddValid() {
        XeOTO xe = new XeOTO(1, "MayBack", 1000f, "Khong");
        service.addXeOTO(xe);
        assertEquals(1, service.getAll().size());
    }

    @Test
    public void testUpdateValid() {
        XeOTO xe = new XeOTO(1, "MayBack", 1000f, "Khong");
        service.addXeOTO(xe);
        XeOTO updatedXe = new XeOTO(1, "MayBack", 2000f, "Updated");
        service.updateXeOTO(updatedXe, 1);
        assertEquals(2000f, service.getAll().get(0).getGia());
    }

    @Test
    public void testDeleteValid() {
        XeOTO xe = new XeOTO(1, "MayBack", 1000f, "Khong");
        service.addXeOTO(xe);
        service.deleteXeOTO(1);
        assertEquals(0, service.getAll().size());
    }

    @Test
    public void testSearchValid() {
        XeOTO xe = new XeOTO(1, "MayBack", 1000f, "Khong");
        service.addXeOTO(xe);
        XeOTO foundXe = service.searchXeOTO(1);
        assertNotNull(foundXe);
    }

}
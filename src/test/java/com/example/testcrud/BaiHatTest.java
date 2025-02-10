package com.example.testcrud;



import com.example.testcrud.entity.BaiHat;
import com.example.testcrud.service.BaiHatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BaiHatTest {
    private BaiHatService service;

    @BeforeEach
    public void setup() {
        service = new BaiHatService();
    }

    // ============================== TEST ADD ==================================
    @Test
    public void testAddBaiHat_Valid() {
        BaiHat baiHat = new BaiHat("BH01", "Bai Hat 1", "Ca Si A", 300);
        boolean result = service.addBaiHat(baiHat);
        Assert.assertTrue(result);
    }

    @Test
    public void testAddBaiHat_Invalid_NullID() {
        BaiHat baiHat = new BaiHat(null, "Bai Hat 1", "Ca Si A", 300);
        boolean result = service.addBaiHat(baiHat);
        Assert.assertFalse(result);
    }

    @Test
    public void testAddBaiHat_Invalid_NullName() {
        BaiHat baiHat = new BaiHat("BH02", null, "Ca Si B", 300);
        boolean result = service.addBaiHat(baiHat);
        Assert.assertFalse(result);
    }

    @Test
    public void testAddBaiHat_Invalid_ZeroDuration() {
        BaiHat baiHat = new BaiHat("BH03", "Bai Hat 3", "Ca Si C", 0);
        boolean result = service.addBaiHat(baiHat);
        Assert.assertFalse(result);
    }

    @Test
    public void testAddBaiHat_Boundary_DurationOneSecond() {
        BaiHat baiHat = new BaiHat("BH04", "Bai Hat 4", "Ca Si D", 1);
        boolean result = service.addBaiHat(baiHat);
        Assert.assertTrue(result);
    }

    // ============================== TEST UPDATE ==============================
    @Test
    public void testUpdateBaiHat_Valid() {
        BaiHat baiHat = new BaiHat("BH01", "Bai Hat 1", "Ca Si A", 300);
        service.addBaiHat(baiHat);

        BaiHat baiHatMoi = new BaiHat("BH01", "Bai Hat Moi", "Ca Si Moi", 400);
        boolean result = service.updateBaiHat("BH01", baiHatMoi);
        Assert.assertTrue(result);
    }

    @Test
    public void testUpdateBaiHat_Invalid_NonExistingID() {
        BaiHat baiHat = new BaiHat("BH01", "Bai Hat 1", "Ca Si A", 300);
        service.addBaiHat(baiHat);

        BaiHat baiHatMoi = new BaiHat("BH02", "Bai Hat Moi", "Ca Si Moi", 400);
        boolean result = service.updateBaiHat("BH02", baiHatMoi);
        Assert.assertFalse(result);
    }

    @Test
    public void testUpdateBaiHat_Boundary_DurationOneSecond() {
        BaiHat baiHat = new BaiHat("BH01", "Bai Hat 1", "Ca Si A", 300);
        service.addBaiHat(baiHat);

        BaiHat baiHatMoi = new BaiHat("BH01", "Bai Hat Moi", "Ca Si Moi", 1);
        boolean result = service.updateBaiHat("BH01", baiHatMoi);
        Assert.assertTrue(result);
    }

    @Test
    public void testUpdateBaiHat_Invalid_NullName() {
        BaiHat baiHat = new BaiHat("BH01", "Bai Hat 1", "Ca Si A", 300);
        service.addBaiHat(baiHat);

        BaiHat baiHatMoi = new BaiHat("BH01", null, "Ca Si Moi", 400);
        boolean result = service.updateBaiHat("BH01", baiHatMoi);
        Assert.assertFalse(result);
    }

    @Test
    public void testUpdateBaiHat_Invalid_EmptyID() {
        BaiHat baiHat = new BaiHat("BH01", "Bai Hat 1", "Ca Si A", 300);
        service.addBaiHat(baiHat);

        BaiHat baiHatMoi = new BaiHat("", "Bai Hat Moi", "Ca Si Moi", 400);
        boolean result = service.updateBaiHat("", baiHatMoi);
        Assert.assertFalse(result);
    }

    // ============================== TEST DELETE ==============================
    @Test
    public void testDeleteBaiHat_Valid() {
        BaiHat baiHat = new BaiHat("BH01", "Bai Hat 1", "Ca Si A", 300);
        service.addBaiHat(baiHat);

        boolean result = service.deleteBaiHat("BH01");
        Assert.assertTrue(result);
    }

    @Test
    public void testDeleteBaiHat_Invalid_NonExistingID() {
        BaiHat baiHat = new BaiHat("BH01", "Bai Hat 1", "Ca Si A", 300);
        service.addBaiHat(baiHat);

        boolean result = service.deleteBaiHat("BH02");
        Assert.assertFalse(result);
    }

    @Test
    public void testDeleteBaiHat_Invalid_EmptyID() {
        BaiHat baiHat = new BaiHat("BH01", "Bai Hat 1", "Ca Si A", 300);
        service.addBaiHat(baiHat);

        boolean result = service.deleteBaiHat("");
        Assert.assertFalse(result);
    }

    @Test
    public void testDeleteBaiHat_Invalid_NullID() {
        BaiHat baiHat = new BaiHat("BH01", "Bai Hat 1", "Ca Si A", 300);
        service.addBaiHat(baiHat);

        boolean result = service.deleteBaiHat(null);
        Assert.assertFalse(result);
    }

    @Test
    public void testDeleteBaiHat_Boundary_ValidID() {
        BaiHat baiHat = new BaiHat("1", "Bai Hat 1", "Ca Si A", 300);
        service.addBaiHat(baiHat);

        boolean result = service.deleteBaiHat("1");
        Assert.assertTrue(result);
    }
}
package com.example.testcrud.service;


import com.example.testcrud.entity.BaiHat;

import java.util.ArrayList;
import java.util.List;

public class BaiHatService {
    private final List<BaiHat> danhSachBaiHat = new ArrayList<>();

    // Thêm bài hát
    public boolean addBaiHat(BaiHat baiHat) {
        if (baiHat.getId() == null || baiHat.getTen() == null || baiHat.getDoDai() <= 0) {
            return false; // Điều kiện không hợp lệ
        }
        danhSachBaiHat.add(baiHat);
        return true;
    }

    // Sửa bài hát
    public boolean updateBaiHat(String id, BaiHat baiHatMoi) {
        for (BaiHat baiHat : danhSachBaiHat) {
            if (baiHat.getId().equals(id)) {
                baiHat.setTen(baiHatMoi.getTen());
                baiHat.setTenCaSi(baiHatMoi.getTenCaSi());
                baiHat.setDoDai(baiHatMoi.getDoDai());
                return true;
            }
        }
        return false; // Không tìm thấy bài hát
    }

    // Xóa bài hát
    public boolean deleteBaiHat(String id) {
        return danhSachBaiHat.removeIf(baiHat -> baiHat.getId().equals(id));
    }

    public List<BaiHat> getAll() {
        return danhSachBaiHat;
    }
}

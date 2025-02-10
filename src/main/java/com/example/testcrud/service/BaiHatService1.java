package com.example.testcrud.service;

import com.example.testcrud.entity.BaiHat1;

import java.util.ArrayList;
import java.util.List;

public class BaiHatService1 {
    private List<BaiHat1> baiHatList = new ArrayList<>();

    // Thêm bài hát
    public void addBaiHat(BaiHat1 bh) {
        baiHatList.add(bh);
    }

    // Sửa bài hát
    public void updateBaiHat(BaiHat1 bh, int id) {
        for (int i = 0; i < baiHatList.size(); i++) {
            if (baiHatList.get(i).getId() == id) {
                baiHatList.set(i, bh);
                return;
            }
        }
    }

    // Xóa bài hát
    public void deleteBaiHat(int id) {
        baiHatList.removeIf(bh -> bh.getId() == id);
    }

    // Tìm kiếm bài hát theo ID
    public BaiHat1 searchBaiHat(int id) {
        for (BaiHat1 bh : baiHatList) {
            if (bh.getId() == id) {
                return bh;
            }
        }
        return null;
    }

    // Lấy danh sách tất cả bài hát
    public List<BaiHat1> getAll() {
        return baiHatList;
    }

//    private final List<BaiHat> danhSachBaiHat = new ArrayList<>();
//    public boolean addBaiHat(BaiHat baiHat) {
//        if (baiHat.getId() == null || baiHat.getTen() == null || baiHat.getDoDai() <= 0) {
//            return false; // Điều kiện không hợp lệ
//        }
//        danhSachBaiHat.add(baiHat);
//        return true;
//    }
//
//    // Sửa bài hát
//    public boolean updateBaiHat(String id, BaiHat baiHatMoi) {
//        for (BaiHat baiHat : danhSachBaiHat) {
//            if (baiHat.getId().equals(id)) {
//                baiHat.setTen(baiHatMoi.getTen());
//                baiHat.setTenCaSi(baiHatMoi.getTenCaSi());
//                baiHat.setDoDai(baiHatMoi.getDoDai());
//                return true;
//            }
//        }
//        return false; // Không tìm thấy bài hát
//    }
//
//    // Xóa bài hát
//    public boolean deleteBaiHat(String id) {
//        return danhSachBaiHat.removeIf(baiHat -> baiHat.getId().equals(id));
//    }
//
//    public List<BaiHat> getAll() {
//        return danhSachBaiHat;
//    }
}

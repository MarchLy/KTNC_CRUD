package com.example.testcrud.service;

import com.example.testcrud.entity.BaiHat;

import java.util.ArrayList;
import java.util.List;

public class BaiHatService {
    private List<BaiHat> baiHatList = new ArrayList<>();

    // Thêm bài hát
    public void addBaiHat(BaiHat bh) {
        baiHatList.add(bh);
    }

    // Sửa bài hát
    public void updateBaiHat(BaiHat bh, int id) {
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
    public BaiHat searchBaiHat(int id) {
        for (BaiHat bh : baiHatList) {
            if (bh.getId() == id) {
                return bh;
            }
        }
        return null;
    }

    // Lấy danh sách tất cả bài hát
    public List<BaiHat> getAll() {
        return baiHatList;
    }
}

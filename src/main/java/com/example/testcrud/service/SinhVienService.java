package com.example.testcrud.service;

import com.example.testcrud.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    private List<SinhVien> sinhVienList = new ArrayList<>();

    public void addSinhVien(SinhVien sv) {
        sinhVienList.add(sv);
    }

    public void updateSinhVien(SinhVien sv, int maSV) {
        for (int i = 0; i < sinhVienList.size(); i++) {
            if (sinhVienList.get(i).getMaSV() == maSV) {
                sinhVienList.set(i, sv);
                return;
            }
        }
    }

    public void deleteSinhVien(int maSV) {
        sinhVienList.removeIf(sv -> sv.getMaSV() == maSV);
    }

    public SinhVien searchSinhVien(int maSV) {
        for (SinhVien sv : sinhVienList) {
            if (sv.getMaSV() == maSV) {
                return sv;
            }
        }
        return null;
    }

    public List<SinhVien> getAll() {
        return sinhVienList;
    }
}

package com.example.testcrud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaiHat1 {

    private int id;
    private String tenBaiHat;
    private String tenCaSi;
    private String theLoai;
    private int thoiLuong;
}

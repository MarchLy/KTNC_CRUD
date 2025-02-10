package com.example.testcrud.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaiHat {
    private String id;
    private String ten;
    private String tenCaSi;
    private int doDai;
}

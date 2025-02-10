package com.example.testcrud.service;

import com.example.testcrud.entity.XeOTO;

import java.util.ArrayList;
import java.util.List;

public class XeOTOService {
    private List<XeOTO> xeList = new ArrayList<>();

    public void addXeOTO(XeOTO xe) {
        xeList.add(xe);
    }

    public void updateXeOTO(XeOTO xe, int id) {
        for (int i = 0; i < xeList.size(); i++) {
            if (xeList.get(i).getId() == id) {
                xeList.set(i, xe);
                return;
            }
        }
    }

    public void deleteXeOTO(int id) {
        xeList.removeIf(xe -> xe.getId() == id);
    }

    public XeOTO searchXeOTO(int id) {
        for (XeOTO xe : xeList) {
            if (xe.getId() == id) {
                return xe;
            }
        }
        return null;
    }

    public List<XeOTO> getAll() {
        return xeList;
    }
}

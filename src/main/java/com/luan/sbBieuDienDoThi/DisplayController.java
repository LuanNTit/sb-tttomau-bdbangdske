package com.luan.sbBieuDienDoThi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisplayController {
    @Autowired
    DisplayService displayService;
    @GetMapping("/")
    public void hienThi() {
        displayService.hienThi();
    }
}

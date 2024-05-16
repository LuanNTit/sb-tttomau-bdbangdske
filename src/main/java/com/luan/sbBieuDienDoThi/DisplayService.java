package com.luan.sbBieuDienDoThi;

import org.springframework.stereotype.Service;

@Service
public class DisplayService {
    static DSKe taoDinhKe(int dinhKe, DSKe lienKet) {
        return new DSKe(dinhKe, lienKet);
    }
    public void hienThi() {
        DoThi doThi = new DoThi(7);

        doThi.dsKe[0] = taoDinhKe(1, taoDinhKe(2, taoDinhKe(3, taoDinhKe(6, null))));
        doThi.dsKe[1] = taoDinhKe(0, taoDinhKe(2, taoDinhKe(3, taoDinhKe(4, taoDinhKe(6, null)))));
        doThi.dsKe[2] = taoDinhKe(0, taoDinhKe(1, taoDinhKe(5, taoDinhKe(6, null))));
        doThi.dsKe[3] = taoDinhKe(0, taoDinhKe(1, taoDinhKe(4, taoDinhKe(5, null))));
        doThi.dsKe[4] = taoDinhKe(1, taoDinhKe(3, taoDinhKe(5, taoDinhKe(6, null))));
        doThi.dsKe[5] = taoDinhKe(2, taoDinhKe(3, taoDinhKe(4, taoDinhKe(6, null))));
        doThi.dsKe[6] = taoDinhKe(0, taoDinhKe(1, taoDinhKe(2, taoDinhKe(4, taoDinhKe(5, null)))));

        doThi.inDoThi();

        int mauDaTo = doThi.toMauDoThi();

        System.out.println("\nDo thi sau khi to mau:");
        doThi.hienThiThongTinDinh();

        System.out.println("\nThong ke ket qua:");
        doThi.sapXepMauVaHienThiMonThi(mauDaTo);
    }
}

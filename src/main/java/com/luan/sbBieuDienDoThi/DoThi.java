package com.luan.sbBieuDienDoThi;

import java.util.*;

public class DoThi {
    int soDinh;
    DSKe[] dsKe;
    Dinh[] dinh;

    DoThi(int soDinh) {
        this.soDinh = soDinh;
        dsKe = new DSKe[soDinh];
        dinh = new Dinh[soDinh];
    }

    void khoiTaoThongTinDinh() {
        for (int i = 0; i < soDinh; i++) {
            dinh[i] = new Dinh(i, 0, 0);
            DSKe ke = dsKe[i];
            int bac = 0;
            while (ke != null) {
                bac++;
                ke = ke.lienKet;
            }
            dinh[i].bac = bac;
        }
    }

    void inDoThi() {
        for (int i = 0; i < soDinh; i++) {
            DSKe hienTai = dsKe[i];
            System.out.print("Danh sach ke cua dinh " + i + ": ");
            while (hienTai != null) {
                System.out.print("(" + hienTai.dinhKe + ") ");
                hienTai = hienTai.lienKet;
            }
            System.out.println();
        }
    }

    void hienThiThongTinDinh() {
        System.out.println("Thong tin ve dinh: ");
        System.out.println("Dinh\tBac\tMau");
        for (int i = 0; i < soDinh; i++) {
            System.out.println(dinh[i].dinh + "\t" + dinh[i].bac + "\t" + dinh[i].mau);
        }
    }

    void toMau(int dinh, int mau) {
        this.dinh[dinh].mau = mau;
    }

    boolean laDinhKe(int dinh, int dinhKe) {
        DSKe ke = dsKe[dinh];
        while (ke != null) {
            if (ke.dinhKe == dinhKe) {
                return true;
            }
            ke = ke.lienKet;
        }
        return false;
    }

    void sapXepDanhSachTheoBacGiamDan(List<Integer> danhSach) {
        Collections.sort(danhSach, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(dinh[b].bac, dinh[a].bac);
            }
        });
    }

    void sapXepMauVaHienThiMonThi(int soMau) {
        Map<Integer, List<Integer>> mauDinhMap = new HashMap<>();

        for (int i = 0; i < soMau; i++) {
            mauDinhMap.put(i + 1, new ArrayList<>());
        }

        for (int i = 0; i < soDinh; i++) {
            int mau = dinh[i].mau;
            mauDinhMap.get(mau).add(i);
        }

        for (int i = 1; i <= soMau; i++) {
            List<Integer> danhSachDinh = mauDinhMap.get(i);
            Collections.sort(danhSachDinh);
            System.out.print("Dot thi " + i + ": ");
            for (int dinh : danhSachDinh) {
                System.out.print(dinh + " ");
            }
            System.out.println();
        }
    }

    int toMauDoThi() {
        int i = 1;
        List<Integer> danhSachVPhay = new ArrayList<>();
        lapDanhSachVPhay(danhSachVPhay);

        while (true) {
            toMau(danhSachVPhay.get(0), i);
            for (int j = 1; j < danhSachVPhay.size(); j++) {
                int dinh = danhSachVPhay.get(j);
                if (!laDinhKe(danhSachVPhay.get(0), dinh))
                    toMau(dinh, i);
            }

            boolean tatCaDaToMau = true;
            for (int j = 0; j < soDinh; j++) {
                if (dinh[j].mau == 0) {
                    tatCaDaToMau = false;
                    break;
                }
            }

            if (tatCaDaToMau)
                break;

            List<Integer> newDanhSachVPhay = new ArrayList<>();
            for (int j = 0; j < soDinh; j++) {
                if (dinh[j].mau == 0)
                    newDanhSachVPhay.add(j);
            }
            danhSachVPhay = newDanhSachVPhay;
            sapXepDanhSachTheoBacGiamDan(danhSachVPhay);

            i++;
        }
        return i;
    }

    void lapDanhSachVPhay(List<Integer> danhSachVPhay) {
        khoiTaoThongTinDinh();
        for (int i = 0; i < soDinh; i++) {
            danhSachVPhay.add(i);
        }
        sapXepDanhSachTheoBacGiamDan(danhSachVPhay);
    }
}

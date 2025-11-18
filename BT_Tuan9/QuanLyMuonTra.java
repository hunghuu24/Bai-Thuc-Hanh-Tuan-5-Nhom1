import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyMuonTra {
    private ArrayList<MuonSach> danhSachMuon;
    private Scanner sc;

    public QuanLyMuonTra() {
        danhSachMuon = new ArrayList<MuonSach>();
        sc = new Scanner(System.in);
    }

    public void muonSach(QuanLySachImpl qlSach) {
        MuonSach s = new MuonSach();
        System.out.print("Nhap ma sach muon: ");
        String maSach = sc.nextLine();

        Sach sach = qlSach.TimKiemSach(maSach);
        if (sach == null) {
            System.out.println("Khong tim thay sach.");
            return;
        }

        s.Nhap();
        s.setMaMuon(maSach);
        s.setSach(sach);

        if (sach.getSoLuong() >= s.getSoLuongMuon()) {
            sach.setSoLuong(sach.getSoLuong() - s.getSoLuongMuon());
            danhSachMuon.add(s);
            System.out.println("Muon sach thanh cong!");
        } else {
            System.out.println("So luong sach khong du.");
        }
    }

    public void traSach(QuanLySachImpl qlSach) {
        System.out.print("Nhap ma sach tra: ");
        String maSach = sc.nextLine();

        for (MuonSach m : danhSachMuon) {
            if (m.getMaMuon().equals(maSach)) {
                Sach sachTra = qlSach.TimKiemSach(maSach);
                if (sachTra != null) {
                    sachTra.setSoLuong(sachTra.getSoLuong() + m.getSoLuongMuon());
                    danhSachMuon.remove(m);
                    System.out.println("Tra sach thanh cong!");
                    return;
                }
            }
        }
        System.out.println("Khong tim thay thong tin muon sach nay.");
    }

    public void kiemTraQuaHan() {
        LocalDate homNay = LocalDate.now();
        boolean coQuaHan = false;

        for (MuonSach m : danhSachMuon) {
            if (homNay.isAfter(m.getNgayTra())) {
                System.out.println("Khach Hang: " + m.getTenNguoiMuon() +
                                   " da qua han tra! Ngay tra: " + m.getNgayTra());
                coQuaHan = true;
            }
        }

        if (!coQuaHan) {
            System.out.println("Khong co sach nao qua han tra.");
        }
    }

    public void hienThiMuon() {
        if (danhSachMuon.isEmpty()) {
            System.out.println("Khong co sach dang muon.");
            return;
        }
        System.out.println("Danh sach sach dang muon:");
        for (MuonSach m : danhSachMuon) {
            System.out.println(m);
        }
    }
}

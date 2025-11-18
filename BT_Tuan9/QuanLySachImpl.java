import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLySachImpl implements IQuanLySach {
    private ArrayList<Sach> QuanLySach;
    private Scanner sc;

    public QuanLySachImpl() {
        QuanLySach = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    @Override
    public void ThemSach() {
        System.out.println("Chon loai sach can them:");
        System.out.println("1. Sach giao trinh");
        System.out.println("2. Sach tieu thuyet");

        int n = Integer.parseInt(sc.nextLine());
        Sach s;

        if (n == 1) 
            s = new SachGiaoTrinh();
        else if (n == 2) 
            s = new SachTieuThuyet();
        else {
            System.out.println("Lua chon khong hop le!");
            return;
        }

        s.Nhap();
        QuanLySach.add(s);
        System.out.println("Them thanh cong!");
    }

    @Override
    public boolean XoaSach(String maSach) {
        for (Sach s : QuanLySach) {
            if (s.getMaSach().equals(maSach)) {
                QuanLySach.remove(s);
                System.out.println("Xoa thanh cong!");
                return true;
            }
        }
        System.out.println("Khong tim thay sach!");
        return false;
    }

    @Override
    public boolean SuaSach(String maSach) {
        for (Sach s : QuanLySach) {
            if (s.getMaSach().equals(maSach)) {
                System.out.println("Nhap thong tin moi cho sach:");
                s.Nhap();
                System.out.println("Cap nhat thanh cong!");
                return true;
            }
        }
        System.out.println("Khong tim thay sach!");
        return false;
    }

    @Override
    public Sach TimKiemSach(String maSach) {
        for (Sach s : QuanLySach) {
            if (s.getMaSach().equals(maSach)) return s;
        }
        return null;
    }

    @Override
    public void sapXepSach() {
        Collections.sort(QuanLySach, new Comparator<Sach>() {
            @Override
            public int compare(Sach s1, Sach s2) {
                if (s1 instanceof SachTieuThuyet && s2 instanceof SachGiaoTrinh)
                    return -1;
                if (s1 instanceof SachGiaoTrinh && s2 instanceof SachTieuThuyet)
                    return 1;
                return s1.getMaSach().compareToIgnoreCase(s2.getMaSach());
            }
        });
    }
    public void KiemKe() {
    System.out.print("Nhap ma sach can kiem ke: ");
    String kiemke = sc.nextLine();
    Sach s = TimKiemSach(kiemke);
    if(s == null) {
        System.out.println("Khong tim thay sach co ma nay!");
        return;
    }
    int a;
    do {
        System.out.println("1. Kiem tra ton kho\n2. Cap nhat vi tri sach\nSo Bat Ky DeThoat");
        a = Integer.parseInt(sc.nextLine());
        switch (a) {
            case 1:
                System.out.print("Nhap so luong toi thieu can kiem tra: ");
                int soLuongToiThieu = Integer.parseInt(sc.nextLine());
                boolean tonKho = s.kiemTraTonKho(soLuongToiThieu);
                if (tonKho) {
                    System.out.println("Sach con du ton kho.");
                } else {
                    System.out.println("Sach khong du ton kho.");
                }
                break;
            case 2:
                System.out.print("Nhap vi tri moi de cap nhat: ");
                String viTriMoi = sc.nextLine();
                s.capNhatViTri(viTriMoi);
                break;
            default:
                a = 0;
                break;
        }
    } while (a != 0);
}

    @Override
    public void HienThiSach() {
        sapXepSach();
        if (QuanLySach.isEmpty()) {
            System.out.println("Danh sach sach rong!");
            return;
        }
        for (Sach s : QuanLySach) {
            System.out.println("--------------------");
            System.out.println(s);
        }
    }

    @Override
    public int tongSoLuong() {
        int tong = 0;
        for (Sach s : QuanLySach) tong += s.getSoLuong();
        return tong;
    }
}

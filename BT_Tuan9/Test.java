import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLySachImpl ql = new QuanLySachImpl();
        QuanLyMuonTra qlMuonTra = new QuanLyMuonTra();
        int n;

        do {
            System.out.println("\n===== QUAN LY SACH =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Xoa sach");
            System.out.println("4. Sua sach");
            System.out.println("5. Tim kiem sach");
            System.out.println("6. Kiem ke sach");
            System.out.println("7. Muon sach");
            System.out.println("8. Tra sach");
            System.out.println("9. Kiem tra sach qua han tra");
            System.out.println("10. Hien thi danh sach muon sach");
            System.out.println("0. Thoat");
            System.out.print("Lua chon cua ban: ");
            n = Integer.parseInt(sc.nextLine());
            switch (n) {
                case 1:
                    ql.ThemSach();
                    break;
                case 2:
                    ql.HienThiSach();
                    System.out.println("\nTONG SO LUONG SACH HIEN CO: " + ql.tongSoLuong());
                    break;
                case 3:
                    System.out.print("Nhap ma sach can xoa: ");
                    String maSachXoa = sc.nextLine();
                    ql.XoaSach(maSachXoa);
                    break;
                case 4:
                    System.out.print("Nhap ma sach can sua: ");
                    String maSachSua = sc.nextLine();
                    ql.SuaSach(maSachSua);
                    break;
                case 5:
                    System.out.print("Nhap ma sach can tim: ");
                    String maSachTim = sc.nextLine();
                    ql.TimKiemSach(maSachTim);
                    break;
                case 6:
                    ql.KiemKe();
                    break;
                case 7:
                    qlMuonTra.muonSach(ql);
                    break;
                case 8:
                    qlMuonTra.traSach(ql);
                    break;
                case 9:
                    qlMuonTra.kiemTraQuaHan();
                    break;
                case 10:
                    qlMuonTra.hienThiMuon();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (n != 0);
        sc.close();
    }
}
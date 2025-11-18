import java.time.LocalDate;
import java.util.Scanner;

public class MuonSach {
    private Sach sach;        
    private String maMuon;
    private String tenNguoiMuon;
    private int soLuongMuon;
    private LocalDate ngayMuon;
    private int soNgayMuon;
    private LocalDate ngayTra;
    private Scanner sc = new Scanner(System.in);

    public MuonSach() {
    }

    public MuonSach(String maMuon, String tenNguoiMuon, int soLuongMuon, int soNgayMuon) {
        this.maMuon = maMuon;
        this.tenNguoiMuon = tenNguoiMuon;
        this.soLuongMuon = soLuongMuon;
        this.soNgayMuon = soNgayMuon;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public String getMaMuon() {
        return maMuon;
    }

    public void setMaMuon(String maMuon) {
        this.maMuon = maMuon;
    }

    public String getTenNguoiMuon() {
        return tenNguoiMuon;
    }

    public void setTenNguoiMuon(String tenNguoiMuon) {
        this.tenNguoiMuon = tenNguoiMuon;
    }

    public int getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setSoLuongMuon(int soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }

    public LocalDate getNgayMuon() {
        return ngayMuon;
    }

    public void setsoNgayMuon(int soNgayMuon) {
        this.soNgayMuon = soNgayMuon;
    }

    public int getsoNgayMuon() {
        return soNgayMuon;
    }

    public LocalDate getNgayTra() {
        return ngayTra;
    }

    public void Nhap() {
        System.out.print("Nhap ten nguoi muon: ");
        tenNguoiMuon = sc.nextLine();
        while(true) {
            System.out.print("Nhap so luong muon: ");
            soLuongMuon = Integer.parseInt(sc.nextLine());
            if(soLuongMuon > 0)
                break;
            else
                System.out.println("So luong muon khong hop le");
        }
        while(true) {
            System.out.print("Nhap so ngay muon: ");
            soNgayMuon = Integer.parseInt(sc.nextLine());
            if(soNgayMuon > 0)
                break;
            else
                System.out.println("So ngay muon khong hop le");
        }
        this.ngayMuon = LocalDate.now();
        this.ngayTra = ngayMuon.plusDays(soNgayMuon);
    }

    @Override
    public String toString() {
        return " Ten Nguoi Muon: " + tenNguoiMuon +
               " Ma Sach Muon: " + maMuon +
               " So Luong Muon: " + soLuongMuon +
               " Ngay Muon: " + ngayMuon +
               " Ngay Tra: " + ngayTra;
    }
}

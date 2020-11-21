package cybersoft.td45.quanlynhansu.main;

import java.util.Scanner;

import cybersoft.td45.quanlynhansu.object.CongTy;
import cybersoft.td45.quanlynhansu.object.GiamDoc;
import cybersoft.td45.quanlynhansu.object.NhanSu;
import cybersoft.td45.quanlynhansu.object.NhanVien;
import cybersoft.td45.quanlynhansu.object.TruongPhong;

public class Main {
	public static void main(String[] args) {
		/* demo quản lý nhân sự */
//		CongTy congTy = new CongTy();
//		
//		NhanSu nhanVien 	= new NhanVien();
//		
//		((NhanVien) nhanVien).getTruongPhong();
//		
//		boolean isNhanVien 		= nhanVien instanceof NhanVien;
//		boolean isTruongPhong 	= nhanVien instanceof TruongPhong;
//		boolean isGiamDoc		= nhanVien instanceof GiamDoc;
//		boolean isNhanSu		= nhanVien instanceof NhanSu;
//		
//		System.out.println("nhanVien is instanceof NhanVien: " + isNhanVien);
//		System.out.println("nhanVien is instanceof TruongPhong: " + isTruongPhong);
//		System.out.println("nhanVien is instanceof GiamDoc: " + isGiamDoc);
//		System.out.println("nhanVien is instanceof NhanSu: " + isNhanSu);
//		
//		
//		
//		System.out.println("The program has been ended.");
		
		/* Viết chương trình hiển thị menu
		 * và thực hiện các chức năng được chọn
		 * 
		 * Menu hiển thị như sau: 
		 * 	1. Nhập thông tin công ty
		 *	2. Phân bổ Nhân viên vào Trưởng phòng
		 * 	3. Thêm, xóa thông tin một nhân sự (có thể là Nhân viên, trưởng phòng hoặc giám đốc). Lưu ý khi xóa trưởng phòng, phải ngắt liên kết với các nhân viên đang tham chiếu tới.
		 * 	4. Xuất ra thông tin toàn bộ người trong công ty
		 * 	5. Tính và xuất tổng lương cho toàn công ty
		 *	6. Tìm Nhân viên thường có lương cao nhất
		 * 	7. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất 
		 * 8. Sắp xếp nhân viên toàn công ty theo thứ tự abc
		 * 9. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần 
		 * 10. Tìm Giám Đốc có số lượng cổ phần nhiều nhất
		 * 11. Tính và Xuất tổng THU NHẬP của từng Giám Đốc
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		CongTy congTy = new CongTy();
		taoDummyData(congTy);
		
		congTy.xuatThongTinNhanSu();
		
		int luaChon;
		boolean tiepTucChay = true;
		do {
			luaChon = inMenu(scan);
			switch (luaChon) {
			case 1:
				congTy.nhapThongTin(scan);
				break;
			case 2: // phan bo nhan vien
				System.out.println("So luong nhan vien da duoc phan bo: " + congTy.phanBoNhanVien(scan));
				break;
			case 3: // thêm nhân sự
				NhanSu ns = null;
				System.out.println("Bạn muốn thêm:");
				System.out.println("1. Nhân viên");
				System.out.println("2. Trưởng phòng");
				System.out.println("3. Giám đốc");
				System.out.print("Lựa chọn: ");
				// cho người dùng chọn loại nhân sự muốn thêm
				switch (Integer.parseInt(scan.nextLine())) {
				case 1:
					ns = new NhanVien();
					break;
				case 2:
					ns = new TruongPhong();
					break;
				case 3:
					ns = new GiamDoc();
					break;
				}
				
				// nhập thông tin của nhân sự
				ns.nhapThongTin(scan);
				
				// thêm nhân sự vào danh sách nhân sự của công ty
				if(congTy.themNhanVien(ns)) {
					System.out.println("Thêm nhân sự thành công!");
				} else {
					System.out.println("Thêm nhân sự thất bại.");
				}
				
				break;
			case 4: // xóa nhân sự
				System.out.print("Nhập mã số nhân sự: ");
				if(congTy.xoaNhanVien(scan.nextLine()))
					System.out.println("Xóa nhân sự thành công!");
				else
					System.out.println("Xóa nhân sự thất bại.");
				break;
			case 5: // in danh sách toàn bộ người trong công ty
				congTy.xuatThongTinNhanSu();
				break;
			case 6: // tinh tong luong toan cong ty
				System.out.println("Tong luong cong ty: " + congTy.tinhTongLuong());
				break;
			case 7: // tim nhan su co luong cao nhat
				NhanSu max = congTy.timNhanSuLuongCaoNhat();
				
				if(max == null) {
					System.out.println("Cong ty khong co bat ky nhan su nao het!");
					break;
				}
				
				System.out.println("Nhan Su co luong cao nhat:");
				max.inThongTin();
				break;
			case 8: // sắp xếp nhân viên theo thứ tự abc
				
				break;
			case 13: // tim nhan vien co luong cao nhat
				NhanSu maxNhanVien = congTy.timNhanVienLuongCaoNhat();
				if(maxNhanVien == null) {
					System.out.println("Cong ty khong co bat ky nhan su nao het!");
					break;
				}
				
				System.out.println("Nhan vien co luong cao nhat:");
				maxNhanVien.inThongTin();
				break;
			case 0:
				System.out.println("Đang thoát chương trình...");
				tiepTucChay = false;
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ.");
				break;
			}
			
			// thêm dòng này để ngưng màn hình lại chờ người dùng ấn enter
			scan.nextLine();
		} while (tiepTucChay);
		
		System.out.println("Chương trình đã kết thúc.");
	}

	private static void taoDummyData(CongTy congTy) {
		congTy.themNhanVien(new NhanVien("MS01", "PHUC", "0909010203", 18, 100));
		congTy.themNhanVien(new NhanVien("MS02", "HUY", "0909010203", 23, 100));
		congTy.themNhanVien(new NhanVien("MS03", "THINH", "0909010203", 25, 100));
		congTy.themNhanVien(new NhanVien("MS04", "TUAN", "0909010203", 22, 100));
		congTy.themNhanVien(new NhanVien("MS05", "TUAN", "0909010203", 22, 100));
		congTy.themNhanVien(new NhanVien("MS06", "TUAN", "0909010203", 22, 100));
		congTy.themNhanVien(new NhanVien("MS07", "TUAN", "0909010203", 22, 100));
		congTy.themNhanVien(new NhanVien("MS08", "TUAN", "0909010203", 22, 100));
		
		congTy.themNhanVien(new TruongPhong("MS10", "HAI", "0909010203", 20, 200));
		congTy.themNhanVien(new TruongPhong("MS11", "NGUYEN", "0909010203", 20, 200));
		congTy.themNhanVien(new TruongPhong("MS12", "HUY", "0909010203", 20, 200));
		
		// builder
		congTy.themNhanVien(new GiamDoc("MS13", "HUNG", "0909010203", 20, 300, 40));
		// thêm 3 trưởng phòng
		// thêm 2 giám đốc
	}

	private static int inMenu(Scanner scan) {
		System.out.println("Menu: ");
		System.out.println("1. 	Nhập thông tin công ty");
		System.out.println("2. 	Phân bổ Nhân viên vào Trưởng phòng");
		System.out.println("3. 	Thêm nhân sự");
		System.out.println("4. 	Xóa nhân sự");
		System.out.println("5. 	Xuất ra thông tin toàn bộ người trong công ty");
		System.out.println("6. 	Tính và xuất tổng lương cho toàn công ty");
		System.out.println("7. 	Tìm nhân sự có lương cao nhất");
		System.out.println("8. 	Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất");
		System.out.println("9. 	Sắp xếp nhân viên toàn công ty theo thứ tự abc");
		System.out.println("10.	Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần");
		System.out.println("11.	Tìm Giám Đốc có số lượng cổ phần nhiều nhất");
		System.out.println("12.	Tính và Xuất tổng THU NHẬP của từng Giám Đốc");
		System.out.println("13.	Tìm nhân viên có lương cao nhất");
		System.out.println("0.	Thoát");
		System.out.print("Lựa chọn: ");
		
		return Integer.parseInt(scan.nextLine());
	}
		
}
	
	
	
	
	
	

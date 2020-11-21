package cybersoft.td45.quanlynhansu.object;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CongTy {
	/* properties */
	private String			ten;
	private String			maSoThue;
	private double			doanhThuThang;
	private List<NhanSu>	dsNhanSu;
	
	// Iterator - next hasNext getValue
	
	
	/* setters/getters */
	
	/* constructors */
	public CongTy() {
		ten 			= "Cybersoft Education";
		maSoThue		= "293879239";
		doanhThuThang	= 100000000;
		dsNhanSu		= new ArrayList<NhanSu>();
	}
	
	/* methods */
	public void nhapThongTin(Scanner sc) {
		System.out.println("NHẬP THÔNG TIN CÔNG TY");
		System.out.print("Tên công ty: ");
		this.ten 		=  sc.nextLine();
		System.out.print("Mã số thuế: ");
		this.maSoThue 	=  sc.nextLine();
		System.out.print("Doanh thu: ");
		this.doanhThuThang 	=  Double.parseDouble(sc.nextLine());
	}
	
	public void inThongTin() {
		/* in thông tin công ty */
		System.out.println("\t\t\t=====----THÔNG TIN CÔNG TY----=====");
		System.out.println("\t\t\tTên: " + this.ten);
		System.out.println("\t\t\tMST: " + this.maSoThue);
		System.out.println("\t\t\tDoanh thu: " + String.format("%10.0f", this.doanhThuThang));
		System.out.println("\t\t\t=====----*****************----=====");
	}

	public boolean themNhanVien(NhanSu ns) {
		/* các bước thực hiện:
		 * kiểm tra tính hợp lệ của dữ liệu
		 * kiểm tra trùng lặp
		 * thêm nhân sự vào danh sách
		 */
		/*
		 * 1. kiểm tra null
		 * thêm code vô
		 * 2. kiểm tra mã số, tên rỗng
		 * thêm code vô
		 * 3. kiểm tra trùng mã số
		 * thêm code vô
		 * 4. thêm nhân sự
		 * thêm code vô
		 */
		// 1. 
		if(ns == null)
			return false;
		
		// 2. dùng trick một tí -> best practices 
		if("".equals(ns.getMaSo()) || "".equals(ns.getHoTen()))
			return false;
		
		// 3.
		if(kiemTraTrungMaSo(ns.getMaSo()))
			return false;
		
		// 4. 
		return dsNhanSu.add(ns);
	}

	/* trả về true nếu mã số đã tồn tại, false nếu chưa có */
	private boolean kiemTraTrungMaSo(String maSo) {
		boolean trungMaSo = false;
		for(NhanSu ns : dsNhanSu) {
			if(ns.getMaSo().equalsIgnoreCase(maSo)) {
				trungMaSo = true;
				break;
			}
		}
		return trungMaSo;
		
//		for(NhanSu ns : dsNhanSu)
//			if(ns.getMaSo().equalsIgnoreCase(maSo))
//				return true;
//		return false;
	}

	public void xuatThongTinNhanSu() {
		// TODO: xuất thông tin toàn bộ nhân sự
		/* 1. duyệt danh sách nhân sự
		 * 2. in thông tin mỗi nhân sự
		 */
		int num = 72;
		String ttCongTy = "THÔNG TIN CÔNG TY";
		String ttNhanSu = "DANH SÁCH NHÂN SỰ";
		
		System.out.println();
		System.out.println(String.format("%" + (num*2 - ttCongTy.length())/2 + "s", "") + ttCongTy + String.format("%" + (num*2 - ttCongTy.length())/2 + "s", ""));
		System.out.println("Tên công ty: " + ten);
		System.out.println("Mã số thuế: " + maSoThue);
		System.out.println("Doanh thu: " + String.format("%20.2f", doanhThuThang));
		
		
		System.out.println();
		System.out.println(String.format("%" + (num*2 - ttNhanSu.length())/2 + "s", "") + ttNhanSu + String.format("%" + (num*2 - ttNhanSu.length())/2 + "s", ""));
		drawLine(num);
		System.out.println();
		System.out.println(
				String.format(" %10s  ", "Mã số")
				+ String.format("%16s  ", "Họ tên")
				+ String.format("%16s  ", "Số điện thoại")
				+ String.format("%12s  ", "Ngày làm")
				+ String.format("%16s  ", "Lương cơ bản")
				+ String.format("%17s  ", "Lương")
				+ String.format("%16s", "Chức vụ")
				+ String.format("%25s  |", "Số nhân viên/Cổ phần")
			);
		drawLine(num);
		System.out.println();
		for (NhanSu nhanSu : dsNhanSu) {
			nhanSu.inThongTin();
		}
		drawLine(num);
		System.out.println();
		System.out.println(
				String.format(" %10s  ", "")
				+ String.format("%16s  ", "")
				+ String.format("%16s  ", "")
				+ String.format("%30s  ", "Tổng lương")
				+ String.format("%17.2f  ", tinhTongLuong())
				+ String.format("%16s", "")
				+ String.format("%25s  |", "")
			);
		drawLine(num);
		System.out.println();
	}
	
	public boolean xoaNhanVien(String maSo) {
		// TODO: xóa nhân sự bằng mã số
		/* 
		 * 1. duyệt danh sách nhân sự
		 * 2. nếu nhân sự có mã số = maSo
		 * 3. xóa nhân sự khỏi danh sách
		 */
		for(NhanSu ns : dsNhanSu) {
			if(ns.getMaSo().equalsIgnoreCase(maSo)) {
				dsNhanSu.remove(ns);
				return true;
			}
		}
		return false;
	}
	
	public float tinhTongLuong() {
		// 1. duyet tat ca nhan su
		// 2. tinh luong moi nhan su va cong vao tong luong
		// 3. tra ve tong luong
		float tongLuong = 0;
		
		for (NhanSu nhanSu : dsNhanSu) {
			tongLuong += nhanSu.tinhLuong();
		}
		
		return tongLuong;
	}
	
	public NhanSu timNhanSuLuongCaoNhat() {
		// neu so luong nhan su < 1, tra ve null
		if(dsNhanSu.size() < 1)
			return null;
		
		// 1. tao bien max = Nhan Su dau tien
		NhanSu max = dsNhanSu.get(0);
		
		// 2. duyet dsNhanSu
		//		neu luong lon hon luong cua max thi
		//		gan max = nhan su hien tai
		for (NhanSu nhanSu : dsNhanSu) {
			if(nhanSu.tinhLuong() > max.tinhLuong())
				max = nhanSu;
		}
		
		// 3. return max
		return max.clone();
	}
	
	public NhanSu timNhanVienLuongCaoNhat() {
		// neu so luong nhan su < 1, tra ve null
		if(dsNhanSu.size() < 1)
			return null;
		
		// 1. tao dsNhanVien chua tat ca cac nhan vien trong dsNhanSu
		List<NhanSu> dsNhanVien = new LinkedList<NhanSu>();
		for (NhanSu nhanSu : dsNhanSu) {
			if(nhanSu instanceof NhanVien)
				dsNhanVien.add(nhanSu);
		}
		
		if(dsNhanVien.size() < 1)
			return null;
		
		// 2. tao bien max = nhanSu dau tien trong dsNhanVien
		NhanSu max = dsNhanVien.get(0);
		
		// 3. duyet dsNhanVien
		//		neu luong lon hon luong cua max thi
		//		gan max = nhan su hien tai
		for (NhanSu nhanSu : dsNhanVien) {
			if(nhanSu.tinhLuong() > max.tinhLuong())
				max = nhanSu;
		}
		
		// 4. tra ve max.clone()
		return max.clone();
	}
	
	public int phanBoNhanVien(Scanner sc) {
		int soLuongNhanVienDaPhanBo = 0;
		// 1. lay ra danh sach nhan vien chua duoc phan bo
		List<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		for(NhanSu ns : dsNhanSu) {
			if(ns instanceof NhanVien && ((NhanVien) ns).getTruongPhong() == null)
				dsNhanVien.add((NhanVien)ns);
		}
		
		// 2. lay ra danh sach truong phong
		List<TruongPhong> dsTruongPhong = new ArrayList<TruongPhong>();
		for(NhanSu ns : dsNhanSu)
			if(ns instanceof TruongPhong)
				dsTruongPhong.add((TruongPhong) ns);
		
		// 3. duyet danh sach nhan vien chua phan bo
		
		/*
		 * 		3.1 in thong tin nhan vien
		 * 		3.2 in ra danh sach truong phong
		 * 		3.3 cho nguoi dung lua chon truong phong de phan bo
		 */
		for(NhanVien nv : dsNhanVien) {
			System.out.println("THONG TIN NHAN VIEN CAN DUOC PHAN BO:");
			nv.inThongTin();
			// system designer - system architect
			// DDD - Domain Driven Development
			
			inDanhSach(dsTruongPhong);
			
			int luaChon = Integer.parseInt(sc.nextLine());
			
			switch (luaChon) {
			case -1:
				return soLuongNhanVienDaPhanBo;
				
			case 0:
				System.out.println("Nhan vien se khong duoc phan bo.");
				break;
			default:
				if(luaChon > 0 && luaChon <= dsTruongPhong.size()) {
					TruongPhong tp = dsTruongPhong.get(luaChon - 1);
					nv.setTruongPhong(tp.getMaSo());
					tp.tangNhanVien();
					nv.inThongTin();
					soLuongNhanVienDaPhanBo++;
				}
				break;
			}
		}
		
		// 4. tra ve so luong nhan vien da duoc phan bo
		
		return soLuongNhanVienDaPhanBo;
	}
	
	
	private void inDanhSach(List<TruongPhong> dsTruongPhong) {
		System.out.println("Danh sach truong phong: ");
		System.out.println("-1.\tNgung viec phan bo");
		System.out.println("0.\tKhong phan bo.");
		for (int i = 0; i < dsTruongPhong.size(); i++) {
			System.out.print((i + 1) + ".\t");
			dsTruongPhong.get(i).inThongTin();
		}
		System.out.print("Lua chon: ");
	}

	// pet project - side project 
	// utilities
	private void drawLine(int num) {
		for(int i = 0; i < num; i++) {
			System.out.print("- ");
		}
	}
}

package cybersoft.td45.quanlynhansu.object;

import java.util.Scanner;

public abstract class NhanSu {
	/* properties */
	protected String	maSo;
	protected String	hoTen;
	protected String	soDienThoai;
	protected float		soNgayLamViec;
	protected float		luongMotNgay;
	
	/* setters/getters */
	public String getMaSo() {
		// TODO Auto-generated method stub
		return this.maSo;
	}
	
	public String getHoTen() {
		return this.hoTen;
	}
	
	public void setLuongMotNgay(float luongMotNgay) {
		if(luongMotNgay >= 0)
			this.luongMotNgay = luongMotNgay;
	}
	
	public void setMaSo(String maSo) {
		if(null != maSo)
			this.maSo = maSo;
	}
	
	public void setHoTen(String hoTen) {
		if(null != hoTen)
			this.hoTen = hoTen;
	}
	
	public void setSoDienThoai(String soDienThoai) {
		if(null != soDienThoai)
			this.soDienThoai = soDienThoai;
	}
	
	public void setSoNgayLamViec(float soNgayLamViec) {
		if(soNgayLamViec >= 0) {
			this.soNgayLamViec = soNgayLamViec;
		}
	}
	/* constructors */
	public NhanSu() {
		maSo 			= "";
		hoTen			= "";
		soDienThoai		= "";
		soNgayLamViec 	= 22;
		luongMotNgay	= 100;
	}
	
	/*
	 * tạo constructors có các tham số sau đây
	 * 	- mã số
	 * 	- họ tên
	 * 	- số điện thoại
	 * 	- số ngày làm
	 * 	- lương một ngày
	 */
	public NhanSu(String maSo, String hoTen, String soDienThoai, float soNgayLamViec, float luongMotNgay) {
		this.maSo = maSo;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.soNgayLamViec = soNgayLamViec;
		this.luongMotNgay = luongMotNgay;
	}
	
	/* methods */
	public void inThongTin() {
		System.out.println(
				String.format("%10s |", maSo)
				+ String.format("%16s |", hoTen)
				+ String.format("%16s |", soDienThoai)
				+ String.format("%12.2f |", soNgayLamViec)
				+ String.format("%16.2f |", luongMotNgay)
				+ String.format("%17.2f |", tinhLuong())
				+ String.format("%16s |", getChucVu())
				+ String.format("%25s |", getThongTinThem())
			);
	}
	
	public void nhapThongTin(Scanner sc) {
		System.out.println("=====-----NHẬP THÔNG TIN NHÂN SỰ-----=====");
		System.out.print("Mã số: ");
		this.maSo = sc.nextLine();
		System.out.print("Họ tên: ");
		this.hoTen = sc.nextLine();
		System.out.print("Số điện thoại: ");
		this.soDienThoai = sc.nextLine();
		System.out.print("Số ngày làm: ");
		this.soNgayLamViec = Float.parseFloat(sc.nextLine());
		System.out.print("Lương một ngày: ");
		this.luongMotNgay = Float.parseFloat(sc.nextLine());
	}
	
	// apply polymorphism - da hinh
	public float tinhLuong() {
		float luong = soNgayLamViec * luongMotNgay;
		if(soNgayLamViec >= 22)
			luong += 500;
		
		return luong; 
	}

	public void sayHello() {
		System.out.println("NhanSu said hello to you.");
	}
	
	public String getChucVu() {
		return "Nhan Su";
	}
	
	abstract public String getThongTinThem();
	
	abstract public NhanSu clone();
}

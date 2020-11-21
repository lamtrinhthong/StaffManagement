package cybersoft.td45.quanlynhansu.object;

public class NhanVien extends NhanSu {
	/* properties */
	// lưu mã số của trưởng phòng
	private String truongPhong;  
	
	/* setters/getters */
	public String getTruongPhong() {
		return this.truongPhong;
	}
	
	public void setTruongPhong(String maTruongPhong) {
		if(maTruongPhong != null) {
			this.truongPhong = maTruongPhong;
		}
		
		this.truongPhong = maTruongPhong == null ? this.truongPhong: maTruongPhong;
	}
	
	/* constructors */
	/*
	 * tạo constructors có các tham số sau đây
	 * 	- mã số
	 * 	- họ tên
	 * 	- số điện thoại
	 * 	- số ngày làm
	 * 	- lương một ngày
	 */
	public NhanVien() {
		super();
	}
	
	public NhanVien(String maSo, String hoTen, String soDienThoai, float soNgayLamViec, float luongMotNgay) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec, luongMotNgay);
	}

	/* methods */
	@Override
	public void sayHello() {
		// TODO: demo poly-morphism
		super.sayHello();
		System.out.println();
	}
	
	@Override
	public String getChucVu() {
		return "Nhan Vien";
	}
	
	@Override
	public String getThongTinThem() {
		return this.truongPhong;
	}

	@Override
	public NhanSu clone() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

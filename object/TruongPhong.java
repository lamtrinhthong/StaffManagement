package cybersoft.td45.quanlynhansu.object;

public class TruongPhong extends NhanSu {
	/* properties */
	private int soNhanVien;
	
	// C H A N G E
	// decoupling
	

	/* setters/getters */
	public int getSoNhanVien() {
		return this.soNhanVien;
	}
	
	/* constructors */
	public TruongPhong() {
		super();
	}
	
	public TruongPhong(String maSo, String hoTen, String soDienThoai, float soNgayLamViec, float luongMotNgay) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec, luongMotNgay);
	}
	
	/* methods */
	@Override
	public float tinhLuong() {
		float luong = super.tinhLuong();
		
		luong += soNhanVien * 100;
		
		return luong;
	}
	
	@Override
	public String getThongTinThem() {
		return String.valueOf(this.soNhanVien);
	}
	
	@Override
	public String getChucVu() {
		return "Truong Phong";
	}
	
	public void tangNhanVien() {
		this.soNhanVien++;
	}
	
	public void giamNhanVien() {
		this.soNhanVien--;
	}

	@Override
	public NhanSu clone() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
}

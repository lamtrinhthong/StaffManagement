package cybersoft.td45.quanlynhansu.object;

public class GiamDoc extends NhanSu {
	/* properties */
	private float coPhan;
	
	/* setters/getters */
	public void setCoPhan(float coPhan) {
		if(coPhan < 0 || coPhan > 100) {
			return;
		}
		
		this.coPhan = coPhan;
	}
	
	/* constructors */
	public GiamDoc() {
		super();
	}
	
	public GiamDoc(String maSo, String hoTen, String soDienThoai, float soNgayLamViec, float luongMotNgay) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec, luongMotNgay);
	}
	
	public GiamDoc(String maSo, String hoTen, String soDienThoai, float soNgayLamViec, float luongMotNgay, float coPhan) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec, luongMotNgay);
		this.coPhan = coPhan;
	}
	
	/* methods */
	@Override
	public String getThongTinThem() {
		return String.valueOf(this.coPhan);
	}
	
	@Override
	public String getChucVu() {
		return "Giam Doc";
	}

	@Override
	public NhanSu clone() {
		// TODO Auto-generated method stub
		return null;
	}
}

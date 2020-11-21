package cybersoft.td45.quanlynhansu.interfaces;

import java.util.Scanner;

public interface NhapXuat {
	default void sayHello() {
		System.out.println("Hello");
	}
	
	void nhapThongTin(Scanner sc);
	void xuatThongTin();
}

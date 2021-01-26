package vo;

public class PBookVO {
	private String mnm			= null;
	private String name 		= null;
	private String num 			= null;
	private String location 	= null;
	private String gpno 		= null;
	private String gpnm			= null;
	
	public String getMnm() {
		return mnm;
	}
	public void setMnm(String mnm) {
		this.mnm = mnm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGpno() {
		return gpno;
	}
	public void setGpno(String gpno) {
		this.gpno = gpno;
	}
	public String getGpnm() {
		return gpnm;
	}
	public void setGpnm(String gpnm) {
		this.gpnm = gpnm;
	}
	@Override
	public String toString() {
		
		return "[회원번호= " + mnm
				+ " || 이름= " + name
				+ " ||전화번호= " + num
				+ " || 주소= " + location
				+ " || 그룹번호= " + gpno
				+ " || 그룹명= " + gpnm + "]";				
	}
	
	
	
		
}

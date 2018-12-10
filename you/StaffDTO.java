package hospital;

public class StaffDTO {
	
	private String num;                   //번호(auto_increment)
 	private String name;                 //성명
	private String gender;              //성별
	private String s_date;               //입사날짜
	private String tel;  
	private String addr;   
	private String type;               //직원분류(타입): 의사,간호사
	private String univ;
	static private int money = 5480000;
	private String ssn;               //주민번호
	
	
	
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getS_date() {
		return s_date;
	}
	
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getUniv() {
		return univ;
	}
	
	public void setUniv(String univ) {
		this.univ = univ;
	}
	
	public static int getMoney() {
		return money;
	}
	
	public static void setMoney(int money) {
		StaffDTO.money = money;
	}
	
	public String getSsn() {
		return ssn;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	
	
	
	
	
	
	
	

}

package kdata.manager;

public class Student {
	private String snum;
	private String sname;
	private String sex;
	
	@Override
	public String toString() {
		return "Student [snum=" + snum + ", sname=" + sname + ", sex=" + sex + "]";
		
		
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Student(String snum, String sname, String sex) {
		super();
		this.snum = snum;
		this.sname = sname;
		this.sex = sex;
	}
}

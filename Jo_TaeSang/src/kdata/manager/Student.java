package kdata.manager;

//학생1명의 정보를 저장하는 기능(학번, 이름)
public class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int kor;
	private int math;
	private int eng;
	fffffffff
	
	
	
	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	
	public Student(){
		super();
	}
	
	
	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	
	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public int compareTo(Student o) {
		return this.getName().compareTo(o.getName());
	}
	
	public int getTotal(){
		return this.kor + this.math + this.eng;
	}
	
	public int getAverage(){
		return 0;
	}
	
	public String getGrade(){
		return null;
	}
	
	public Student search(String name){
		return null;
	}
	
	

}

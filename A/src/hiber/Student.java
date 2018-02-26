package hiber;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sscore="
				+ sscore + ", sclass=" + sclass + ", spw=" + spw + "]";
	}

	private String sid;
	private String sname;
	private String sscore;
	private String sclass;
	private String spw;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String sid, String sname, String sscore, String sclass,
			String spw) {
		this.sid = sid;
		this.sname = sname;
		this.sscore = sscore;
		this.sclass = sclass;
		this.spw = spw;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSscore() {
		return this.sscore;
	}

	public void setSscore(String sscore) {
		this.sscore = sscore;
	}

	public String getSclass() {
		return this.sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getSpw() {
		return this.spw;
	}

	public void setSpw(String spw) {
		this.spw = spw;
	}

}
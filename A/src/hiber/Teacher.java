package hiber;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", tpw=" + tpw
				+ "]";
	}

	private String tid;
	private String tname;
	private String tpw;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** full constructor */
	public Teacher(String tid, String tname, String tpw) {
		this.tid = tid;
		this.tname = tname;
		this.tpw = tpw;
	}

	// Property accessors

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTpw() {
		return this.tpw;
	}

	public void setTpw(String tpw) {
		this.tpw = tpw;
	}

}
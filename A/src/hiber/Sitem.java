package hiber;

/**
 * Sitem entity. @author MyEclipse Persistence Tools
 */

public class Sitem implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "Sitem [seTitle=" + seTitle + ", seA=" + seA + ", seB=" + seB
				+ ", seC=" + seC + ", seD=" + seD + ", seAnwer=" + seAnwer
				+ ", seaPares=" + seaPares + "]";
	}

	private String seTitle;
	private String seA;
	private String seB;
	private String seC;
	private String seD;
	private String seAnwer;
	private String seaPares;

	// Constructors

	/** default constructor */
	public Sitem() {
	}

	/** minimal constructor */
	public Sitem(String seTitle) {
		this.seTitle = seTitle;
	}

	/** full constructor */
	public Sitem(String seTitle, String seA, String seB, String seC,
			String seD, String seAnwer, String seaPares) {
		this.seTitle = seTitle;
		this.seA = seA;
		this.seB = seB;
		this.seC = seC;
		this.seD = seD;
		this.seAnwer = seAnwer;
		this.seaPares = seaPares;
	}

	// Property accessors

	public String getSeTitle() {
		return this.seTitle;
	}

	public void setSeTitle(String seTitle) {
		this.seTitle = seTitle;
	}

	public String getSeA() {
		return this.seA;
	}

	public void setSeA(String seA) {
		this.seA = seA;
	}

	public String getSeB() {
		return this.seB;
	}

	public void setSeB(String seB) {
		this.seB = seB;
	}

	public String getSeC() {
		return this.seC;
	}

	public void setSeC(String seC) {
		this.seC = seC;
	}

	public String getSeD() {
		return this.seD;
	}

	public void setSeD(String seD) {
		this.seD = seD;
	}

	public String getSeAnwer() {
		return this.seAnwer;
	}

	public void setSeAnwer(String seAnwer) {
		this.seAnwer = seAnwer;
	}

	public String getSeaPares() {
		return this.seaPares;
	}

	public void setSeaPares(String seaPares) {
		this.seaPares = seaPares;
	}

}
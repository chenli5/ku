package hiber;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */

public class Item implements java.io.Serializable {

	// Fields

	private Integer eid;
	private String etitle;
	private String ea;
	private String eb;
	private String ec;
	private String ed;
	private String anwer;
	private String apares;
	private Integer tid;

	// Constructors

	@Override
	public String toString() {
		return "Item [eid=" + eid + ", etitle=" + etitle + ", ea=" + ea
				+ ", eb=" + eb + ", ec=" + ec + ", ed=" + ed + ", anwer="
				+ anwer + ", apares=" + apares + ", tid=" + tid + "]";
	}

	/** default constructor */
	public Item() {
	}

	/** minimal constructor */
	public Item(Integer eid, Integer tid) {
		this.eid = eid;
		this.tid = tid;
	}

	/** full constructor */
	public Item(Integer eid, String etitle, String ea, String eb, String ec,
			String ed, String anwer, String apares, Integer tid) {
		this.eid = eid;
		this.etitle = etitle;
		this.ea = ea;
		this.eb = eb;
		this.ec = ec;
		this.ed = ed;
		this.anwer = anwer;
		this.apares = apares;
		this.tid = tid;
	}

	// Property accessors

	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEtitle() {
		return this.etitle;
	}

	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}

	public String getEa() {
		return this.ea;
	}

	public void setEa(String ea) {
		this.ea = ea;
	}

	public String getEb() {
		return this.eb;
	}

	public void setEb(String eb) {
		this.eb = eb;
	}

	public String getEc() {
		return this.ec;
	}

	public void setEc(String ec) {
		this.ec = ec;
	}

	public String getEd() {
		return this.ed;
	}

	public void setEd(String ed) {
		this.ed = ed;
	}

	public String getAnwer() {
		return this.anwer;
	}

	public void setAnwer(String anwer) {
		this.anwer = anwer;
	}

	public String getApares() {
		return this.apares;
	}

	public void setApares(String apares) {
		this.apares = apares;
	}

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

}
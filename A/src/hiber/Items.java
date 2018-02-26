package hiber;

/**
 * Items entity. @author MyEclipse Persistence Tools
 */

public class Items implements java.io.Serializable {

	// Fields

	private Integer id;
	private String itname;

	// Constructors

	/** default constructor */
	public Items() {
	}

	/** full constructor */
	public Items(Integer id, String itname) {
		this.id = id;
		this.itname = itname;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItname() {
		return this.itname;
	}

	public void setItname(String itname) {
		this.itname = itname;
	}

}
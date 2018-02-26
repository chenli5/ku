package hiber;

/**
 * Testscore entity. @author MyEclipse Persistence Tools
 */

public class Testscore implements java.io.Serializable {

	// Fields

	private Integer testScoreId;
	private String testScore;

	// Constructors

	/** default constructor */
	public Testscore() {
	}

	/** minimal constructor */
	public Testscore(Integer testScoreId) {
		this.testScoreId = testScoreId;
	}

	/** full constructor */
	public Testscore(Integer testScoreId, String testScore) {
		this.testScoreId = testScoreId;
		this.testScore = testScore;
	}

	// Property accessors

	public Integer getTestScoreId() {
		return this.testScoreId;
	}

	public void setTestScoreId(Integer testScoreId) {
		this.testScoreId = testScoreId;
	}

	public String getTestScore() {
		return this.testScore;
	}

	public void setTestScore(String testScore) {
		this.testScore = testScore;
	}

}
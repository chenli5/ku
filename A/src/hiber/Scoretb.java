package hiber;



/**
 * Scoretb entity. @author MyEclipse Persistence Tools
 */

public class Scoretb  implements java.io.Serializable {


    // Fields    

     private Integer scId;
     private String score;


    // Constructors

    /** default constructor */
    public Scoretb() {
    }

    
    /** full constructor */
    public Scoretb(String score) {
        this.score = score;
    }

   
    // Property accessors

    public Integer getScId() {
        return this.scId;
    }
    
    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public String getScore() {
        return this.score;
    }
    
    public void setScore(String score) {
        this.score = score;
    }
   








}
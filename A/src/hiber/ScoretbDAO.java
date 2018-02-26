package hiber;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Scoretb entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see hiber.Scoretb
  * @author MyEclipse Persistence Tools 
 */

public class ScoretbDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ScoretbDAO.class);
		//property constants
	public static final String SCORE = "score";



    
    public void save(Scoretb transientInstance) {
        log.debug("saving Scoretb instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Scoretb persistentInstance) {
        log.debug("deleting Scoretb instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Scoretb findById( java.lang.Integer id) {
        log.debug("getting Scoretb instance with id: " + id);
        try {
            Scoretb instance = (Scoretb) getSession()
                    .get("hiber.Scoretb", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Scoretb instance) {
        log.debug("finding Scoretb instance by example");
        try {
            List results = getSession()
                    .createCriteria("hiber.Scoretb")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Scoretb instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Scoretb as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByScore(Object score
	) {
		return findByProperty(SCORE, score
		);
	}
	

	public List findAll() {
		log.debug("finding all Scoretb instances");
		try {
			String queryString = "from Scoretb";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Scoretb merge(Scoretb detachedInstance) {
        log.debug("merging Scoretb instance");
        try {
            Scoretb result = (Scoretb) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Scoretb instance) {
        log.debug("attaching dirty Scoretb instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Scoretb instance) {
        log.debug("attaching clean Scoretb instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
package hiber;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Sitem
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see hiber.Sitem
 * @author MyEclipse Persistence Tools
 */

public class SitemDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SitemDAO.class);
	// property constants
	public static final String SE_A = "seA";
	public static final String SE_B = "seB";
	public static final String SE_C = "seC";
	public static final String SE_D = "seD";
	public static final String SE_ANWER = "seAnwer";
	public static final String SEA_PARES = "seaPares";

	public void save(Sitem transientInstance) {
		log.debug("saving Sitem instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sitem persistentInstance) {
		log.debug("deleting Sitem instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sitem findById(java.lang.String id) {
		log.debug("getting Sitem instance with id: " + id);
		try {
			Sitem instance = (Sitem) getSession().get("hiber.Sitem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Sitem instance) {
		log.debug("finding Sitem instance by example");
		try {
			List results = getSession().createCriteria("hiber.Sitem")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Sitem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Sitem as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySeA(Object seA) {
		return findByProperty(SE_A, seA);
	}

	public List findBySeB(Object seB) {
		return findByProperty(SE_B, seB);
	}

	public List findBySeC(Object seC) {
		return findByProperty(SE_C, seC);
	}

	public List findBySeD(Object seD) {
		return findByProperty(SE_D, seD);
	}

	public List findBySeAnwer(Object seAnwer) {
		return findByProperty(SE_ANWER, seAnwer);
	}

	public List findBySeaPares(Object seaPares) {
		return findByProperty(SEA_PARES, seaPares);
	}

	public List findAll() {
		log.debug("finding all Sitem instances");
		try {
			String queryString = "from Sitem";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sitem merge(Sitem detachedInstance) {
		log.debug("merging Sitem instance");
		try {
			Sitem result = (Sitem) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sitem instance) {
		log.debug("attaching dirty Sitem instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sitem instance) {
		log.debug("attaching clean Sitem instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
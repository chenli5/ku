package hiber;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Testscore entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hiber.Testscore
 * @author MyEclipse Persistence Tools
 */

public class TestscoreDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TestscoreDAO.class);
	// property constants
	public static final String TEST_SCORE = "testScore";

	public void save(Testscore transientInstance) {
		log.debug("saving Testscore instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Testscore persistentInstance) {
		log.debug("deleting Testscore instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Testscore findById(java.lang.Integer id) {
		log.debug("getting Testscore instance with id: " + id);
		try {
			Testscore instance = (Testscore) getSession().get(
					"hiber.Testscore", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Testscore instance) {
		log.debug("finding Testscore instance by example");
		try {
			List results = getSession().createCriteria("hiber.Testscore")
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
		log.debug("finding Testscore instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Testscore as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTestScore(Object testScore) {
		return findByProperty(TEST_SCORE, testScore);
	}

	public List findAll() {
		log.debug("finding all Testscore instances");
		try {
			String queryString = "from Testscore";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Testscore merge(Testscore detachedInstance) {
		log.debug("merging Testscore instance");
		try {
			Testscore result = (Testscore) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Testscore instance) {
		log.debug("attaching dirty Testscore instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Testscore instance) {
		log.debug("attaching clean Testscore instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
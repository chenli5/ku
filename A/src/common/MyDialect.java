package common;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQL5Dialect;

public class MyDialect extends MySQL5Dialect{
	public MyDialect() {
		super();
		registerHibernateType(Types.VARCHAR, Hibernate.STRING.getName());
		registerHibernateType(Types.VARCHAR, Hibernate.TEXT.getName());
		registerHibernateType(Types.INTEGER, Hibernate.INTEGER.getName());
	}
}

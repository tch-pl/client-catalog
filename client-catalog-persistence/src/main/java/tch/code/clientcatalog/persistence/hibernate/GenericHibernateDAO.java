package tch.code.clientcatalog.persistence.hibernate;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class GenericHibernateDAO<T> extends HibernateDaoSupport {
    
    private Class<T> persistentClass;

    public GenericHibernateDAO(Class<T> clazz) {
        if (!clazz.isAnnotationPresent(Entity.class)) {
            throw new IllegalArgumentException("Class " + clazz
                    + " must be persistent!");
        }

        this.persistentClass = clazz;
    }
    
    @SuppressWarnings("unchecked")
    public T getById(Long id) {        
        return (T) getSessionFactory().getCurrentSession().get(persistentClass, id);
    }

    public Long save(T entity) {
        return (Long.valueOf(getSessionFactory().getCurrentSession().save(entity).toString()));
    }

    public void delete(T entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    public void delete(final Long id) {
        getSessionFactory().getCurrentSession().createQuery(
                        "DELETE " + persistentClass.getName()
                        + " WHERE id = ?").setLong(0, id).executeUpdate();

       
    }

    public void deleteMany(final Collection<Long> ids) {
        getSessionFactory().getCurrentSession().createQuery(
                        "DELETE " + persistentClass.getName()
                        + " WHERE id in (:ids)").setParameterList("ids", ids).executeUpdate();

              
    }

    public void deleteAll() {
        getSessionFactory().getCurrentSession().createQuery(
                        "DELETE FROM " + persistentClass.getName()).executeUpdate();

               
    }

    public void update(T entity) {
        getSessionFactory().getCurrentSession().flush();
         getSessionFactory().getCurrentSession().merge(entity);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(persistentClass);
        return  criteria.list();
    }

    public Class<T> getPeristentClass() {
        return persistentClass;
    }
/*
    @SuppressWarnings("unchecked")
    public List<T> find(String queryString, Object... values) {
        return getHibernateTemplate().find(queryString, values);
    }

    @SuppressWarnings("unchecked")
    protected T getOneByField(String fieldName, Object value) throws Exception {
        DetachedCriteria criteria = createCriteria();

        criteria.add(Restrictions.eq(fieldName, value));

        List<T> findByCriteria = getHibernateTemplate().findByCriteria(criteria);

        return findByCriteria.isEmpty() ? null : findByCriteria.get(0);
    }

    @SuppressWarnings("unchecked")
    protected List<T> findByCriteria(DetachedCriteria criteria) {
        return getHibernateTemplate().findByCriteria(criteria);
    }

    protected Integer getCount(DetachedCriteria criteria) {
        criteria.setProjection(Projections.rowCount());

        List<?> findByCriteria = getHibernateTemplate().findByCriteria(criteria);

        return (Integer) findByCriteria.get(0);
    }

    protected DetachedCriteria createCriteria() {
        return DetachedCriteria.forClass(persistentClass);
    }

    protected Integer count(DetachedCriteria criteria) {
        return count(criteria, "id");
    }

    protected Integer count(final DetachedCriteria criteria, final String propertyName) {
        criteria.setProjection(Projections.count(propertyName));

        return (Integer) getHibernateTemplate().findByCriteria(criteria).get(0);
    }
  */            
}

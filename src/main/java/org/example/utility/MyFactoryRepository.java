package org.example.utility;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyFactoryRepository<T,ID> implements ICrud<T,ID>{

    private Session session;
    private Transaction transaction;

    private EntityManager entityManager;

    private CriteriaBuilder criteriaBuilder;

    T t;

    public MyFactoryRepository(T entity){
        entityManager= HibernateUtility.getSessionFactory().createEntityManager();
        criteriaBuilder=entityManager.getCriteriaBuilder();
        this.t=entity;
    }

    private void openSession(){
        session= HibernateUtility.getSessionFactory().openSession();
        transaction=session.beginTransaction();
    }
    private void closeSession(){
        transaction.commit();
        session.close();
    }

    @Override
    public T save(T entity) {
        openSession();
        session.save(entity);
        closeSession();
        return entity;
    }

    @Override
    public void update(T entity) {
        openSession();
        session.update(entity);
        closeSession();
    }
    @Override
    public Iterable<T> saveAll(Iterable<T> entities) {
        openSession();
        entities.forEach(t->
                session.save(t)
                );
        closeSession();
        return entities;
    }


    @Override
    public void delete(T entity) {
        openSession();
        session.delete(entity);
        closeSession();
    }

    @Override
    public void deleteById(ID id) {
        CriteriaQuery<T> criteria=(CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root=(Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"),id));
        T result=entityManager.createQuery(criteria).getSingleResult();
        openSession();
        session.delete(result);
        closeSession();
    }

    @Override
    public Optional<T> findById(ID id) {
        CriteriaQuery<T> criteria=(CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root=(Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"),id));
        T result=entityManager.createQuery(criteria).getSingleResult();
        return Optional.ofNullable(result);
    }

    @Override
    public boolean existById(ID id) {
        CriteriaQuery<T> criteria=(CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root=(Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"),id));
        T result=entityManager.createQuery(criteria).getSingleResult();
        return result!=null;
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> criteria=(CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root=(Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        return entityManager.createQuery(criteria).getResultList();
    }
    //bu sinifinb icindeki alan adlarini degisken adlarini kod ile okumamiz gerekiyor
    //null olmayanlar tespit edilip ekrana yazdirilmali
    @Override
    public List<T> findByEntity(T entity) {
        List<T> result=null;
        Class cl=entity.getClass();
        Field[] fl=cl.getDeclaredFields();//class in icinde declare edilmis tum alanlari al(id,ad,soyad,tel,cinsiyet)
        try {
            CriteriaQuery<T> criteria=(CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
            Root<T> root=(Root<T>) criteria.from(t.getClass());
            criteria.select(root);
            List<Predicate> predicateList=new ArrayList<>();
            for(int i=0;i<fl.length;i++){
                fl[i].setAccessible(true);//erismek istedigimiz alanlari aciyoruz.Bunu yapmazsak null gelir.
                if (fl[i].get(entity)!=null&&!fl[i].get(entity).equals("id")){
                   if(fl[i].getType().isAssignableFrom(String.class)){
                       predicateList.add(criteriaBuilder.like(root.get(fl[i].getName()),"%"+fl[i].get(entity)+"%"));
                   } else if (fl[i].getType().isAssignableFrom(Number.class)) {
                       predicateList.add(criteriaBuilder.equal(root.get(fl[i].getName()),fl[i].get(entity)));
                   }else
                       predicateList.add(criteriaBuilder.equal(root.get(fl[i].getName()),fl[i].get(entity)));
                }
            }
            criteria.where(predicateList.toArray(new Predicate[]{}));
        }catch (Exception exception){
            System.out.println("bir hata oldu..."+exception.toString());
        }
        return result;
    }

    /**
     * select * from tbl_ where column=value
     * @param columnName
     * @param value % ve _ gibi karakterler kullanicilar tarafindan islenir.
     * @return
     */
    @Override
    public List<T> findByColumnNameAndValue(String columnName, String value) {
        CriteriaQuery<T> criteria=(CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root=(Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        //criteria.where(criteriaBuilder.equal(root.get(columnName),value));//root ile select kismi aliniyor columnName ve value ile column sorgulaniyor
        criteria.where(criteriaBuilder.like(root.get(columnName),value));
        return entityManager.createQuery(criteria).getResultList();

    }
//    @Override
//    public void save(T entity) {
//        openSession();
//        session.save(entity);
//        closeSession();
//    }
//
//    @Override
//    public void update(T entity) {
//        openSession();
//        session.update(entity);
//        closeSession();
//    }
//
//    @Override
//    public void delete(Long id) {
//        openSession();
//       // session.delete(entity);
//        closeSession();
//    }
//
//    @Override
//    public List<T> findAll() {
//        return null;
//    }
//
//    @Override
//    public T findById(Long id) {
//        return null;
//    }
}

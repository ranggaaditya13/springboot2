package com.rangga.DAO;

import java.util.List;  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.query.Query;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;

import com.rangga.entity.PositionEntity;  
  

@Repository
public class PositionDAOImpl implements PositionDAO{
	
	@Autowired  
    private SessionFactory sessionFactory;  
      
    @Override  
    public boolean savePosition(PositionEntity position) {  
        boolean status=false;  
        try {  
            sessionFactory.getCurrentSession().save(position);  
            status=true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return status;  
    }  
  
    @Override  
    public List<PositionEntity> getPosition() {  
        Session currentSession = sessionFactory.getCurrentSession();  
        Query<PositionEntity> query=currentSession.createQuery("from position where is_deleted = 0", PositionEntity.class);  
        List<PositionEntity> list=query.getResultList();  
        return list;  
    }  
  
    @Override  
    public boolean deletePosition(PositionEntity position) {  
        boolean status=false;  
        try {  
            sessionFactory.getCurrentSession().delete(position);  
            status=true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return status;  
    }  
  
    @Override  
    public List<PositionEntity> getPositionById(PositionEntity position) {  
        Session currentSession = sessionFactory.getCurrentSession();  
        Query<PositionEntity> query=currentSession.createQuery("from position where id=:id", PositionEntity.class);  
        query.setParameter("id", position.getId());  
        List<PositionEntity> list=query.getResultList();  
        return list;  
    }  
  
    @Override  
    public boolean updatePosition(PositionEntity position) {  
        boolean status=false;  
        try {  
            sessionFactory.getCurrentSession().update(position);  
            status=true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return status;  
    }  
      


}

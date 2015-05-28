package ar.edu.um.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.model.Tracking;
import ar.edu.um.model.Tramite;

@Service("trackingDAO")
public class TrackingDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void persistTracking(Tracking tracking) {
		sessionFactory.getCurrentSession().persist(tracking);
	}
	
	public List<Tracking> list() {
		
        @SuppressWarnings("unchecked")
		List<Tracking> trackingList = (List<Tracking>) sessionFactory.getCurrentSession().createQuery("from Tracking").list();
        return trackingList;
    }
	
	//NO FUNCIONA COMPLETAMENTE...
	
	public List<Tracking> listByTramiteId(int id) {
		
		 Query query = sessionFactory.getCurrentSession().createQuery("from Tracking where tck_tra_id = :id ");
		 query.setParameter("id", id);
		 List<Tracking> trackingList = (List<Tracking>) query.list();
		 return trackingList;
		
		
    }

}

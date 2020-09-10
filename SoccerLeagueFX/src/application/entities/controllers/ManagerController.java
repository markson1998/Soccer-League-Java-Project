package application.entities.controllers;

import application.entities.Manager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.TypedQuery;

public class ManagerController {
private EntityManagerFactory emf;
    private EntityManager em;
    
    public ManagerController(){
        emf = Persistence.createEntityManagerFactory("SoccerLeagueFXPU");
        em = emf.createEntityManager();
    }
    
    public List<Manager> getManagerData(){
        TypedQuery<Manager> qry = em.createQuery("select s from Manager s", Manager.class);
        return qry.getResultList();
    }
    
    public boolean insertManagerData(Manager manager){
        try{
            em.getTransaction().begin();
            em.persist(manager);
            System.out.println(manager.toString());
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
        
    }
    
    public boolean updateManagerData(Manager manager, int manager_id){
        try{
            em.getTransaction().begin();
              em.find(Manager.class, manager_id);
            em.merge(manager);
            System.out.println(manager.toString());
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public boolean removeManagerData(int manager_id){
        try{
            em.getTransaction().begin();
            Manager m = em.find(Manager.class, manager_id);
            em.remove(m);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}

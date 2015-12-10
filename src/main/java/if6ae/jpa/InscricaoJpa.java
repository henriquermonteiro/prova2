/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if6ae.jpa;

import if6ae.entity.Inscricao;
import if6ae.entity.Inscricao_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author a1155997
 */
public class InscricaoJpa {
    
    @PersistenceUnit(unitName = "AvaliacaoPU")
    private EntityManagerFactory factory;
    
    public List<Inscricao> findbyNumero(Integer numero){
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
        Root<Inscricao> rt = cq.from(Inscricao.class);
        cq.where(cb.equal(rt.get(Inscricao_.numero), numero));
        
        TypedQuery<Inscricao> tq = entityManager.createQuery(cq);
        List<Inscricao> list = tq.getResultList();
        
        return list;
    }
    
    public List<Inscricao> findbyCpf(long cpf){
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
        Root<Inscricao> rt = cq.from(Inscricao.class);
        cq.where(cb.equal(rt.get(Inscricao_.cpf), cpf));
        
        TypedQuery<Inscricao> tq = entityManager.createQuery(cq);
        List<Inscricao> list = tq.getResultList();
        
        return list;
    }
    
    public List<Inscricao> getAll(){
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
        Root<Inscricao> rt = cq.from(Inscricao.class);
        
        TypedQuery<Inscricao> tq = entityManager.createQuery(cq);
        List<Inscricao> list = tq.getResultList();
        
        return list;
    }
}

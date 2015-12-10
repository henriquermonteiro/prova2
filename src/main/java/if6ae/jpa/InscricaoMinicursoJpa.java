/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if6ae.jpa;

import if6ae.entity.Inscricao;
import if6ae.entity.InscricaoMinicurso;
import if6ae.entity.InscricaoMinicursoPK_;
import if6ae.entity.InscricaoMinicurso_;
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
public class InscricaoMinicursoJpa {
    
    @PersistenceUnit(unitName = "AvaliacaoPU")
    private EntityManagerFactory factory;
    
    public List<InscricaoMinicurso> findInscricaoMinicursoByNumero(Integer numero){
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<InscricaoMinicurso> cq = cb.createQuery(InscricaoMinicurso.class);
        Root<InscricaoMinicurso> rt = cq.from(InscricaoMinicurso.class);
        cq.where(cb.equal(rt.get(InscricaoMinicurso_.inscricaoMinicursoPK).get(InscricaoMinicursoPK_.numeroInscricao), numero));
        
        TypedQuery<InscricaoMinicurso> tq = entityManager.createQuery(cq);
        List<InscricaoMinicurso> list = tq.getResultList();
        
        return list;
    }
}

package org.formacio.setmana2.repositori;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.formacio.setmana2.domini.Alumne;
import org.formacio.setmana2.domini.Curs;
import org.formacio.setmana2.domini.Matricula;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Modifica aquesta classe per tal que sigui un component Spring que realitza les 
 * operacions de persistencia tal com indiquen les firmes dels metodes
 */

@Repository
public class RepositoriEscola {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Curs carregaCurs(String nom) {
		Curs curs = em.find(Curs.class, nom);
		return curs;
	}
	
	
	public Matricula apunta (String alumne, String curs) throws EdatIncorrecteException {
		Curs curso = this.carregaCurs(curs);
		Alumne alumno = em.find(Alumne.class, alumne);
		Matricula matricula = new Matricula();
		if(curso!=null&alumno!=null) {
			if(alumno.getEdat()<curso.getEdatMinima()) {
				throw new EdatIncorrecteException();
			}
			matricula.setAlumne(alumno);
			matricula.setCurs(curso);
			em.persist(matricula);
		}
		return matricula;
	}
	
	
}

package org.formacio.setmana2.domini;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_matricules")
public class Matricula {

	//create table t_matricules (mat_id bigint generated by default as identity,
	//mat_alumne varchar(255), mat_curs varchar(255), primary key (mat_id))
	// alter table t_matricules add constraint matricula_alumne_fk foreign key (mat_alumne) references t_alumnes
	// alter table t_matricules add constraint matricula_curs_fk foreign key (mat_curs) references t_cursos
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mat_id")
	private Long id; 
	
	@OneToOne
	@JoinColumn(name="mat_alumne")
	private Alumne alumne;
	
	@OneToOne
	@JoinColumn(name="mat_curs")
	private Curs curs;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Alumne getAlumne() {
		return alumne;
	}
	public void setAlumne(Alumne alumne) {
		this.alumne = alumne;
	}
	public Curs getCurs() {
		return curs;
	}
	public void setCurs(Curs curs) {
		this.curs = curs;
	}
	
	
}

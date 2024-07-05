package br.com.projetospringboot3.jpaadvmaps.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course", schema = "hb-03-one-to-many")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "title", length = 128)
	private String title;

	@ManyToOne(
				cascade = {
							CascadeType.DETACH,
							CascadeType.MERGE,
							CascadeType.PERSIST,
							CascadeType.REFRESH
				}
	)
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	public Course() {

	}

	public Course(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course{" +
					"id=" + id +
					", title='" + title + '\'' +
					'}';
	}
}
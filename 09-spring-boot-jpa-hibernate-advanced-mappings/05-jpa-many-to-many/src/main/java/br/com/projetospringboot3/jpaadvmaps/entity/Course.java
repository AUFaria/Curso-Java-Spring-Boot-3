package br.com.projetospringboot3.jpaadvmaps.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course", schema = "hb-05-many-to-many")
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

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<Review> reviews;

	@ManyToMany(
				fetch = FetchType.LAZY,
				cascade = {
							CascadeType.DETACH,
							CascadeType.MERGE,
							CascadeType.PERSIST,
							CascadeType.REFRESH
				})
	@JoinTable(
				name = "course_student",
				joinColumns = @JoinColumn(name = "course_id"),
				inverseJoinColumns = @JoinColumn(name = "student_id")
	)
	private List<Student> students;

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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course{" +
					"id=" + id +
					", title='" + title + '\'' +
					'}';
	}

	public void addReview(Review review) {

		if (reviews == null) {
			reviews = new ArrayList<>();
		}

		reviews.add(review);
	}

	public void addStudent(Student student) {

		if (students == null) {
			students = new ArrayList<>();
		}

		students.add(student);
	}
}
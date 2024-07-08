package br.com.projetospringboot3.jpaadvmaps.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student", schema = "hb-05-many-to-many")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "first_name", length = 45)
	private String firstName;

	@Column(name = "last_name", length = 45)
	private String lastName;

	@Column(name = "email", length = 45)
	private String email;

	@ManyToMany(
				fetch = FetchType.LAZY,
				cascade = {
							CascadeType.DETACH,
							CascadeType.MERGE,
							CascadeType.PERSIST,
							CascadeType.REFRESH
				}
	)
	@JoinTable(
				name = "course_student",
				joinColumns = @JoinColumn(name = "student_id"),
				inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	private List<Course> courses;

	public Student() {

	}

	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student{" +
					"email='" + email + '\'' +
					", lastName='" + lastName + '\'' +
					", firstName='" + firstName + '\'' +
					", id=" + id +
					'}';
	}

	public void addCourse(Course course) {
		if (courses == null) {
			courses = new ArrayList<>();
		}

		courses.add(course);
//		course.getStudents().add(this);
	}
}
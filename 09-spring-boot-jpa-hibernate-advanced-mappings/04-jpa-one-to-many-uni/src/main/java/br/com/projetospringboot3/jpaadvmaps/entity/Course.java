package br.com.projetospringboot3.jpaadvmaps.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course", schema = "hb-04-one-to-many-uni")
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
}
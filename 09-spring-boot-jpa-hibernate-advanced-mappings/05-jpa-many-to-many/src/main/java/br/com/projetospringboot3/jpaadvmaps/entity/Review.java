package br.com.projetospringboot3.jpaadvmaps.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review", schema = "hb-05-many-to-many")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "comment", length = 256)
	private String comment;

	public Review() {

	}

	public Review(String comment) {
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review{" +
					"comment='" + comment + '\'' +
					", id=" + id +
					'}';
	}
}
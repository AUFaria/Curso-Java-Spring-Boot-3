package br.com.projetospringboot3.jpaadvmaps.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail", schema = "hb-05-many-to-many")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "youtube_channel", length = 128)
	private String youtubeChannel;

	@Column(name = "hobby", length = 45)
	private String hobby;

	@OneToOne(
				mappedBy = "instructorDetail",
				cascade = {
							CascadeType.DETACH,
							CascadeType.MERGE,
							CascadeType.PERSIST,
							CascadeType.REFRESH
				}
	)
	private Instructor instructor;

	public InstructorDetail() {

	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail{" +
					"id=" + id +
					", youtubeChannel='" + youtubeChannel + '\'' +
					", hobby='" + hobby + '\'' +
					'}';
	}
}
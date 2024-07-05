package br.com.projetospringboot3.jpaadvmaps.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail", schema = "hb-01-one-to-one-uni")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "youtube_channel", length = 128)
	private String youtubeChannel;

	@Column(name = "hobby", length = 45)
	private String hobby;

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

	@Override
	public String toString() {
		return "InstructorDetail{" +
					"id=" + id +
					", youtubeChannel='" + youtubeChannel + '\'' +
					", hobby='" + hobby + '\'' +
					'}';
	}
}
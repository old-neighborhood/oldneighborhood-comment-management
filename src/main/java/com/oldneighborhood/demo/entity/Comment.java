package com.oldneighborhood.demo.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String c_ID;
	@NonNull
	private String m_ID;
	@NonNull
	private String u_ID;
	@NonNull
	private String c_image;
	@NonNull
	private String c_content;
	@NonNull
	private int c_star;
	@Column(columnDefinition="timestamp not null default now()" , updatable=false)
	private Timestamp c_date;

}

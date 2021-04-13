package com.ericvuu.dojooverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1, max=255)
	private String question;
	
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    	name="tags_questions",
    	joinColumns = @JoinColumn(name="question_id"),
    	inverseJoinColumns = @JoinColumn(name="tag_id")	
    	)
    private List<Tag> tags;
    
    @OneToMany(mappedBy="answer", fetch=FetchType.LAZY)
    private List<Answer> answers;
    
    
    
    	@PrePersist
    	protected void onCreate(){
    		this.createdAt = new Date();
    	}
    	@PreUpdate
    	protected void onUpdate(){
    		this.updatedAt = new Date();
    	}
    
    
    public Question() {
    	
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getquestion() {
		return question;
	}
	public void setquestion(String question) {
		this.question = question;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", tags=" + tags + ", answers=" + answers + "]";
	}
    
	
}

package com.example.Projectt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class cart {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@ManyToOne
@JoinColumn(name="person_id")
private users signup;
@ManyToOne
@JoinColumn(name="event_id")
private Event event;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public users getSignup() {
	return signup;
}
public void setSignup(users signup) {
	this.signup = signup;
}
public Event getEvent() {
	return event;
}
public void setEvent(Event event) {
	this.event = event;
}

}

package com.avandal.determinimize.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Link {
	private State source;
	private State target;
	private Set<String> transition;
	
	private static final Logger logger = LoggerFactory.getLogger(Link.class);
	
	public Link(State source, State target) {
		if (source == null || target == null) {
			throw new IllegalArgumentException("The source or the target can't be null.");
		}
		
		this.source = source;
		this.target = target;
		this.transition = new HashSet<>();
	}
	
	Link copy() {
		Link copy = new Link(source, target);
		copy.transition.addAll(transition);
		return copy;
	}
	
	void addTransition(String transition) {
		this.transition.add(transition);
	}
	
	void addTransition(Collection<String> transition) {
		this.transition.addAll(transition);
	}
	
	void addTransition(String...transition) {
		this.transition.addAll(Arrays.asList(transition));
	}
	
	@Override
	public String toString() {
		return "Link: " + this.source.getName() + " --" + this.transition + "-> " + this.target.getName();
	}
	

	public State getSource() {
		return source;
	}

	public void setSource(State source) {
		this.source = source;
	}

	public State getTarget() {
		return target;
	}

	public void setTarget(State target) {
		this.target = target;
	}

	public Set<String> getTransition() {
		return new HashSet<>(transition);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Link)) {
			return false;
		}
		Link other = (Link) obj;
		return Objects.equals(source, other.source) && Objects.equals(target, other.target)
				&& Objects.equals(transition, other.transition);
	}
	
	
}
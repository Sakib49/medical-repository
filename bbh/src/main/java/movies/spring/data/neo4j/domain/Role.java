package movies.spring.data.neo4j.domain;

import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

/**
 * @author Mark Angrish
 */
@RelationshipEntity(type = "Treatedby")
public class Role {

    @Id
    @GeneratedValue
	private Long id;
	private List<String> roles = new ArrayList<>();

	@StartNode
	 private Treatment person;;

	@EndNode
	private Disease movie;
	
	
	
	

	public Role() {
	}

	public Role(Disease movie, Treatment actor) {
		this.movie = movie;
		this.person = actor;
	}

	public Long getId() {
	    return id;
	}

	public List<String> getRoles() {
	    return roles;
	}

	public Treatment getPerson() {
	    return person;
	}

	public Disease getMovie() {
	    return movie;
	}

    public void addRoleName(String name) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(name);
    }
}
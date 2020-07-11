package movies.spring.data.neo4j.domain;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Mark Angrish
 */
@NodeEntity
public class Disease {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	

	@JsonIgnoreProperties("movie")
	@Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
	private List<Role> roles;

	public Disease() {
	}

	public Disease(String title, int released, String tagline) {
		this.title = title;
		
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	

	public List<Role> getRoles() {
		return roles;
	}

	public void addRole(Role role) {
		if (this.roles == null) {
			this.roles = new ArrayList<>();
		}
		this.roles.add(role);
	}
}
package movies.spring.data.neo4j.domain;


import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Mark Angrish
 */
@NodeEntity
public class Treatment {

    @Id
    @GeneratedValue
	private Long id;
	private String name;
	

	@Relationship(type = "Treatedby")
	private List<Disease> movies = new ArrayList<>();

	public Treatment() {
	}

	public Treatment(String name, int born) {
		this.name = name;
		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	

	public List<Disease> getMovies() {
		return movies;
	}
}
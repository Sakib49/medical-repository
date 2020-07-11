package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Treatment;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pdtyreus
 * @author Mark Angrish
 */
public interface PersonRepository extends Neo4jRepository<Treatment, Long> {

    Treatment findByName(String name);

}
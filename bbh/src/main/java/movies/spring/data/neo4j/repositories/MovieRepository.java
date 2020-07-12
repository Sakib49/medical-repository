package movies.spring.data.neo4j.repositories;

import java.util.Collection;


import movies.spring.data.neo4j.domain.Disease;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 * @author Michael J. Simons
 */
@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends Neo4jRepository<Disease, Long> {

	Disease findByTitle(@Param("title") String title);

	Collection<Disease> findByTitleLike(@Param("title") String title);

    @Query("MATCH (m:Disease)<-[r:Treatedby]-(a:Treatment) RETURN m,r,a LIMIT {limit}")
	Collection<Disease> graph(@Param("limit") int limit);
}
/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.heg.ig.BachEtBuck.persistance;

import java.util.List;

import ch.heg.ig.BachEtBuck.business.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository class for <code>Ticket</code> domain objects All method names are compliant
 * with Spring Data naming conventions so this interface can easily be extended for Spring
 * Data. See:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 *
 * @author Victor Feller
 */
public interface TicketRepository extends Repository<Ticket, Integer> {

	/**
	 * Retrieve an {@link Ticket} from the data store by id.
	 * @param id the id to search for
	 * @return the {@link Ticket} if found
	 */
	@Query("SELECT ticket FROM Ticket ticket WHERE ticket.id =:id")
	@Transactional(readOnly = true)
	Ticket findById(@Param("id") Integer id);

	/**
	 * Returns all the tickets from data store
	 **/
	// @Query("SELECT ticket FROM Ticket ticket")
	// @Transactional(readOnly = true)
	// Page<Ticket> findAll(Pageable pageable);

}

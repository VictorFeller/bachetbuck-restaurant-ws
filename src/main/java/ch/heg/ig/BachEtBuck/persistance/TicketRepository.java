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

import ch.heg.ig.BachEtBuck.business.Ticket;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

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
	 * Retrieve an {@link Ticket} from the data store by date format dd.mm.yyyy.
	 * @param purchaseDate the id to search for
	 * @return the {@link Ticket} if found
	 */
	@Query("SELECT ticket FROM Ticket ticket WHERE ticket.purchaseDate =:purchaseDate")
	@Transactional(readOnly = true)
	List<Ticket> findByPurchaseDate(@Param("purchaseDate") String purchaseDate);

	/**
	 * Retrieve all <code>Ticket</code>s from the data store.
	 * @return a <code>Collection</code> of <code>Ticket</code>s
	 */
	@Transactional(readOnly = true)
	@Cacheable("tickets")
	List<Ticket> findAll() throws DataAccessException;

	/**
	 * Retrieve the average amount of all tickets <code>Ticket</code>s from the data store.
	 * @return a <code>Collection</code> of <code>Ticket</code>s
	 */
	@Query("SELECT AVG(totalAmount) AS average_total_amount FROM Ticket")
	@Transactional(readOnly = true)
	BigDecimal findAverageAmount();

	/**
	 * Retrieve the average amount of all <code>Ticket</code>s from the data store.
	 * @return a <code>Collection</code> of <code>Ticket</code>s
	 */
	@Query("SELECT itemsPurchased, COUNT(*) AS purchase_count FROM Ticket GROUP BY itemsPurchased ORDER BY purchase_count DESC LIMIT 1")
	@Transactional(readOnly = true)
	String findMostPurchasedItem();

	/**
	 * Retrieve the most used payment method of all <code>Ticket</code>s from the data store.
	 * @return a <code>Collection</code> of <code>Ticket</code>s
	 */
	@Query("SELECT paymentMethod, COUNT(*) as usage_count FROM Ticket GROUP BY paymentMethod ORDER BY usage_count DESC LIMIT 3")
	@Transactional(readOnly = true)
	List<String> findMostUsedPaymentMethod();

	/**
	 * Retrieve the sum of all <code>Ticket</code>s for a specific month from the data store.
	 * @return a <code>Collection</code> of <code>Ticket</code>s
	 */
	@Query("SELECT SUM(totalAmount) FROM Ticket WHERE SUBSTRING(purchaseDate, 4, 2) =:month")
	@Transactional(readOnly = true)
	BigDecimal findSumByMonth(@Param("month") String month);

	/**
	 * Retrieve the sum of all <code>Ticket</code>s for a specific year from the data store.
	 * @return a <code>Collection</code> of <code>Ticket</code>s
	 */
	@Query("SELECT SUM(totalAmount) FROM Ticket WHERE SUBSTRING(purchaseDate, 7, 4) =:year")
	@Transactional(readOnly = true)
	Integer findSumByYear(@Param("year") Integer year);


}

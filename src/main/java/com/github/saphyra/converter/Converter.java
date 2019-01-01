package com.github.saphyra.converter;

import java.util.List;
import java.util.Optional;

public interface Converter<E, D> {
    /**
     * Converts entity to domain.
     *
     * @param entity entity to convert
     * @return converted domain or null if entity is null.
     */
    D convertEntity(E entity);

    /**
     * Converts Optional of entity to Optional of domain.
     *
     * @param entity Optional of entity to convert.
     * @return converted Optional of domain, or empty Optional if Optional of entity is empty.
     */
    Optional<D> convertEntity(Optional<E> entity);

    /**
     * Converts entity to Optional of domain.
     *
     * @param entity entity to convert
     * @return converted Optional of domain, or empty Optional if entity is null.
     */
    Optional<D> convertEntityToOptional(E entity);

    /**
     * Converts list of entities
     *
     * @param entityList entities of domain
     * @return list of converted domains.
     * @throws IllegalArgumentException if entityList is null.
     */
    List<D> convertEntity(List<E> entityList);

    /**
     * Converts domain to entity.
     *
     * @param domain domain to convert
     * @return converted entity.
     */
    E convertDomain(D domain);

    /**
     * Converts Optional of domain to Optional of entity.
     *
     * @param domain Optional of domain to convert.
     * @return converted Optional of entity, or empty Optional if Optional of domain is empty.
     */
    Optional<E> convertDomain(Optional<D> domain);

    /**
     * Converts domain to Optional of entity.
     *
     * @param domain domain to convert.
     * @return converted Optional of entity or empty Optional if domain is null.
     */
    Optional<E> convertDomainToOptional(D domain);

    /**
     * Converts list of domains.
     *
     * @param domainList domains to convert.
     * @return converted list of entities.
     * @throws IllegalArgumentException if domainList is null.
     */
    List<E> convertDomain(List<D> domainList);
}

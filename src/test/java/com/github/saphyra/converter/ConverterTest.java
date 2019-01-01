package com.github.saphyra.converter;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.github.saphyra.converter.TestConverterImpl.TEST_DOMAIN;
import static com.github.saphyra.converter.TestConverterImpl.TEST_ENTITY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConverterTest {
    private ConverterBase<String, String> underTest = new TestConverterImpl();

    @Test
    public void testConvertEntityOptionalShouldReturnEmptyWhenEmpty(){
        assertFalse(underTest.convertEntity(Optional.empty()).isPresent());
    }

    @Test
    public void testConvertEntityOptionalShouldConvertWhenPresent(){
        //WHEN
        Optional<String> result = underTest.convertEntity(Optional.ofNullable(TEST_ENTITY));
        //THEN
        assertTrue(result.isPresent());
        assertEquals(TEST_DOMAIN, result.get());
    }

    @Test
    public void testConvertEntityToOptionalShouldReturnEmptyWhenNull(){
        assertFalse(underTest.convertEntityToOptional(null).isPresent());
    }

    @Test
    public void testConvertEntityToOptionalShouldContainDomain(){
        //WHEN
        Optional<String> result = underTest.convertEntityToOptional(TEST_ENTITY);
        //THEN
        assertTrue(result.isPresent());
        assertEquals(TEST_DOMAIN, result.get());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertEntityListShouldThrowExceptionWhenNull(){
        //GIVEN
        List<String> in = null;
        //WHEN
        underTest.convertEntity(in);
    }

    @Test
    public void testConvertEntityListShouldConvert(){
        //GIVEN
        List<String> in = Arrays.asList(TEST_ENTITY, TEST_ENTITY);
        //WHEN
        List<String> result = underTest.convertEntity(in);
        //THEN
        assertEquals(in.size(), result.size());
        assertEquals(TEST_DOMAIN, result.get(0));
        assertEquals(TEST_DOMAIN, result.get(1));
    }

    @Test
    public void testConvertDomainOptionalShouldReturnEmptyWhenEmpty(){
        assertFalse(underTest.convertDomain(Optional.empty()).isPresent());
    }

    @Test
    public void testConvertDomainOptionalShouldConvertWhenPresent(){
        //WHEN
        Optional<String> result = underTest.convertDomain(Optional.ofNullable(TEST_DOMAIN));
        //THEN
        assertTrue(result.isPresent());
        assertEquals(TEST_ENTITY, result.get());
    }

    @Test
    public void testConvertDomainToOptionalShouldReturnEmptyWhenNull(){
        assertFalse(underTest.convertDomainToOptional(null).isPresent());
    }

    @Test
    public void testConvertDomainToOptionalShouldContainDomain(){
        //WHEN
        Optional<String> result = underTest.convertDomainToOptional(TEST_DOMAIN);
        //THEN
        assertTrue(result.isPresent());
        assertEquals(TEST_ENTITY, result.get());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertDomainListShouldThrowExceptionWhenNull(){
        //GIVEN
        List<String> in = null;
        //WHEN
        underTest.convertDomain(in);
    }

    @Test
    public void testConvertDomainListShouldConvert(){
        //GIVEN
        List<String> in = Arrays.asList(TEST_DOMAIN, TEST_DOMAIN);
        //WHEN
        List<String> result = underTest.convertDomain(in);
        //THEN
        assertEquals(in.size(), result.size());
        assertEquals(TEST_ENTITY, result.get(0));
        assertEquals(TEST_ENTITY, result.get(1));
    }
}

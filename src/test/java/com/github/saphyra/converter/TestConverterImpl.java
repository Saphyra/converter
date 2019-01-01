package com.github.saphyra.converter;

public class TestConverterImpl extends ConverterBase<String, String> {
    static final String TEST_ENTITY = "entity";
    static final String TEST_DOMAIN = "domain";

    @Override
    public String convertEntity(String entity) {
        return TEST_DOMAIN;
    }

    @Override
    public String convertDomain(String domain) {
        return TEST_ENTITY;
    }
}

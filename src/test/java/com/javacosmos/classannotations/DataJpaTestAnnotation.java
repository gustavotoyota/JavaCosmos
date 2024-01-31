package com.javacosmos.classannotations;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/*
 * DataJpaTest is used for JPA tests. It provides the following features:
 * - Configures an in-memory database
 * - Scans for @Entity classes and configures Spring Data JPA repositories
 * - Turns on SQL logging
 */

@DataJpaTest
public class DataJpaTestAnnotation {
}

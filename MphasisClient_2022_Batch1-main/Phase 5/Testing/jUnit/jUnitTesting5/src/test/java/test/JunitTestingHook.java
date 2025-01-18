package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JunitTestingHook {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before all test method");
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After all test method");

	}
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before each test method");

	}
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After each test method");

	}
	@Test
	void test1() {
		//fail("Not yet implemented");
		System.out.println("First testing");
	}

	@Test
	void test2() {
		//fail("Not yet implemented");
		System.out.println("second testing");
	}
}

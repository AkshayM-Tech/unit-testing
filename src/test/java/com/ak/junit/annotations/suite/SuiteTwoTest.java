package com.ak.junit.annotations.suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ClassDTest.class})
public class SuiteTwoTest {
}

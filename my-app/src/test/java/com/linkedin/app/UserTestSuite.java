package com.linkedin.app;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
//@SelectClasses({ UserRegistrationTest.class, UserLoginTest.class })
//@SelectClasses(names = { "com.linkedin.app.UserRegistrationTest", "com.linkedin.app.UserLoginTest" })
@SelectPackages("com.linkedin.app")
class UserTestSuite {
}

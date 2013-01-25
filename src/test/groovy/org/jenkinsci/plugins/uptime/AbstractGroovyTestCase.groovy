/*
 * The MIT License
 *
 * Copyright (c) 2004-2009, Sun Microsystems, Inc., Alan Harder
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugins.uptime

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

class AbstractGroovyTestCase {

	protected static final String FORMAT = 'mm/dd/yy HH:mm'
	protected static final MS_PER_MINUTE = 1000 * 60
	
	@Rule public TestName testName = new TestName();

	private long startTime

	//------------------------------------------------------------------------------------
	// Setup and Tear-down
	//------------------------------------------------------------------------------------
	
	@Before
	public void beforeAbstractJUnitTestCase() {
		startTime = System.currentTimeMillis();
	}
 
	@After
	public void afterAbstractJUnitTestCase() {
		logEndOfTest();
	}

	//------------------------------------------------------------------------------------
	// Helper Methods
	//------------------------------------------------------------------------------------
	
	protected long minutes(int numMinutes) {
		return MS_PER_MINUTE * numMinutes
	}
	
	protected long hours(int numHours) {
		return MS_PER_MINUTE * 60 * numHours
	}
	

	protected void log(Object message) {
		println getName() + ": " + message
	}
 
	protected String getName() {
		return testName.getMethodName();
	}
 
	protected void logEndOfTest() {
		long elapsedTime = System.currentTimeMillis() - startTime;
		String className = getClass().name - (getClass().getPackage().getName() + '.')
		System.out.println("---------- [ END: " + className + "." + getName() + " ]  Time=" + elapsedTime + "ms ----------");
	}

}
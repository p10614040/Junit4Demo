/**
 * 
 * @Title JunitFlowTest.java
 * @Package com.uscinfo.unit
 * @Description TODO(用一句话描述该文件做什么)
 * @author yan.liang
 * @date 2015年7月27日 下午10:20:54
 * @copyright USTCINFO
 */
package com.uscinfo.unit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author YanLiang
 *
 */
public class JunitFlowTest {

	/**
	 * @author yan.liang
	 * @date 2015年7月27日 下午10:20:54
	 * @Description BeforeClass 执行一次，所有方法调用前执行
	 * 是静态代码，所以运行时就会加载到内存中，并且只有一份实例
	 * 一般用于读取配置文件
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("This is Before Class");
	}

	/**
	 * @author yan.liang
	 * @date 2015年7月27日 下午10:20:54
	 * @Description 与BeforeClass类似，一般用于清理
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("This is After Class");
	}

	/**
	 * @author yan.liang
	 * @date 2015年7月27日 下午10:20:54
	 * @Description TODO(这里用一句话描述这个方法的作用)
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("This is Before");
	}

	/**
	 * @author yan.liang
	 * @date 2015年7月27日 下午10:20:54
	 * @Description TODO(这里用一句话描述这个方法的作用)
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("This is After");
	}

	@Test
	public void test() {
		System.out.println("This is test");
	}

	@Test
	public void test2() {
		System.out.println("This is test2");
	}

}

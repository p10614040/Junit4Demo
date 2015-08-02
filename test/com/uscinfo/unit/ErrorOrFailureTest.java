/**
 * 
 * @Title ErrorOrFailureTest.java
 * @Package com.uscinfo.unit
 * @Description TODO(用一句话描述该文件做什么)
 * @author yan.liang
 * @date 2015年7月27日 下午10:10:26
 * @copyright USTCINFO
 */
package com.uscinfo.unit;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author YanLiang
 * 
 * 1、failure 代表junit 验证的错误
 * 2、error 是异常引起的错误
 * 3、测试用例是用来验证代码没有错
 */
public class ErrorOrFailureTest {

	/**
	 * Test method for {@link com.uscinfo.unit.Calculate#add(int, int)}.
	 */
	@Test
	public void testAdd() {
		assertEquals(6, new Calculate().add(2, 3));
	}
	
	/**
	 * Test method for {@link com.uscinfo.unit.Calculate#divide(int, int)}.
	 */
	@Ignore("错误")
	@Test
	public void testDivide() {
		assertEquals(3, new Calculate().divide(6, 0));
	}
	
	/**
	 * @author yan.liang
	 * @date 2015年7月27日 下午10:35:20
	 * @Description 测试异常
	 */
	@Test(expected=ArithmeticException.class)
	public void testErrorDivide() {
		assertEquals(3, new Calculate().divide(6, 0));
	}

	@Test(timeout=3500)
	public void testTimeOut() {
		while(true){
			System.out.println("");
		}
	}
}

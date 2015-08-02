/**
 * 
 * @Title CalculateTest.java
 * @Package com.uscinfo.unit
 * @Description TODO(用一句话描述该文件做什么)
 * @author yan.liang
 * @date 2015年7月27日 下午10:03:19
 * @copyright USTCINFO
 */
package com.uscinfo.unit;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author YanLiang
 * 
 * 1、测试方法必须使用Test注解修饰
 * 2、测试方法必须是 public void 修饰
 * 3、测试方法的放在 test 路径下
 * 4、测试类的包名与代码的包相同
 * 5、测试类的名称以 Test 结尾
 * 6、测试方法的名称以 test 开始
 * 7、测试方法可以单独测试
 */
public class CalculateTest {

	/**
	 * Test method for {@link com.uscinfo.unit.Calculate#add(int, int)}.
	 */
	@Test
	public void testAdd() {
		assertEquals(5, new Calculate().add(2, 3));
	}

	/**
	 * Test method for {@link com.uscinfo.unit.Calculate#subtract(int, int)}.
	 */
	@Test
	public void testSubtract() {
		assertEquals(5, new Calculate().subtract(6, 1));
	}

	/**
	 * Test method for {@link com.uscinfo.unit.Calculate#multiply(int, int)}.
	 */
	@Test
	public void testMultiply() {
		assertEquals(6, new Calculate().multiply(2, 3));
	}

	/**
	 * Test method for {@link com.uscinfo.unit.Calculate#divide(int, int)}.
	 */
	@Test
	public void testDivide() {
		assertEquals(3, new Calculate().divide(6, 2));
	}

}

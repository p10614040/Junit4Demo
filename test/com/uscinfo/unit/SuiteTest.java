/**
 * 
 * @Title SuiteTest.java
 * @Package com.uscinfo.unit
 * @Description TODO(用一句话描述该文件做什么)
 * @author yan.liang
 * @date 2015年7月28日 下午9:39:51
 * @copyright USTCINFO
 */
package com.uscinfo.unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author YanLiang
 * 测试套件：可以测试一系列的测试类
 * @RunWith
 * @Suite.SuiteClasses
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CalculateTest.class, ErrorOrFailureTest.class, JunitFlowTest.class})
public class SuiteTest {

}

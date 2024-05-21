/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2024 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.service.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sobetech.common.service.spring.date.DateUtil;
import com.sobetech.common.service.spring.io.FileUtil;
import com.sobetech.common.service.spring.math.NumberUtil;
import com.sobetech.common.service.spring.reflection.ReflectionUtil;

/**
 * Abstract class holding beans and methods to be used by any service
 *
 * @author John Murray
 *
 * @since Apr 28, 2024
 *
 */
public abstract class BaseService
{
	/**
	 * A logger accessible by all child services
	 */
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * A Spring Service to work with dates and times
	 */
	@Autowired
	protected DateUtil dateUtil;
	
	/**
	 * A Spring Service to work with files
	 */
	@Autowired
	protected FileUtil fileUtil;
	
	/**
	 * A Spring Service to work with numbers and math
	 */
	@Autowired
	protected NumberUtil numberUtil;
	
	/**
	 * A Spring Service to work with Strings
	 */
	@Autowired
	protected StringUtil stringUtil;
	
	/**
	 * A Spring Service to do functions with Reflection
	 */
	@Autowired
	protected ReflectionUtil reflectionUtil;
}

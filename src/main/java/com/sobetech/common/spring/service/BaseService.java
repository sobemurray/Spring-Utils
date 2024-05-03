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
package com.sobetech.common.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sobetech.common.spring.service.date.DateUtil;
import com.sobetech.common.spring.service.io.FileUtil;
import com.sobetech.common.spring.service.math.NumberUtil;

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
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected DateUtil dateUtil;
	
	@Autowired
	protected FileUtil fileUtil;
	
	@Autowired
	protected NumberUtil numberUtil;
	
	@Autowired
	protected StringUtil stringUtil;
}

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
package com.sobetech.common.controller.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class holding beans and methods to be used by any controller
 *
 * @author John Murray
 *
 * @since Apr 26, 2024
 *
 */
public abstract class BaseController
{
	/**
	 * A logger accessible by all child controllers
	 */
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
}

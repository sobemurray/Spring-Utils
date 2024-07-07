/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2024 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Team Focus / Peak6, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.model.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Flag an attribute to skip copying this attribute in the Reflection utilities if
 * the source is <code>null</code>
 *
 * @author John Murray
 *
 * @since Jun 9, 2024
 *
 */
@Documented
@Inherited
@Retention(RUNTIME)
@Target(FIELD)
public @interface SkipNullCopyAttribute
{

}

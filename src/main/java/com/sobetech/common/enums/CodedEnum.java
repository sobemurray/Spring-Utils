/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2023 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.enums;

/**
 * An interface used to indicate that an enum also has an alternative integer code value
 *
 * @author John.Murray
 *
 * @since Jul 31, 2023
 *
 */
public interface CodedEnum
{
	int getCode();
}

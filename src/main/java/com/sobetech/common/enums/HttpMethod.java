/**
 * Created by Sobetech Holdings LLC
 *
 * Copyright © 2022 Sobetech Holdings LLC, All Rights Reserved
 *
 * This software is supplied under the terms of a license agreement or
 * nondisclosure agreement with Sobetech Holdings LLC, or one of its affiliates,
 * and may not be used, disseminated, or distributed except in accordance with
 * the terms of that agreement.
 *
 */
package com.sobetech.common.enums;

/**
 * An enum containing valid Http Method types. This may be considered a
 * duplicate of many other implementations of this, but a new one is created to
 * ensure no library lock-in
 *
 * @author John.Murray
 *
 * @since Jul 25, 2022
 *
 */
public enum HttpMethod
{
	POST, PUT, PATCH, GET
}

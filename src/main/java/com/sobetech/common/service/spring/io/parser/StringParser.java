/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2019 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 * 
 */
package com.sobetech.common.service.spring.io.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Abstract class for a String parsers
 * 
 * @author John Murray
 *
 * @since 0.0.2
 *
 */
public abstract class StringParser
{
    protected static Pattern intPattern = Pattern.compile("[-]?\\d+");
    
    protected static Matcher intMatcher = intPattern.matcher("");
    
    protected int getIntFromString(String inputString)
    {
        intMatcher.reset(inputString);
        if(intMatcher.find())
        {
            return Integer.parseInt(intMatcher.group());
        }
        throw new IllegalArgumentException("An int could not be found in " + inputString);
    }
}

/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2006 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 * 
 */
package com.sobetech.common.service.spring.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collection;

import org.springframework.stereotype.Service;

/**
 * Static methods that perform statistical computations
 * 
 * @author John Murray
 *
 * @since 0.2.0
 *
 */
@Service
public class Statistics
{
	/**
     * Takes a collection of float values and computes the mean with a MathContext.DECIMAL64 level of precision
     * 
     * @param values The values to compute the mean from
     * @return The mean of the values or Float.NaN if the collection is <code>null</code> or empty
     */
    public static double getMean(Collection<Float> values)
    {
        if(values == null || values.isEmpty()) return Float.NaN;
        BigDecimal total = BigDecimal.ZERO;
        for(float value : values)
        {
            total = total.add(new BigDecimal(value));
        }
        return total.divide(new BigDecimal(values.size()), MathContext.DECIMAL64).floatValue();
    }
    
    /**
     * Takes a collection of float values and computes the standard deviation with a MathContext.DECIMAL64 level of precision
     * 
     * @param values The full population of values to compute the standard deviation from
     * @return The standard deviation of the values or Float.NaN if the collection is <code>null</code> or empty
     */
    @Deprecated
    //TODO This needs to be addressed because precision is not perfected
    public static double getPopulationStandardDeviation(Collection<Float> values)
    {
        if(values == null || values.isEmpty()) return Float.NaN;
        BigDecimal mean = new BigDecimal(getMean(values));
        BigDecimal sumOfSquaredVariances = BigDecimal.ZERO;
        for(float value : values)
        {
            BigDecimal trueValue = new BigDecimal(value);
            BigDecimal squaredVariance = trueValue.subtract(mean).pow(2);
            sumOfSquaredVariances = sumOfSquaredVariances.add(squaredVariance);
        }
        BigDecimal averageSquaredVariance = sumOfSquaredVariances.divide(new BigDecimal(values.size()), MathContext.DECIMAL64);
        return StrictMath.sqrt(averageSquaredVariance.floatValue());
    }
    
    /**
     * Takes a collection of float values and computes the standard deviation with a MathContext.DECIMAL64 level of precision
     * 
     * @param values The sample population of values to compute the standard deviation from
     * @return The standard deviation of the values or Float.NaN if the collection is <code>null</code> or empty
     */
    @Deprecated
    //TODO This needs to be addressed because precision is not perfected
    public static double getSampleStandardDeviation(Collection<Float> values)
    {
        if(values == null || values.isEmpty()) return Float.NaN;
        BigDecimal mean = new BigDecimal(getMean(values));
        BigDecimal sumOfSquaredVariances = BigDecimal.ZERO;
        for(float value : values)
        {
            BigDecimal trueValue = new BigDecimal(value);
            BigDecimal squaredVariance = trueValue.subtract(mean).pow(2);
            sumOfSquaredVariances = sumOfSquaredVariances.add(squaredVariance);
        }
        BigDecimal averageSquaredVariance = sumOfSquaredVariances.divide(new BigDecimal(values.size() - 1), MathContext.DECIMAL64);
        return StrictMath.sqrt(averageSquaredVariance.floatValue());
    }
}
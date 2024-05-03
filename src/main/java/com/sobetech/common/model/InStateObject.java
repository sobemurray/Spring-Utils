/**
 * 
 */
package com.sobetech.common.model;

import com.sobetech.common.enums.State;

/**
 * An interface for when an object is based on a particular state
 * 
 * @author John.Murray
 *
 */
public interface InStateObject 
{
	State getState();
}
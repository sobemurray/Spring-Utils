/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2004 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 * 
 */
package com.sobetech.common.model.io;

import java.io.InputStream;

/**
 * An input stream that uses a byte array and is to be purported to be faster than normal
 * implementations
 * 
 * @author John Murray
 * 
 * @since 0.2.0
 */
public class FastArrayInputStream extends InputStream
{
    protected byte[] byteBuffer = null;

    protected int count = 0;

    protected int position = 0;

    /**
     * Constructs the input stream with a defined byte array and a count of bytes to used
     */
    public FastArrayInputStream(byte[] byteBuffer, int count)
    {
        this.byteBuffer = byteBuffer;
        this.count = count;
    }

    /**
     * @see java.io.InputStream#available()
     */
    @Override
    public int available()
    {
        return this.count - this.position;
    }

    /**
     * @see java.io.InputStream#read()
     */
    @Override
    public int read()
    {
        return (this.position < this.count) ? (this.byteBuffer[this.position++] & 0xff) : -1;
    }

    /**
     * @see java.io.InputStream#read(byte[],  int, int)
     */
    @Override
    public int read(byte[] newBytes, int offset, int length)
    {
        if(this.position >= this.count) return -1;

        if((this.position + length) > this.count) length = (this.count - this.position);

        System.arraycopy(this.byteBuffer, this.position, newBytes, offset, length);
        this.position += length;
        return length;
    }

    /**
     * @see java.io.InputStream#skip(long)
     */
    @Override
    public long skip(long skipLength)
    {
        if((this.position + skipLength) > this.count) skipLength = this.count - this.position;

        if(skipLength < 0) return 0;

        this.position += skipLength;
        return skipLength;
    }
}
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
import java.io.OutputStream;

/**
 * An output stream that uses a byte array and is to be purported to be faster than normal
 * implementations
 * 
 * @author John Murray
 * 
 * @since 0.2.0
 */
public class FastByteArrayOutputStream extends OutputStream
{
	private byte[] byteBuffer = null;

	private int size = 0;

    /**
     * An empty constructor that creates a byte array buffer of initial size of 5120
     */
    public FastByteArrayOutputStream()
    {
        this(5 * 1024);
    }

    /**
     * A constuctor that creates a byte array buffer of specified size
     * @param initialSize
     */
    public FastByteArrayOutputStream(int initialSize)
    {
        this.size = 0;
        this.byteBuffer = new byte[initialSize];
    }

    /**
     * @see java.io.OutputStream#write(int)
     */
    @Override
    public void write(int b)
    {
        verifyBufferSize(this.size + 1);
        this.byteBuffer[this.size++] = (byte)b;
    }

    private void verifyBufferSize(int testSize)
    {
        if(testSize > this.byteBuffer.length)
        {
            byte[] oldBuffer = this.byteBuffer;
            this.byteBuffer = new byte[Math.max(testSize, 2 * this.byteBuffer.length)];
            System.arraycopy(oldBuffer, 0, this.byteBuffer, 0, oldBuffer.length);
            oldBuffer = null;
        }
    }

    /**
     * Gets the size of the output stream
     * 
     * @return The size of the stream
     */
    public int getSize()
    {
        return this.size;
    }

    /**
     * Gets the byte array buffer of the output stream
     * 
     * @return The current byte array buffer
     */
    public byte[] getByteArray()
    {
        return this.byteBuffer;
    }

    /**
     * @see java.io.OutputStream#write(byte[])
     */
    @Override
    public void write(byte bytesToWrite[])
    {
        write(bytesToWrite, 0, bytesToWrite.length);
    }

    /**
     * @see java.io.OutputStream#write(byte[], int, int)
     */
    @Override
    public void write(byte bytesToWrite[], int offset, int length)
    {
        verifyBufferSize(this.size + bytesToWrite.length);
        System.arraycopy(bytesToWrite, offset, this.byteBuffer, this.size, length);
        this.size += bytesToWrite.length;
    }

    /**
     * Resets the size of the output stream
     *
     */
    public void reset()
    {
        this.size = 0;
    }

    /**
     * Creates an input stream based in this output stream
     * 
     * @return A FastArrayInputStream of this output stream
     */
    public InputStream getInputStream()
    {
        return new FastArrayInputStream(this.byteBuffer, this.size);
    }
}
/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.test;

import org.junit.Assert;
import org.junit.Test;

public class SerializeTestHelperTest
{
    @Test
    public void serializeDeserializeSuccess()
    {
        String input = "Test";
        String output = SerializeTestHelper.serializeDeserialize(input);
        Assert.assertEquals(input, output);
        Assert.assertNotSame(input, output);
    }

    @Test
    public void serializeNotSerializable()
    {
        try
        {
            Object nonSerializable = new Object();
            SerializeTestHelper.serialize(nonSerializable);
        }
        catch (AssertionError ignored)
        {
            return;
        }

        Assert.fail();
    }

    @Test
    public void deserializeNonsense()
    {
        try
        {
            byte[] nonsenseByteArray = "Why is the man who invests all your money called a broker?".getBytes();
            SerializeTestHelper.deserialize(nonsenseByteArray);
        }
        catch (AssertionError ignored)
        {
            return;
        }

        Assert.fail();
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(SerializeTestHelper.class);
    }
}

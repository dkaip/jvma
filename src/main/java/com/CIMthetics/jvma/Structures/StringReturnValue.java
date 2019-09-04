package com.CIMthetics.jvma.Structures;

/**
 * In Java Strings are immutable.  Given that fact Java Strings may not be altered
 * when passed as JNI arguments even though they are object.  This class allows
 * a string to be returned when it is passed as an argument.
 * 
 * @author Douglas Kaip
 *
 */
public class StringReturnValue
{
    private String value;

    public String getValue()
    {
        return value;
    }

    void setValue(String value)
    {
        this.value = value;
    }
}

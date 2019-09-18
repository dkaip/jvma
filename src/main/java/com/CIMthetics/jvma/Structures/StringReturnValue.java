/*
 * Copyright 2019 Douglas Kaip
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

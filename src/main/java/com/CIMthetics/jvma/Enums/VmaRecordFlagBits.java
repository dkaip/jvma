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
package com.CIMthetics.jvma.Enums;

/**
 * <code>VmaRecordFlagBits.VMA_RECORD_FLUSH_AFTER_CALL_BIT</code> Enables flush 
 * after recording every function call.
 * <p>
 * Enable it if you expect your application to crash, which may leave recording 
 * file truncated.
 * <p>
 * It may degrade performance though.
 * 
 * @author Douglas Kaip
 *
 */
public enum VmaRecordFlagBits
{
    VMA_RECORD_FLUSH_AFTER_CALL_BIT(0x00000001),
    VMA_RECORD_FLAG_BITS_MAX_ENUM(0x7FFFFFFF);
    
    private int value;
    
    private VmaRecordFlagBits(int value) { this.value = value; }
    
    public int valueOf() { return value; }

}

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

import java.util.EnumSet;

import com.CIMthetics.jvma.Enums.VmaRecordFlagBits;

public class VmaRecordSettings
{
    // Flags for recording. Use #VmaRecordFlagBits enum.
    EnumSet<VmaRecordFlagBits> flags = EnumSet.noneOf(VmaRecordFlagBits.class);
    /** \brief Path to the file that should be written by the recording.

    Suggested extension: "csv".
    If the file already exists, it will be overwritten.
    It will be opened for the whole time #VmaAllocator object is alive.
    If opening this file fails, creation of the whole allocator object fails.
    */
    String filePath;
    
    EnumSet<VmaRecordFlagBits> getFlags()
    {
        return flags;
    }
    
    void setFlags(EnumSet<VmaRecordFlagBits> flags)
    {
        this.flags = flags;
    }
    
    String getFilePath()
    {
        return filePath;
    }
    
    void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }
    
}

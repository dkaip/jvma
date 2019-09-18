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

import java.util.Collection;

public class VmaStats
{
    Collection<VmaStatInfo> memoryType;
    Collection<VmaStatInfo> memoryHeap;
    VmaStatInfo             total;
    
    public Collection<VmaStatInfo> getMemoryType()
    {
        return memoryType;
    }
    
    void setMemoryType(Collection<VmaStatInfo> memoryType)
    {
        this.memoryType = memoryType;
    }
    
    public Collection<VmaStatInfo> getMemoryHeap()
    {
        return memoryHeap;
    }
    
    void setMemoryHeap(Collection<VmaStatInfo> memoryHeap)
    {
        this.memoryHeap = memoryHeap;
    }
    
    public VmaStatInfo getTotal()
    {
        return total;
    }
    void setTotal(VmaStatInfo total)
    {
        this.total = total;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\nVmaStats\n"));
        
        sb.append(String.format("    \nMemoryTypes\n"));
        int i = 0;
        for(VmaStatInfo temp : memoryType)
        {
            sb.append(String.format("    memoryType:%d:%s\n", i++, temp.toString()));
        }

        sb.append(String.format("    \nMemoryHeaps\n"));
        i = 0;
        for(VmaStatInfo temp : memoryHeap)
        {
            sb.append(String.format("    memoryHeap:%d:%s\n", i++, temp.toString()));
        }

        sb.append(String.format("    total:%s\n", total.toString()));
        
        return sb.toString();
    }
}

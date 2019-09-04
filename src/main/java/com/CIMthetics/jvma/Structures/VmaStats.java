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

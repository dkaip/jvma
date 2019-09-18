package com.CIMthetics.jvma.Structures;

import java.util.Collection;
import java.util.EnumSet;

import com.CIMthetics.jvma.Enums.VmaDefragmentationFlagBits;
import com.CIMthetics.jvma.Handles.VmaAllocation;
import com.CIMthetics.jvma.Handles.VmaPool;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Handles.VkCommandBuffer;

public class VmaDefragmentationInfo2
{
    /** \brief Reserved for future use. Should be 0.
    */
    EnumSet<VmaDefragmentationFlagBits> flags = EnumSet.noneOf(VmaDefragmentationFlagBits.class);
    /** \brief Pointer to array of allocations that can be defragmented.

    The array should have `allocationCount` elements.
    The array should not contain nulls.
    Elements in the array should be unique - same allocation cannot occur twice.
    It is safe to pass allocations that are in the lost state - they are ignored.
    All allocations not present in this array are considered non-moveable during this defragmentation.
    */
    Collection<VmaAllocation> allocations;
    /** \brief Optional, output. Pointer to array that will be filled with information whether the allocation at certain index has been changed during defragmentation.

    The array should have `allocationCount` elements.
    You can pass null if you are not interested in this information.
    <p>
    If you want this data back in Java just do <code>setAllocationsChanged(new boolean[0]);</code>
    to make it non null...it will be replaced by a loaded array.
    */
    boolean[] allocationsChanged;
    /** \brief Either null or pointer to array of pools to be defragmented.

    All the allocations in the specified pools can be moved during defragmentation
    and there is no way to check if they were really moved as in `pAllocationsChanged`,
    so you must query all the allocations in all these pools for new `VkDeviceMemory`
    and offset using vmaGetAllocationInfo() if you might need to recreate buffers
    and images bound to them.

    The array should have `poolCount` elements.
    The array should not contain nulls.
    Elements in the array should be unique - same pool cannot occur twice.

    Using this array is equivalent to specifying all allocations from the pools in `pAllocations`.
    It might be more efficient.
    */
    Collection<VmaPool> pools;
    /** \brief Maximum total numbers of bytes that can be copied while moving allocations to different places using transfers on CPU side, like `memcpy()`, `memmove()`.
    
    `VK_WHOLE_SIZE` means no limit.
    */
    long maxCpuBytesToMove;
    /** \brief Maximum number of allocations that can be moved to a different place using transfers on CPU side, like `memcpy()`, `memmove()`.

    `UINT32_MAX` means no limit.
    */
    int maxCpuAllocationsToMove;
    /** \brief Maximum total numbers of bytes that can be copied while moving allocations to different places using transfers on GPU side, posted to `commandBuffer`.
    
    `VK_WHOLE_SIZE` means no limit.
    */
    long maxGpuBytesToMove;
    /** \brief Maximum number of allocations that can be moved to a different place using transfers on GPU side, posted to `commandBuffer`.

    `UINT32_MAX` means no limit.
    */
    int maxGpuAllocationsToMove;
    /** \brief Optional. Command buffer where GPU copy commands will be posted.

    If not null, it must be a valid command buffer handle that supports Transfer queue type.
    It must be in the recording state and outside of a render pass instance.
    You need to submit it and make sure it finished execution before calling vmaDefragmentationEnd().

    Passing null means that only CPU defragmentation will be performed.
    */
    VkCommandBuffer commandBuffer;
    
    public EnumSet<VmaDefragmentationFlagBits> getFlags()
    {
        return flags;
    }
    
    public void setFlags(EnumSet<VmaDefragmentationFlagBits> flags)
    {
        this.flags = flags;
    }
    
    public Collection<VmaAllocation> getAllocations()
    {
        return allocations;
    }
    
    public void setAllocations(Collection<VmaAllocation> allocations)
    {
        this.allocations = allocations;
    }
    
    public boolean[] getAllocationsChanged()
    {
        return allocationsChanged;
    }
    
    public void setAllocationsChanged(boolean[] allocationsChanged)
    {
        this.allocationsChanged = allocationsChanged;
    }
    
    public Collection<VmaPool> getPools()
    {
        return pools;
    }
    
    public void setPools(Collection<VmaPool> pools)
    {
        this.pools = pools;
    }
    
    public long getMaxCpuBytesToMove()
    {
        return maxCpuBytesToMove;
    }
    
    public void setMaxCpuBytesToMove(long maxCpuBytesToMove)
    {
        this.maxCpuBytesToMove = maxCpuBytesToMove;
    }
    
    public int getMaxCpuAllocationsToMove()
    {
        return maxCpuAllocationsToMove;
    }
    
    public void setMaxCpuAllocationsToMove(int maxCpuAllocationsToMove)
    {
        this.maxCpuAllocationsToMove = maxCpuAllocationsToMove;
    }
    
    public long getMaxGpuBytesToMove()
    {
        return maxGpuBytesToMove;
    }
    public void setMaxGpuBytesToMove(long maxGpuBytesToMove)
    {
        this.maxGpuBytesToMove = maxGpuBytesToMove;
    }
    
    
    public int getMaxGpuAllocationsToMove()
    {
        return maxGpuAllocationsToMove;
    }
    
    public void setMaxGpuAllocationsToMove(int maxGpuAllocationsToMove)
    {
        this.maxGpuAllocationsToMove = maxGpuAllocationsToMove;
    }
    
    public VkCommandBuffer getCommandBuffer()
    {
        return commandBuffer;
    }
    
    public void setCommandBuffer(VkCommandBuffer commandBuffer)
    {
        this.commandBuffer = commandBuffer;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\nVmaDefragmentationInfo2\n"));
        
        sb.append(String.format("    flags:%s\n", flags.toString()));
        int i = 0;
        for(VmaAllocation allocation : allocations)
        {
            sb.append(String.format("    allocation %d:%s\n", i++, allocation.toString()));
        }

        if (allocationsChanged == null)
            sb.append(String.format("    allocationsChanged:%s\n", "null"));
        else
        {
            for(i = 0; i < allocationsChanged.length; i++)
            {
                sb.append(String.format("    allocationsChanged[%d]:%b\n", i, allocationsChanged[i]));
            }
        }

        if (pools == null)
        {
            sb.append(String.format("    pools:%s\n", "null"));
        }
        else
        {
            i = 0;
            for(VmaPool pool : pools)
            {
                sb.append(String.format("    pool %d:%s\n", i++, pool.toString()));
            }
            
        }

        sb.append(String.format("    maxCpuBytesToMove:%d\n", maxCpuBytesToMove));
        sb.append(String.format("    maxCpuAllocationsToMove:%d\n", maxCpuAllocationsToMove));
        sb.append(String.format("    maxGpuBytesToMove:%d\n", maxGpuBytesToMove));
        sb.append(String.format("    maxGpuAllocationsToMove:%d\n", maxGpuAllocationsToMove));
        
        sb.append(String.format("    commandBuffer:%s", commandBuffer == null ? "null" : commandBuffer.toString()));
        
        return sb.toString();
    }
}

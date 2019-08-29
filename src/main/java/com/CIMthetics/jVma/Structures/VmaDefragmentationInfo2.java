package com.CIMthetics.jVma.Structures;

import java.util.EnumSet;

import com.CIMthetics.jVma.Enums.VmaDefragmentationFlagBits;
import com.CIMthetics.jVma.Handles.VmaAllocation;
import com.CIMthetics.jVma.Handles.VmaPool;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Handles.VkCommandBuffer;

public class VmaDefragmentationInfo2
{
    /** \brief Reserved for future use. Should be 0.
    */
    EnumSet<VmaDefragmentationFlagBits> flags = EnumSet.noneOf(VmaDefragmentationFlagBits.class);
    /** \brief Number of allocations in `pAllocations` array.
    */
    int allocationCount;
    /** \brief Pointer to array of allocations that can be defragmented.

    The array should have `allocationCount` elements.
    The array should not contain nulls.
    Elements in the array should be unique - same allocation cannot occur twice.
    It is safe to pass allocations that are in the lost state - they are ignored.
    All allocations not present in this array are considered non-moveable during this defragmentation.
    */
    VmaAllocation[] allocations;
    /** \brief Optional, output. Pointer to array that will be filled with information whether the allocation at certain index has been changed during defragmentation.

    The array should have `allocationCount` elements.
    You can pass null if you are not interested in this information.
    */
    boolean[] allocationsChanged;
    /** \brief Numer of pools in `pPools` array.
    */
    int poolCount;
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
    VmaPool[] pools;
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
}

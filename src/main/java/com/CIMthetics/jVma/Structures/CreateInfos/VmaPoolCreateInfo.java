package com.CIMthetics.jVma.Structures.CreateInfos;

import java.util.EnumSet;

import com.CIMthetics.jVma.Enums.VmaPoolCreateFlagBits;

public class VmaPoolCreateInfo
{
    /** \brief Vulkan memory type index to allocate this pool from.
    */
    int memoryTypeIndex;
    /** \brief Use combination of #VmaPoolCreateFlagBits.
    */
    EnumSet<VmaPoolCreateFlagBits> flags = EnumSet.noneOf(VmaPoolCreateFlagBits.class);
    /** \brief Size of a single `VkDeviceMemory` block to be allocated as part of this pool, in bytes. Optional.

    Specify nonzero to set explicit, constant size of memory blocks used by this
    pool.

    Leave 0 to use default and let the library manage block sizes automatically.
    Sizes of particular blocks may vary.
    */
    long blockSize;
    /** \brief Minimum number of blocks to be always allocated in this pool, even if they stay empty.

    Set to 0 to have no preallocated blocks and allow the pool be completely empty.
    */
    long minBlockCount;
    /** \brief Maximum number of blocks that can be allocated in this pool. Optional.

    Set to 0 to use default, which is `SIZE_MAX`, which means no limit.
    
    Set to same value as VmaPoolCreateInfo::minBlockCount to have fixed amount of memory allocated
    throughout whole lifetime of this pool.
    */
    long maxBlockCount;
    /** \brief Maximum number of additional frames that are in use at the same time as current frame.

    This value is used only when you make allocations with
    #VMA_ALLOCATION_CREATE_CAN_BECOME_LOST_BIT flag. Such allocation cannot become
    lost if allocation.lastUseFrameIndex >= allocator.currentFrameIndex - frameInUseCount.

    For example, if you double-buffer your command buffers, so resources used for
    rendering in previous frame may still be in use by the GPU at the moment you
    allocate resources needed for the current frame, set this value to 1.

    If you want to allow any allocations other than used in the current frame to
    become lost, set this value to 0.
    */
    int frameInUseCount;
}

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

public enum VmaAllocationCreateFlagBits
{
    /** \brief Set this flag if the allocation should have its own memory block.
    
    Use it for special, big resources, like fullscreen images used as attachments.
   
    This flag must also be used for host visible resources that you want to map
    simultaneously because otherwise they might end up as regions of the same
    `VkDeviceMemory`, while mapping same `VkDeviceMemory` multiple times
    simultaneously is illegal.

    You should not use this flag if VmaAllocationCreateInfo::pool is not null.
    */
    VMA_ALLOCATION_CREATE_DEDICATED_MEMORY_BIT(0x00000001),

    /** \brief Set this flag to only try to allocate from existing `VkDeviceMemory` blocks and never create new such block.
    
    If new allocation cannot be placed in any of the existing blocks, allocation
    fails with `VK_ERROR_OUT_OF_DEVICE_MEMORY` error.
    
    You should not use #VMA_ALLOCATION_CREATE_DEDICATED_MEMORY_BIT and
    #VMA_ALLOCATION_CREATE_NEVER_ALLOCATE_BIT at the same time. It makes no sense.
    
    If VmaAllocationCreateInfo::pool is not null, this flag is implied and ignored. */
    VMA_ALLOCATION_CREATE_NEVER_ALLOCATE_BIT(0x00000002),
    /**
     * Set this flag to use a memory that will be persistently mapped and retrieve pointer to it.
     * <p>
     * The pointer to mapped memory will be returned through <code>VmaAllocationInfo::pMappedData</code>.
     * <p>
     * Is it valid to use this flag for allocation made from memory type that is <b>not</b>
     * `HOST_VISIBLE`. This flag is then ignored and memory is not mapped. This is
     * useful if you need an allocation that is efficient to use on GPU
     * (`DEVICE_LOCAL`) and still want to map it directly if possible on platforms 
     * that support it (e.g. Intel GPU).
     * <p>
     *  You should not use this flag together with #VMA_ALLOCATION_CREATE_CAN_BECOME_LOST_BIT.
     */
    VMA_ALLOCATION_CREATE_MAPPED_BIT(0x00000004),
    /** Allocation created with this flag can become lost as a result of another
    allocation with #VMA_ALLOCATION_CREATE_CAN_MAKE_OTHER_LOST_BIT flag, so you
    must check it before use.

    To check if allocation is not lost, call vmaGetAllocationInfo() and check if
    VmaAllocationInfo::deviceMemory is not `VK_NULL_HANDLE`.

    For details about supporting lost allocations, see Lost Allocations
    chapter of User Guide on Main Page.

    You should not use this flag together with #VMA_ALLOCATION_CREATE_MAPPED_BIT.
    */
    VMA_ALLOCATION_CREATE_CAN_BECOME_LOST_BIT(0x00000008),
    /** While creating allocation using this flag, other allocations that were
    created with flag #VMA_ALLOCATION_CREATE_CAN_BECOME_LOST_BIT can become lost.

    For details about supporting lost allocations, see Lost Allocations
    chapter of User Guide on Main Page.
    */
    VMA_ALLOCATION_CREATE_CAN_MAKE_OTHER_LOST_BIT(0x00000010),
    /** Set this flag to treat VmaAllocationCreateInfo::pUserData as pointer to a
    null-terminated string. Instead of copying pointer value, a local copy of the
    string is made and stored in allocation's `pUserData`. The string is automatically
    freed together with the allocation. It is also used in vmaBuildStatsString().
    */
    VMA_ALLOCATION_CREATE_USER_DATA_COPY_STRING_BIT(0x00000020),
    /** Allocation will be created from upper stack in a double stack pool.

    This flag is only allowed for custom pools created with #VMA_POOL_CREATE_LINEAR_ALGORITHM_BIT flag.
    */
    VMA_ALLOCATION_CREATE_UPPER_ADDRESS_BIT(0x00000040),

    /** Allocation strategy that chooses smallest possible free range for the
    allocation.
    */
    VMA_ALLOCATION_CREATE_STRATEGY_BEST_FIT_BIT(0x00010000),
    /** Allocation strategy that chooses biggest possible free range for the
    allocation.
    */
    VMA_ALLOCATION_CREATE_STRATEGY_WORST_FIT_BIT(0x00020000),
    /** Allocation strategy that chooses first suitable free range for the
    allocation.

    "First" doesn't necessarily means the one with smallest offset in memory,
    but rather the one that is easiest and fastest to find.
    */
    VMA_ALLOCATION_CREATE_STRATEGY_FIRST_FIT_BIT(0x00040000),

    /** Allocation strategy that tries to minimize memory usage.
    */
    VMA_ALLOCATION_CREATE_STRATEGY_MIN_MEMORY_BIT(VMA_ALLOCATION_CREATE_STRATEGY_BEST_FIT_BIT.valueOf()),
    /** Allocation strategy that tries to minimize allocation time.
    */
    VMA_ALLOCATION_CREATE_STRATEGY_MIN_TIME_BIT(VMA_ALLOCATION_CREATE_STRATEGY_FIRST_FIT_BIT.valueOf()),
    /** Allocation strategy that tries to minimize memory fragmentation.
    */
    VMA_ALLOCATION_CREATE_STRATEGY_MIN_FRAGMENTATION_BIT(VMA_ALLOCATION_CREATE_STRATEGY_WORST_FIT_BIT.valueOf()),

//    /** A bit mask to extract only `STRATEGY` bits from entire set of flags.
//    */
//    VMA_ALLOCATION_CREATE_STRATEGY_MASK =
//        VMA_ALLOCATION_CREATE_STRATEGY_BEST_FIT_BIT |
//        VMA_ALLOCATION_CREATE_STRATEGY_WORST_FIT_BIT |
//        VMA_ALLOCATION_CREATE_STRATEGY_FIRST_FIT_BIT,
//
    VMA_ALLOCATION_CREATE_FLAG_BITS_MAX_ENUM(0x7FFFFFFF);

    private int value;
    
    private VmaAllocationCreateFlagBits(int value) { this.value = value; }
    
    public int valueOf() { return value; }
}

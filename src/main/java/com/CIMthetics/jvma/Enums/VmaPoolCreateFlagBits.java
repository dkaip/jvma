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

public enum VmaPoolCreateFlagBits
{
    /** \brief Use this flag if you always allocate only buffers and linear images or only optimal images out of this pool and so Buffer-Image Granularity can be ignored.

    This is an optional optimization flag.

    If you always allocate using vmaCreateBuffer(), vmaCreateImage(),
    vmaAllocateMemoryForBuffer(), then you don't need to use it because allocator
    knows exact type of your allocations so it can handle Buffer-Image Granularity
    in the optimal way.

    If you also allocate using vmaAllocateMemoryForImage() or vmaAllocateMemory(),
    exact type of such allocations is not known, so allocator must be conservative
    in handling Buffer-Image Granularity, which can lead to suboptimal allocation
    (wasted memory). In that case, if you can make sure you always allocate only
    buffers and linear images or only optimal images out of this pool, use this flag
    to make allocator disregard Buffer-Image Granularity and so make allocations
    faster and more optimal.
    */
    VMA_POOL_CREATE_IGNORE_BUFFER_IMAGE_GRANULARITY_BIT(0x00000002),

    /** \brief Enables alternative, linear allocation algorithm in this pool.

    Specify this flag to enable linear allocation algorithm, which always creates
    new allocations after last one and doesn't reuse space from allocations freed in
    between. It trades memory consumption for simplified algorithm and data
    structure, which has better performance and uses less memory for metadata.

    By using this flag, you can achieve behavior of free-at-once, stack,
    ring buffer, and double stack. For details, see documentation chapter
    \ref linear_algorithm.

    When using this flag, you must specify VmaPoolCreateInfo::maxBlockCount == 1 (or 0 for default).

    For more details, see [Linear allocation algorithm](@ref linear_algorithm).
    */
    VMA_POOL_CREATE_LINEAR_ALGORITHM_BIT(0x00000004),

    /** \brief Enables alternative, buddy allocation algorithm in this pool.

    It operates on a tree of blocks, each having size that is a power of two and
    a half of its parent's size. Comparing to default algorithm, this one provides
    faster allocation and deallocation and decreased external fragmentation,
    at the expense of more memory wasted (internal fragmentation).

    For more details, see [Buddy allocation algorithm](@ref buddy_algorithm).
    */
    VMA_POOL_CREATE_BUDDY_ALGORITHM_BIT(0x00000008),

//    /** Bit mask to extract only `ALGORITHM` bits from entire set of flags.
//    */
//    VMA_POOL_CREATE_ALGORITHM_MASK =
//        VMA_POOL_CREATE_LINEAR_ALGORITHM_BIT |
//        VMA_POOL_CREATE_BUDDY_ALGORITHM_BIT,
//
    VMA_POOL_CREATE_FLAG_BITS_MAX_ENUM(0x7FFFFFFF);
    
    private int value;
    
    private VmaPoolCreateFlagBits(int value) { this.value = value; }
    
    public int valueOf() { return value; }
}

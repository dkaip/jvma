package com.CIMthetics.jvma.Structures;

public class VmaDefragmentationInfo
{
    /** \brief Maximum total numbers of bytes that can be copied while moving allocations to different places.
    
    Default is `VK_WHOLE_SIZE`, which means no limit.
    */
    long maxBytesToMove;
    /** \brief Maximum number of allocations that can be moved to different place.

    Default is `UINT32_MAX`, which means no limit.
    */
    int maxAllocationsToMove;
}

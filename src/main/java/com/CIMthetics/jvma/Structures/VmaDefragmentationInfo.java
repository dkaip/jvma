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

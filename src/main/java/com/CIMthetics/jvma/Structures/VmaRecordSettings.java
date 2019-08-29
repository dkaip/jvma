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
    String pFilePath;
}

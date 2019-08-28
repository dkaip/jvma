package com.CIMthetics.jVma.Structures;

import java.util.EnumSet;

import com.CIMthetics.jVma.Enums.VmaRecordFlagBits;

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

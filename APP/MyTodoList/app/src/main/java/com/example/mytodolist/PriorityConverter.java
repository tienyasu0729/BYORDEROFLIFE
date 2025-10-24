package com.example.mytodolist; // Thay bằng tên gói của bạn

import androidx.room.TypeConverter;

public class PriorityConverter {
    @TypeConverter
    public static String fromPriority(Priority priority) {
        return priority == null ? null : priority.name();
    }

    @TypeConverter
    public static Priority toPriority(String priorityString) {
        return priorityString == null ? null : Priority.valueOf(priorityString);
    }
}
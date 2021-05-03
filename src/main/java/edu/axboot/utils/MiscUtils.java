package edu.axboot.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class MiscUtils {
    public static <T> Page<T> toPage(List<T> list, Pageable pageable) {
        if (list == null) {
            throw new IllegalArgumentException("argument `list` is required!!");
        }
        if (pageable == null) {
            throw new IllegalArgumentException("argument `pageable` is required!!");
        }

        int total = list.size();
        int start = pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), total);
        if(start > total) return new PageImpl<>(new ArrayList<>(), pageable, total);
        return new PageImpl<>(list.subList(start, end), pageable, list.size());
    }
}

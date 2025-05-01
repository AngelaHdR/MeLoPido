package com.fpmislata.MeLoPido.util.pagination;

import com.fpmislata.MeLoPido.util.exception.PagedCollectionException;

import java.util.List;

public record Page<T>(
        List<T> data,
        int pageNumber,
        int pageSize,
        long totalElements,
        int totalPages
) {
    public Page(List<T> data, int pageNumber, int pageSize, long totalElements) {
        this(
                validateDataSize(data, pageSize), //Data size cannot be greater than page size nor null
                validatePageNumber(pageNumber), //Number can't be negative
                validatePageSize(pageSize), //Size must be greater than zero
                totalElements,
                (int) Math.ceil((double) totalElements / pageSize)
        );
    }

    private static <T> List<T> validateDataSize(List<T> data, int pageSize) {
        if (data == null) {
            throw new PagedCollectionException("Data cannot be null");
        }
        if (data.size() > pageSize) {
            throw new PagedCollectionException("Data size cannot be greater than page size");
        }
        return data;
    }

    private static int validatePageNumber(int pageNumber) {
        if (pageNumber < 0) {
            throw new PagedCollectionException("Page number cannot be negative");
        }
        return pageNumber;
    }

    private static int validatePageSize(int pageSize) {
        if (pageSize <= 0) {
            throw new PagedCollectionException("Page size must be greater than zero");
        }
        return pageSize;
    }
}

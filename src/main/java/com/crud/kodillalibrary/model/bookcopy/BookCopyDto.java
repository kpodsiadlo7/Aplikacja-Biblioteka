package com.crud.kodillalibrary.model.bookcopy;

public class BookCopyDto {
    private Long copyBookId;
    private Long statusId;

    Long getCopyBookId() {
        return copyBookId;
    }

    void setCopyBookId(final Long copyBookId) {
        this.copyBookId = copyBookId;
    }

    Long getStatusId() {
        return statusId;
    }

    void setStatusId(final Long statusId) {
        this.statusId = statusId;
    }
}

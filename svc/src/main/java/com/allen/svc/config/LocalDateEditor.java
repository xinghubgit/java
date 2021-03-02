package com.allen.svc.config;

import org.springframework.util.Assert;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @date 2020/12/3
 */

public class LocalDateEditor extends PropertyEditorSupport {
    private final boolean nullAsEmpty;

    public LocalDateEditor() {
        this(false);
    }

    public LocalDateEditor(boolean nullAsEmpty) {
        this.nullAsEmpty = nullAsEmpty;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(LocalDate.parse(text, DateTimeFormatter.ISO_DATE));
    }
}

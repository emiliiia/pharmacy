package com.emilia.pharmacy.form;

import java.time.LocalDate;

/*
  @author emilia
  @project pharmacy
  @className SearchForm
  @version 1.0.0
  @since 05.07.2022
*/
public class SearchForm {
    private String string;
    public SearchForm() {
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "SearchForm{" +
                "string='" + string + '\'' +
                '}';
    }
}

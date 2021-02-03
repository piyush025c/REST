package org.example.dao;

import org.example.model.DrugOfMonthDetails;

import java.util.List;

public interface DrugOfMonthDao {

    public List<DrugOfMonthDetails> getDrugOfMonth(String city);
}

package org.example.dao;

import org.example.model.RepOfMonthDetails;
import org.example.model.SalesRep;

import java.util.List;

public interface RepOfMonthDao {

    public List<RepOfMonthDetails> getSalesRepOfMonth(int month, String product);

}

package org.example.dao;

import org.example.model.SalesRep;

import java.util.List;

public interface SalesRepDao {

    public List<SalesRep> getAllSalesRep();
    public void addSalesRep(SalesRep salesRep);
    public void updateSalesRep(SalesRep salesRep);
    public void deleteSalesRep(int salesRepId);
    public List<SalesRep> getSearchResult(String prefix);
}

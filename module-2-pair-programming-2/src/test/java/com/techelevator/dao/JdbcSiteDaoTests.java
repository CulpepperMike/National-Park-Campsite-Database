package com.techelevator.dao;

import com.techelevator.model.Site;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JdbcSiteDaoTests extends BaseDaoTests {

    private SiteDao dao;

    @Before
    public void setup() {
        dao = new JdbcSiteDao(dataSource);
    }

    @Test
    public void getSitesWithRVAccessByParkId_Should_Return_Sites_With_Positive_RV_Length() {
        List<Site> sites = dao.getSitesWithRVAccessByParkId(1);
        Assert.assertEquals("Incorrect number of listed sites with RV access.", 2, sites.size());
    }

    @Test
    public void getSitesWithoutReservationByParkId_Should_Return_Available_Parks() {
        List<Site> sites = dao.getSitesWithoutReservationByParkId(1);
        assertEquals("Incorrect count of currently available sites", 5, sites.size());

    }
}

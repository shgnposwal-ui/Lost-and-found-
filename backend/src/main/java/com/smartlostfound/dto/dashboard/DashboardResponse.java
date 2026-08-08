package com.smartlostfound.dto.dashboard;

public class DashboardResponse {

    private Long totalUsers;
    private Long totalLostItems;
    private Long totalFoundItems;

    public DashboardResponse() {
    }

    public Long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(Long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public Long getTotalLostItems() {
        return totalLostItems;
    }

    public void setTotalLostItems(Long totalLostItems) {
        this.totalLostItems = totalLostItems;
    }

    public Long getTotalFoundItems() {
        return totalFoundItems;
    }

    public void setTotalFoundItems(Long totalFoundItems) {
        this.totalFoundItems = totalFoundItems;
    }
}
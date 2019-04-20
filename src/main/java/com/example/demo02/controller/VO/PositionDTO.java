package com.example.demo02.controller.VO;


public class PositionDTO {
    private String positionName;
    /**
     * 岗位级别
     */
    private Integer level;

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
